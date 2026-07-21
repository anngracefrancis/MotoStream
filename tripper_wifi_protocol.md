# Royal Enfield Tripper Dash (TFT) Protocol

Based on the network capture analysis, the new Royal Enfield full-color TFT "Tripper Dash" (found on the Himalayan 450) uses a fascinating hybrid Wi-Fi approach for screen mirroring. It actually tunnels the old Bluetooth `K1G` commands over Wi-Fi UDP, while simultaneously streaming a video feed of the map!

## Network Architecture

When the iPhone connects to the bike's Wi-Fi network:
* **Bike IP (Router/Dash):** `192.168.1.1`
* **iPhone IP:** `192.168.1.2`

## Ports and Protocols

Instead of relying on a standard like Apple CarPlay, Royal Enfield built a custom UDP-based protocol using three specific ports:

### 1. The Video Stream (UDP Port 5000)
The iPhone blasts a constant stream of large UDP packets (length 1372 bytes) to the bike on **Port 5000**:
`192.168.1.2 -> 192.168.1.1:5000`
This is the actual visual map data being cast to the screen. It is highly likely this is a raw H.264 video stream or a sequence of JPEG frames. 

### 2. Dashboard Telemetry & Buttons (UDP Port 2002)
The bike sends tiny telemetry packets (13-22 bytes) back to the iPhone on **Port 2002**:
`192.168.1.1 -> 192.168.1.2:2002`
Amazingly, if we look at the raw hex of these packets, we can see the exact same `K1G` protocol that the old circular Tripper pods used over Bluetooth!
*Example packet captured:* `0016 0002 0000 0000 0c05 0001 aa01 0100 054b 3147 00eb` (`K1G` is visible in ASCII at the end).
This channel is used by the bike to tell the phone about joystick button presses on the handlebars (so you can pan the map) and to acknowledge the connection.

### 3. iPhone Commands to Bike (UDP Port 2000)
The iPhone sends its own control commands to the bike on **Port 2000**:
`192.168.1.2 -> 192.168.1.1:2000`
This is likely the phone sending the initial setup commands, map bounds, or responding to the `K1G` heartbeat.

## How to implement this in MotoStream

If you want your custom iOS app (`MotoStream`) to cast to the dash, you need to:
1. Detect when you are connected to the `RE_M76P` Wi-Fi network.
2. Open a UDP listening socket on port `2002` to receive the `K1G` heartbeats from the bike.
3. Open a UDP socket to `192.168.1.1:2000` and send the initial `K1G` handshake/acknowledgments so the dash knows your app is ready.
4. Begin capturing your app's screen (using ReplayKit or AVFoundation), encode it to H.264, and stream the frames as UDP packets to `192.168.1.1:5000`!

*(To perfectly mimic the video format, we would need to extract the exact H.264 encoding profile (SPS/PPS NAL units) from the start of the `tripper_stream.pcap` file.)*
