import asyncio
import logging
from bless import (
    BlessServer,
    BlessGATTCharacteristic,
    GATTCharacteristicProperties,
    GATTAttributePermissions
)
from cryptography.hazmat.primitives import serialization
from cryptography.hazmat.primitives.asymmetric import padding
from cryptography.hazmat.primitives import hashes

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')
logger = logging.getLogger("MockTripperServer")

# ==========================================
# Real Royal Enfield Tripper Pod UUIDs (BluArmor)
# ==========================================
SERVICE_UUID = "74686562-6c75-6172-6d6f-722e636f6d00"
HANDSHAKE_CHAR_UUID = "74686562-6c75-6172-6d6f-722e636f6d01" 

# Load the private key
try:
    with open("private_key.pem", "rb") as key_file:
        private_key = serialization.load_pem_private_key(
            key_file.read(),
            password=None,
        )
    logger.info("Loaded private_key.pem successfully.")
except Exception as e:
    logger.error(f"Could not load private_key.pem: {e}")
    private_key = None

def read_request(characteristic: BlessGATTCharacteristic, **kwargs) -> bytearray:
    logger.info(f"Read request for {characteristic.uuid}")
    return characteristic.value

def write_request(characteristic: BlessGATTCharacteristic, value: bytearray, **kwargs):
    logger.info(f"Write request to {characteristic.uuid}: {value.hex()}")
    characteristic.value = value
    
    # ==========================================
    # HANDSHAKE LOGIC
    # ==========================================
    if characteristic.uuid == HANDSHAKE_CHAR_UUID.lower():
        logger.info(f"[!] Handshake payload received: {value.hex()}")
        if private_key:
            try:
                # Attempt to decrypt using PKCS1v15 (common in older/custom protocols)
                decrypted = private_key.decrypt(
                    bytes(value),
                    padding.PKCS1v15()
                )
                logger.info(f"✅ Handshake successfully decrypted: {decrypted}")
            except Exception as e:
                pass # Probably not a handshake, just regular data
        else:
            logger.warning("No private key loaded to decrypt handshake.")
            
        # Parse K1G Packets
        if b"K1G " in value:
            logger.info(f"🏍️ [NAV PACKET DETECTED] Total Length: {len(value)} bytes")
            logger.info(f"📦 Raw Hex: {value.hex().upper()}")
            # If we see 05 02 (Primary Maneuver TLV), we know it's working!
            if b"\x05\x02\x00\x01" in value:
                idx = value.find(b"\x05\x02\x00\x01")
                maneuver_id = value[idx+4]
                logger.info(f"➡️ Maneuver ID: {hex(maneuver_id)}")
            if b"\x05\x04\x00\x02" in value:
                idx = value.find(b"\x05\x04\x00\x02")
                dist = int.from_bytes(value[idx+4:idx+6], byteorder='big')
                logger.info(f"📏 Distance: {dist}")

async def run(loop):
    # Name the device something the iOS app looks for
    server = BlessServer(name="Tripper Mock", loop=loop)
    server.read_request_func = read_request
    server.write_request_func = write_request

    try:
        # Add the primary service
        await server.add_new_service(SERVICE_UUID)
        
        # Define characteristics (e.g., read, write, notify)
        char_flags = (
            GATTCharacteristicProperties.read |
            GATTCharacteristicProperties.write |
            GATTCharacteristicProperties.notify
        )
        permissions = (
            GATTAttributePermissions.readable |
            GATTAttributePermissions.writeable
        )
        
        # Add the handshake characteristic
        await server.add_new_characteristic(
            SERVICE_UUID,
            HANDSHAKE_CHAR_UUID,
            char_flags,
            None,
            permissions
        )

        logger.info("Starting Mock Tripper BLE server...")
        logger.info("Waiting for iOS App to connect...")
        await server.start()
        
        # Keep the server running
        while True:
            await asyncio.sleep(1)
            
    except Exception as e:
        logger.error(f"Server error: {e}")
    finally:
        logger.info("Stopping BLE server...")
        await server.stop()

if __name__ == "__main__":
    loop = asyncio.get_event_loop()
    loop.run_until_complete(run(loop))
