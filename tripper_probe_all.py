import asyncio
from bleak import BleakScanner, BleakClient

SERVICE_UUID = "74686562-6c75-6172-6d6f-722e636f6d00"
HANDSHAKE_CHAR = "74686562-6c75-6172-6d6f-722e636f6d01"

async def probe_device(device):
    name = device.name or "Unknown"
    address = device.address
    print(f"\n--- Probing {name} [{address}] ---")
    try:
        async with BleakClient(address, timeout=5.0) as client:
            services = client.services
            for service in services:
                if "74686562" in service.uuid.lower():
                    print(f"\n🏍️ FOUND THE TRIPPER BIKE! ({name} / {address})")
                    print("Service UUID matched!")
                    
                    # Try to write a test packet
                    print("Sending K1G test packet directly...")
                    test_packet = bytes.fromhex("003b000900000000020100054b31472000050200010b0504000201ba050600013005090002058e0546000130050a0001550605000155060d0001aa")
                    try:
                        await client.write_gatt_char(HANDSHAKE_CHAR, test_packet, response=False)
                        print("✅ Packet sent successfully! Did anything happen on the dashboard?")
                    except Exception as e:
                        print(f"❌ Failed to write packet: {e}")
                    
                    return True
            print("Not the Tripper bike.")
    except Exception as e:
        print(f"Could not connect: {e}")
    return False

async def run():
    print("Scanning for all nearby Bluetooth devices (takes 5s)...")
    devices_dict = await BleakScanner.discover(timeout=5.0, return_adv=True)
    devices = list(devices_dict.values())
    
    print(f"Found {len(devices)} devices. Actively connecting to each one to check their hidden services...")
    for d, adv in devices:
        # Skip obvious Apple devices to save time
        if d.name and ("mac" in d.name.lower() or "iphone" in d.name.lower() or "ipad" in d.name.lower() or "tv" in d.name.lower()):
            continue
        
        is_bike = await probe_device(d)
        if is_bike:
            break
            
if __name__ == "__main__":
    asyncio.run(run())
