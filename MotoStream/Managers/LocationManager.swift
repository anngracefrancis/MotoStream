import Foundation
import CoreLocation
import Combine

class LocationManager: NSObject, ObservableObject, CLLocationManagerDelegate {
    private let manager = CLLocationManager()
    
    @Published var currentLocation: CLLocation?
    @Published var isAuthorized: Bool = false
    
    override init() {
        super.init()
        manager.delegate = self
        // Highest accuracy for driving navigation
        manager.desiredAccuracy = kCLLocationAccuracyBestForNavigation
        // Don't pause updates automatically
        manager.pausesLocationUpdatesAutomatically = false
        // Allow background updates since the app will be PiP/Backgrounded
        manager.allowsBackgroundLocationUpdates = true
        // Only update if moved more than 5 meters to save a tiny bit of battery
        manager.distanceFilter = 5.0
    }
    
    func requestPermissions() {
        manager.requestAlwaysAuthorization()
    }
    
    func startTracking() {
        manager.startUpdatingLocation()
    }
    
    func stopTracking() {
        manager.stopUpdatingLocation()
    }
    
    // MARK: - CLLocationManagerDelegate
    
    func locationManagerDidChangeAuthorization(_ manager: CLLocationManager) {
        let status = manager.authorizationStatus
        isAuthorized = (status == .authorizedAlways || status == .authorizedWhenInUse)
        if isAuthorized {
            startTracking()
        }
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        guard let location = locations.last else { return }
        DispatchQueue.main.async {
            self.currentLocation = location
        }
    }
    
    func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        print("LocationManager failed with error: \(error.localizedDescription)")
    }
}
