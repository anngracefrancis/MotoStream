from scapy.all import rdpcap, UDP
pcap = rdpcap('tripper_stream.pcap')
count = 0
for pkt in pcap:
    if UDP in pkt and pkt[UDP].dport == 5000:
        payload = bytes(pkt[UDP].payload)
        print(f"Packet {count} length: {len(payload)}")
        print(f"Hex: {payload[:32].hex()}")
        count += 1
        if count >= 3:
            break
