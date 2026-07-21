import Foundation
import Network
import Combine

class WiFiStreamingManager: ObservableObject {
    @Published var isConnected = false
    @Published var connectionStatus = "Disconnected"
    @Published var lastReceivedCommand = ""
    
    private let bikeIP = NWEndpoint.Host("192.168.1.1")
    private let sendPort = NWEndpoint.Port(integerLiteral: 2000)
    private let receivePort = NWEndpoint.Port(integerLiteral: 2002)
    
    private var sendConnection: NWConnection?
    private var receiveListener: NWListener?
    
    private let queue = DispatchQueue(label: "com.motostream.wifi")
    private var heartbeatTimer: Timer?
    
    init() {}
    
    func connect() {
        startListener()
        startSender()
    }
    
    func disconnect() {
        heartbeatTimer?.invalidate()
        sendConnection?.cancel()
        receiveListener?.cancel()
        
        DispatchQueue.main.async {
            self.isConnected = false
            self.connectionStatus = "Disconnected"
        }
    }
    
    // MARK: - Sender (Port 2000)
    
    private func startSender() {
        let endpoint = NWEndpoint.hostPort(host: bikeIP, port: sendPort)
        sendConnection = NWConnection(to: endpoint, using: .udp)
        
        sendConnection?.stateUpdateHandler = { [weak self] state in
            switch state {
            case .ready:
                print("UDP Sender ready on port \(self?.sendPort.rawValue ?? 0)")
                self?.startHeartbeat()
                DispatchQueue.main.async {
                    self?.isConnected = true
                    self?.connectionStatus = "Connected to Dash"
                }
            case .failed(let error):
                print("UDP Sender failed with error: \(error)")
                self?.disconnect()
            case .cancelled:
                print("UDP Sender cancelled")
            default:
                break
            }
        }
        
        sendConnection?.start(queue: queue)
    }
    
    private func startHeartbeat() {
        DispatchQueue.main.async {
            self.heartbeatTimer?.invalidate()
            self.heartbeatTimer = Timer.scheduledTimer(withTimeInterval: 1.0, repeats: true) { [weak self] _ in
                self?.sendK1GHeartbeat()
            }
        }
    }
    
    private func sendK1GHeartbeat() {
        // Example K1G Init/Heartbeat Packet
        // In the future, this will need to be the exact byte array from the .pcap
        let payload = Data(hexString: "00160002000000000c050001aa010100054b314700eb") ?? Data("K1G_HELLO".utf8)
        
        sendConnection?.send(content: payload, completion: .contentProcessed({ error in
            if let error = error {
                print("Failed to send UDP packet: \(error)")
            } else {
                print("Sent K1G UDP heartbeat")
            }
        }))
    }
    
    func sendNavigationUpdate(distance: String, instruction: String, arrowType: String) {
        // Convert to K1G hex payload (placeholder for now)
        print("WiFi Manager sending K1G nav update: \(distance) - \(instruction)")
        sendK1GHeartbeat() // Send a generic packet to keep connection alive
    }
    
    // MARK: - Listener (Port 2002)
    
    private func startListener() {
        do {
            receiveListener = try NWListener(using: .udp, on: receivePort)
            
            receiveListener?.stateUpdateHandler = { state in
                switch state {
                case .ready:
                    print("UDP Listener ready and listening on port 2002")
                case .failed(let error):
                    print("UDP Listener failed: \(error)")
                default:
                    break
                }
            }
            
            receiveListener?.newConnectionHandler = { [weak self] connection in
                print("Received incoming UDP connection from Dash")
                self?.receiveData(on: connection)
                connection.start(queue: self?.queue ?? .main)
            }
            
            receiveListener?.start(queue: queue)
        } catch {
            print("Failed to create UDP listener: \(error)")
        }
    }
    
    private func receiveData(on connection: NWConnection) {
        connection.receiveMessage { [weak self] content, context, isComplete, error in
            if let data = content, !data.isEmpty {
                let hexString = data.map { String(format: "%02x", $0) }.joined()
                print("Dash Telemetry Received: \(hexString)")
                
                DispatchQueue.main.async {
                    self?.lastReceivedCommand = hexString
                }
            }
            
            if error == nil && !isComplete {
                // Continue listening
                self?.receiveData(on: connection)
            }
        }
    }
}

// Extension to help convert hex strings to Data
extension Data {
    init?(hexString: String) {
        let len = hexString.count / 2
        var data = Data(capacity: len)
        var index = hexString.startIndex
        for _ in 0..<len {
            let nextIndex = hexString.index(index, offsetBy: 2)
            let bytes = hexString[index..<nextIndex]
            if var num = UInt8(bytes, radix: 16) {
                data.append(&num, count: 1)
            } else {
                return nil
            }
            index = nextIndex
        }
        self = data
    }
}
