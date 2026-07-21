import asyncio
from bleak import BleakScanner, BleakClient

SERVICE_UUID = "74686562-6c75-6172-6d6f-722e636f6d00"
HANDSHAKE_CHAR_UUID = "74686562-6c75-6172-6d6f-722e636f6d01"

async def run():
    print("Scanning for Bluetooth devices... (this takes 5 seconds)")
    devices_dict = await BleakScanner.discover(timeout=5.0, return_adv=True)
    
    tripper_device = None
    devices = list(devices_dict.values())
    for d, adv in devices:
        uuids = adv.service_uuids
        if SERVICE_UUID in uuids:
            tripper_device = d
            break
        if d.name and ("tripper" in d.name.lower() or "royal" in d.name.lower() or "re" in d.name.lower()):
            tripper_device = d
            break

    if not tripper_device:
        print("Could not find the bike! Make sure it's turned on, in range, and NOT currently connected to your phone.")
        print("Here are all the devices found:")
        for d, adv in devices:
            print(f" - {d.name} [{d.address}]")
        return

    print(f"🏍️ Found Bike: {tripper_device.name} [{tripper_device.address}]")
    print("Connecting...")
    
    try:
        async with BleakClient(tripper_device.address, timeout=10.0) as client:
            print(f"✅ Connected: {client.is_connected}")
            
            print("\n--- Services and Characteristics ---")
            for service in client.services:
                print(f"[Service] {service.uuid}")
                for char in service.characteristics:
                    print(f"  [Characteristic] {char.uuid} (Properties: {', '.join(char.properties)})")
            print("------------------------------------\n")
            
            # Setup notification handler
            def notification_handler(sender, data):
                print(f"🔔 Received from bike ({sender}): {data.hex()}")
                
            # Try to subscribe to notifications on the handshake char
            try:
                await client.start_notify(HANDSHAKE_CHAR_UUID, notification_handler)
                print("Started listening for bike messages (notifications)...")
            except Exception as e:
                print(f"Could not enable notifications: {e}")

            print("Waiting 10 seconds to see if the bike says anything first...")
            await asyncio.sleep(10)
            
            # Try sending a dummy K1G packet just to see if it responds!
            print("Sending test K1G packet...")
            test_packet = bytes.fromhex("003b000900000000020100054b31472000050200010b0504000201ba050600013005090002058e0546000130050a0001550605000155060d0001aa")
            try:
                await client.write_gatt_char(HANDSHAKE_CHAR_UUID, test_packet, response=False)
                print("Sent packet! Waiting 5 more seconds for a response...")
                await asyncio.sleep(5)
            except Exception as e:
                print(f"Failed to send packet: {e}")
                
            print("Done exploring! Disconnecting.")
            
    except Exception as e:
        print(f"❌ Connection failed: {e}")

if __name__ == "__main__":
    asyncio.run(run())
