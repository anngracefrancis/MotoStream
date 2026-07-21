import socket
import struct
import binascii

def parse_pcap(filename):
    with open(filename, 'rb') as f:
        # PCAP Global Header (24 bytes)
        global_header = f.read(24)
        if not global_header:
            return
            
        print("--- PCAP UDP ANALYSIS ---")
        packet_num = 0
        
        while True:
            # PCAP Packet Header (16 bytes)
            header = f.read(16)
            if len(header) < 16:
                break
                
            ts_sec, ts_usec, incl_len, orig_len = struct.unpack('<IIII', header)
            packet_data = f.read(incl_len)
            packet_num += 1
            
            # Ethernet Header (14 bytes)
            if len(packet_data) < 14: continue
            eth_type = struct.unpack('!H', packet_data[12:14])[0]
            if eth_type != 0x0800: continue # IPv4 only
            
            # IP Header (min 20 bytes)
            ip_header_start = 14
            if len(packet_data) < ip_header_start + 20: continue
            ip_vhl = packet_data[ip_header_start]
            ip_header_length = (ip_vhl & 0x0F) * 4
            protocol = packet_data[ip_header_start + 9]
            if protocol != 17: continue # UDP only
            
            src_ip = socket.inet_ntoa(packet_data[ip_header_start+12:ip_header_start+16])
            dst_ip = socket.inet_ntoa(packet_data[ip_header_start+16:ip_header_start+20])
            
            # UDP Header (8 bytes)
            udp_header_start = ip_header_start + ip_header_length
            if len(packet_data) < udp_header_start + 8: continue
            src_port, dst_port, udp_len = struct.unpack('!HHH', packet_data[udp_header_start:udp_header_start+6])
            
            udp_payload_start = udp_header_start + 8
            udp_payload = packet_data[udp_payload_start:udp_payload_start + udp_len - 8]
            
            # Port 2000: Phone -> Bike Handshake/Heartbeat
            if dst_port == 2000 and packet_num < 50:
                print(f"[{packet_num}] Phone->Bike (Port 2000) [{len(udp_payload)} bytes]: {binascii.hexlify(udp_payload).decode('utf-8')}")
                
            # Port 2002: Bike -> Phone Telemetry
            if dst_port == 2002 and packet_num < 50:
                print(f"[{packet_num}] Bike->Phone (Port 2002) [{len(udp_payload)} bytes]: {binascii.hexlify(udp_payload).decode('utf-8')}")
                
            # Port 5000: Video Stream (Extract first few packets to see SPS/PPS)
            if dst_port == 5000 and packet_num < 100:
                hex_data = binascii.hexlify(udp_payload).decode('utf-8')
                # Only print first 64 bytes of video packet
                print(f"[{packet_num}] Phone->Bike Video (Port 5000) [{len(udp_payload)} bytes]: {hex_data[:128]}...")

if __name__ == '__main__':
    parse_pcap('tripper_stream.pcap')
