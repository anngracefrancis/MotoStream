import Foundation
import AVFoundation
import AVKit
import Combine

class BackgroundEngine: NSObject, ObservableObject {
    private var audioEngine: AVAudioEngine?
    private var audioPlayerNode: AVAudioPlayerNode?
    
    private var pipController: AVPictureInPictureController?
    private var playerLayer: AVPlayerLayer?
    
    override init() {
        super.init()
        setupAudioEngine()
        setupPiP()
    }
    
    private func setupAudioEngine() {
        audioEngine = AVAudioEngine()
        audioPlayerNode = AVAudioPlayerNode()
        
        guard let engine = audioEngine, let playerNode = audioPlayerNode else { return }
        
        engine.attach(playerNode)
        
        let format = engine.outputNode.inputFormat(forBus: 0)
        engine.connect(playerNode, to: engine.outputNode, format: format)
        
        // Generate a silent buffer
        let frameCount = AVAudioFrameCount(format.sampleRate) // 1 second buffer
        guard let buffer = AVAudioPCMBuffer(pcmFormat: format, frameCapacity: frameCount) else { return }
        buffer.frameLength = frameCount
        
        // Fill buffer with silence
        if let channels = buffer.floatChannelData {
            for channel in 0..<Int(format.channelCount) {
                let channelData = channels[channel]
                for frame in 0..<Int(frameCount) {
                    channelData[frame] = 0.0
                }
            }
        }
        
        // Loop the silent buffer
        playerNode.scheduleBuffer(buffer, at: nil, options: .loops, completionHandler: nil)
    }
    
    private func setupPiP() {
        // Create an empty AVPlayer just to trick the system into allowing PiP
        guard AVPictureInPictureController.isPictureInPictureSupported() else {
            print("PiP not supported on this device")
            return
        }
        
        let player = AVPlayer()
        playerLayer = AVPlayerLayer(player: player)
        
        // The playerLayer needs a frame to be valid, even if it's offscreen
        playerLayer?.frame = CGRect(x: 0, y: 0, width: 1, height: 1)
        
        if let playerLayer = playerLayer {
            pipController = AVPictureInPictureController(playerLayer: playerLayer)
            pipController?.delegate = self
            
            // Allow PiP to start automatically when the app goes to background
            if #available(iOS 14.2, *) {
                pipController?.canStartPictureInPictureAutomaticallyFromInline = true
            }
        }
    }
    
    func startBackgroundLoop() {
        do {
            try audioEngine?.start()
            audioPlayerNode?.play()
            print("Background Audio Loop Started")
            
            // Start PiP if it isn't automatically started
            if let pipController = pipController, !pipController.isPictureInPictureActive {
                pipController.startPictureInPicture()
            }
        } catch {
            print("Error starting audio engine: \(error)")
        }
    }
    
    func stopBackgroundLoop() {
        audioPlayerNode?.stop()
        audioEngine?.stop()
        print("Background Audio Loop Stopped")
        
        if let pipController = pipController, pipController.isPictureInPictureActive {
            pipController.stopPictureInPicture()
        }
    }
}

extension BackgroundEngine: AVPictureInPictureControllerDelegate {
    func pictureInPictureControllerWillStartPictureInPicture(_ pictureInPictureController: AVPictureInPictureController) {
        print("PiP starting")
    }
    
    func pictureInPictureControllerDidStartPictureInPicture(_ pictureInPictureController: AVPictureInPictureController) {
        print("PiP started - App is anchored in background")
    }
    
    func pictureInPictureController(_ pictureInPictureController: AVPictureInPictureController, failedToStartPictureInPictureWithError error: Error) {
        print("PiP failed: \(error.localizedDescription)")
    }
}
