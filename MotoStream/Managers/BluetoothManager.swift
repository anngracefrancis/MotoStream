import Foundation
import CoreBluetooth
import Combine

class BluetoothManager: NSObject, ObservableObject, CBCentralManagerDelegate, CBPeripheralDelegate {
    private var centralManager: CBCentralManager!
    private var tripperPeripheral: CBPeripheral?
    private var maneuverCharacteristic: CBCharacteristic?
    
    @Published var isBluetoothPoweredOn = false
    @Published var isConnected = false
    @Published var discoveredDevices: [CBPeripheral] = []
    
    private let publicKeyPEM = """
    -----BEGIN PUBLIC KEY-----
    MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArPPdQja3Y+eUv+Y6S2BK
    fT5/tJr5+3PP096oOM8wUfjeXAxi/Ud/ELs8Lcip8jIYTw7UlAjYvO/zwj+bHTWX
    AEvN6ta8YEhWNXx9cqMWOkIbeqRpND5HjEmHnnUvScp5phh4qO0asx/oFUljIVau
    Y/dbI3/maCt3mrQ9vF3KB98Qj2RE+JsY8QO+6parsKD2+PFlT/4aBN4J3CgYV7Yd
    k51pF8w4MqRjUMouPH/LjFMnM0TLx0Ag57RB6jVBgXVzegSJVtm4s8Kuz0LZ+ptf
    JqCL3bJgrc6P2m7XkqTqoEULRcEBAvBKbzszG0AZAVpD67kcxAFMTcnpS2w+fqql
    2QIDAQAB
    -----END PUBLIC KEY-----
    """
    
    override init() {
        super.init()
        // Initialize CoreBluetooth in the background
        centralManager = CBCentralManager(delegate: self, queue: nil, options: [CBCentralManagerOptionRestoreIdentifierKey: "com.motostream.bluetooth"])
    }
    
    func startScanning() {
        guard centralManager.state == .poweredOn else { return }
        print("Starting BLE Scan for Tripper Pod...")
        // If we knew the specific Service UUID, we would put it here.
        // For now, we scan for everything to find the Tripper.
        centralManager.scanForPeripherals(withServices: nil, options: [CBCentralManagerScanOptionAllowDuplicatesKey: false])
    }
    
    func connect(to peripheral: CBPeripheral) {
        centralManager.stopScan()
        tripperPeripheral = peripheral
        tripperPeripheral?.delegate = self
        centralManager.connect(peripheral, options: nil)
    }
    
    func disconnect() {
        if let peripheral = tripperPeripheral {
            centralManager.cancelPeripheralConnection(peripheral)
        }
    }
    
    func sendNavigationUpdate(distance: String, instruction: String, arrowType: String) {
        guard isConnected, let peripheral = tripperPeripheral, let characteristic = maneuverCharacteristic else {
            print("Cannot send update. BLE disconnected or characteristic not found.")
            return
        }
        
        // This is a placeholder payload format.
        // We will need to reverse-engineer the EXACT byte array the Royal Enfield Pod expects.
        // Example: JSON, or comma-separated, or raw bytes.
        let payloadString = "\(distance),\(instruction),\(arrowType)"
        guard let data = payloadString.data(using: .utf8) else { return }
        
        print("Sending BLE Payload: \(payloadString)")
        peripheral.writeValue(data, for: characteristic, type: .withResponse)
    }
    
    // MARK: - CBCentralManagerDelegate
    
    func centralManagerDidUpdateState(_ central: CBCentralManager) {
        DispatchQueue.main.async {
            self.isBluetoothPoweredOn = (central.state == .poweredOn)
        }
        
        switch central.state {
        case .poweredOn:
            print("Bluetooth is On.")
        case .poweredOff:
            print("Bluetooth is Off.")
            DispatchQueue.main.async { self.isConnected = false }
        case .unauthorized:
            print("Bluetooth is Unauthorized.")
        case .unsupported:
            print("Bluetooth is Unsupported on this device.")
        default:
            break
        }
    }
    
    func centralManager(_ central: CBCentralManager, didDiscover peripheral: CBPeripheral, advertisementData: [String : Any], rssi RSSI: NSNumber) {
        let name = peripheral.name ?? "Unknown"
        // Look for common Royal Enfield BLE names
        if name.contains("Tripper") || name.contains("RE_") || name.contains("Royal") {
            print("Discovered Potential Tripper Pod: \(name) [\(peripheral.identifier)]")
            DispatchQueue.main.async {
                if !self.discoveredDevices.contains(where: { $0.identifier == peripheral.identifier }) {
                    self.discoveredDevices.append(peripheral)
                }
            }
        }
    }
    
