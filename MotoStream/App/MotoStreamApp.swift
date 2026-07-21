import SwiftUI
import AVFoundation

@main
struct MotoStreamApp: App {
    @StateObject private var backgroundEngine = BackgroundEngine()
    // @StateObject private var networkManager = NetworkManager()
    
    init() {
        // Setup Audio Session for Background Audio
        do {
            try AVAudioSession.sharedInstance().setCategory(.playback, mode: .default, options: [.mixWithOthers])
            try AVAudioSession.sharedInstance().setActive(true)
        } catch {
            print("Failed to set audio session category. Error: \(error)")
        }
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(backgroundEngine)
                // .environmentObject(networkManager)
                .onReceive(NotificationCenter.default.publisher(for: UIApplication.didEnterBackgroundNotification)) { _ in
                    backgroundEngine.startBackgroundLoop()
                }
                .onReceive(NotificationCenter.default.publisher(for: UIApplication.willEnterForegroundNotification)) { _ in
                    backgroundEngine.stopBackgroundLoop()
                }
        }
    }
}
