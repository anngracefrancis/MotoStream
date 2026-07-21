import asyncio
from bleak import BleakClient

# UUIDs found from previous scan
TARGET_DEVICES = [
    ("2502200A1DS053", "91D1516D-57FC-DCDA-E087-A9B0D3E0DE37"),
    ("DL_B09W6EFF56FA205", "277260CB-CC15-B383-85FD-477138965258")
]

async def probe_device(name, address):
    print(f"\n--- Probing {name} [{address}] ---")
    try:
        async with BleakClient(address, timeout=5.0) as client:
            print(f"Connected to {name}!")
            services = client.services
            found_tripper = False
            for service in services:
                print(f"  Service: {service.uuid}")
                if "74686562-6c75-6172-6d6f-722e636f6d00" in service.uuid.lower():
                    found_tripper = True
                for char in service.characteristics:
                    print(f"    Char: {char.uuid} ({', '.join(char.properties)})")
            
            if found_tripper:
                print(f"🏍️ THIS IS THE TRIPPER BIKE! ({name})")
            else:
                print("Not the Tripper bike.")
    except Exception as e:
        print(f"Could not connect to {name}: {e}")

async def run():
    for name, address in TARGET_DEVICES:
        await probe_device(name, address)
        
if __name__ == "__main__":
    asyncio.run(run())