    func centralManager(_ central: CBCentralManager, didConnect peripheral: CBPeripheral) {
        print("Successfully connected to \(peripheral.name ?? "Unknown Device")")
        DispatchQueue.main.async {
            self.isConnected = true
        }
        // Discover ALL services since we don't know the exact UUID yet
        peripheral.discoverServices(nil)
    }
    
    func centralManager(_ central: CBCentralManager, didDisconnectPeripheral peripheral: CBPeripheral, error: Error?) {
        print("Disconnected from \(peripheral.name ?? "Unknown Device")")
        DispatchQueue.main.async {
            self.isConnected = false
            self.tripperPeripheral = nil
            self.maneuverCharacteristic = nil
        }
    }
    
    // MARK: - CBPeripheralDelegate
    
    func peripheral(_ peripheral: CBPeripheral, didDiscoverServices error: Error?) {
        if let error = error {
            print("Error discovering services: \(error.localizedDescription)")
            return
        }
        
        guard let services = peripheral.services else { return }
        print("Discovered \(services.count) services for \(peripheral.name ?? ""):")
        for service in services {
            print(" - Service UUID: \(service.uuid)")
            // Discover all characteristics for each service to map out the Pod
            peripheral.discoverCharacteristics(nil, for: service)
        }
    }
    
    func peripheral(_ peripheral: CBPeripheral, didDiscoverCharacteristicsFor service: CBService, error: Error?) {
        guard let characteristics = service.characteristics else { return }
        print("  -> Discovered \(characteristics.count) characteristics in Service \(service.uuid):")
        
        for characteristic in characteristics {
            print("    - Characteristic UUID: \(characteristic.uuid) (Properties: \(characteristic.properties))")
            
            // If we find a writable characteristic, we store it temporarily for testing
            if characteristic.properties.contains(.write) || characteristic.properties.contains(.writeWithoutResponse) {
                print("      [!] Found a Writable Characteristic! We can try sending data here.")
                if self.maneuverCharacteristic == nil {
                    self.maneuverCharacteristic = characteristic
                    self.performHandshake(peripheral: peripheral, characteristic: characteristic)
                }
            }
        }
    }
    
    // MARK: - Handshake Logic
    
    private func performHandshake(peripheral: CBPeripheral, characteristic: CBCharacteristic) {
        print("Initiating RSA Handshake with Tripper Pod...")
        
        let challengeString = "MOTOSTREAM_AUTH_V1" // Example challenge
        
        guard let publicKeyData = parsePublicKey(pem: publicKeyPEM),
              let secKey = createSecKey(from: publicKeyData) else {
            print("Failed to load public key for handshake.")
            return
        }
        
        guard let challengeData = challengeString.data(using: .utf8) else { return }
        
        var error: Unmanaged<CFError>?
        guard let encryptedData = SecKeyCreateEncryptedData(secKey,
                                                            .rsaEncryptionPKCS1,
                                                            challengeData as CFData,
                                                            &error) as Data? else {
            print("Failed to encrypt handshake payload: \(error.debugDescription)")
            return
        }
        
        print("Sending encrypted handshake payload: \(encryptedData.map { String(format: "%02hhx", $0) }.joined())")
        // .withResponse is safer for handshakes, but depends on the characteristic properties
        let writeType: CBCharacteristicWriteType = characteristic.properties.contains(.write) ? .withResponse : .withoutResponse
        peripheral.writeValue(encryptedData, for: characteristic, type: writeType)
    }
    
    private func parsePublicKey(pem: String) -> Data? {
        let lines = pem.components(separatedBy: .newlines)
        let base64String = lines.filter { !$0.hasPrefix("-----") }.joined()
        return Data(base64Encoded: base64String)
    }
    
    private func createSecKey(from keyData: Data) -> SecKey? {
        let attributes: [String: Any] = [
            kSecAttrKeyType as String: kSecAttrKeyTypeRSA,
            kSecAttrKeyClass as String: kSecAttrKeyClassPublic,
            kSecAttrKeySizeInBits as String: 2048,
            kSecReturnPersistentRef as String: false
        ]
        
        var error: Unmanaged<CFError>?
        guard let key = SecKeyCreateWithData(keyData as CFData,
                                             attributes as CFDictionary,
                                             &error) else {
            print("Error creating SecKey: \(error.debugDescription)")
            return nil
        }
        return key
    }
}
