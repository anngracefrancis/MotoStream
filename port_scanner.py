import socket
import concurrent.futures

target = "192.0.0.1"
print(f"Scanning {target} for open streaming ports...")

# Common streaming and control ports
# RTSP: 554, 8554
# Miracast / Wi-Fi Display: 7236
# HTTP/WebSocket: 80, 8080, 8000
# AirPlay: 5000, 7000, 7100
# Android Auto / Custom TCP: 5000, 5277, 5278
common_ports = [80, 443, 554, 1024, 5000, 5277, 5278, 7000, 7100, 7236, 8000, 8080, 8554, 9000, 9999]

# We will also scan a range up to 10000 just in case
def check_port(port):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.settimeout(0.5)
        result = s.connect_ex((target, port))
        if result == 0:
            return port
    return None

# Prioritize common ports
open_ports = []
for p in common_ports:
    if check_port(p):
        open_ports.append(p)
        print(f"✅ Found open port: {p}")

print(f"\nScanning full range (1-10000)...")
with concurrent.futures.ThreadPoolExecutor(max_workers=50) as executor:
    results = executor.map(check_port, range(1, 10001))
    for r in results:
        if r and r not in open_ports:
            open_ports.append(r)
            print(f"✅ Found open port: {r}")

print("\n--- Scan Complete ---")
if open_ports:
    print(f"Open ports found on the bike: {open_ports}")
else:
    print("No open ports found on 192.0.0.1.")
