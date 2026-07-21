import Foundation
import MapKit
import Combine

class NavigationManager: ObservableObject {
    @Published var distanceText: String = "--"
    @Published var instructionText: String = "Waiting for route..."
    @Published var arrowImageName: String = "location.fill"
    
    @Published var currentRoute: MKRoute?
    @Published var currentStepIndex: Int = 0
    
    // Add reference to BluetoothManager
    var bluetoothManager: BluetoothManager?
    
    private var cancellables = Set<AnyCancellable>()
    @Published var destinationName: String = ""
    private var destinationCoordinate: CLLocationCoordinate2D?
    
    func calculateRoute(from userLocation: CLLocation, to destination: MKMapItem) {
        self.destinationCoordinate = destination.placemark.coordinate
        self.destinationName = destination.name ?? "Destination"
        
        let request = MKDirections.Request()
        request.source = MKMapItem(placemark: MKPlacemark(coordinate: userLocation.coordinate))
        request.destination = destination
        request.transportType = .automobile
        
        let directions = MKDirections(request: request)
        directions.calculate { [weak self] response, error in
            guard let self = self, let route = response?.routes.first else {
                print("Failed to calculate route: \(error?.localizedDescription ?? "Unknown error")")
                return
            }
            
            DispatchQueue.main.async {
                self.currentRoute = route
                self.currentStepIndex = 1 // Step 0 is usually "Start at location"
                self.updateNavigationState(with: userLocation)
            }
        }
    }
    
    func updateNavigationState(with userLocation: CLLocation) {
        guard let route = currentRoute, currentStepIndex < route.steps.count else { return }
        
        let currentStep = route.steps[currentStepIndex]
        
        // The coordinate where the turn actually happens is the FIRST point of the step's polyline
        var turnCoordinate = userLocation.coordinate // fallback
        
        // Extract coordinate from polyline
        let pointCount = currentStep.polyline.pointCount
        if pointCount > 0 {
            let points = currentStep.polyline.points()
            turnCoordinate = points[0].coordinate
        }
        
        let turnLocation = CLLocation(latitude: turnCoordinate.latitude, longitude: turnCoordinate.longitude)
        let distanceToTurn = userLocation.distance(from: turnLocation)
        
        // If we are within 30 meters of the turn, advance to the next step
        if distanceToTurn < 30 {
            if currentStepIndex + 1 < route.steps.count {
                currentStepIndex += 1
                updateNavigationState(with: userLocation)
                return
            } else {
                // Arrived
                distanceText = "0 m"
                instructionText = "You have arrived"
                arrowImageName = "flag.fill"
                return
            }
        }
        
        // Format distance for phone UI
        distanceText = formatDistance(distanceToTurn)
        instructionText = currentStep.instructions
        arrowImageName = determineArrowIcon(for: currentStep.instructions)
        
        // Send raw data to the dashboard
        if let bluetooth = bluetoothManager {
            let maneuverId = 0x0B // 0x0B is "continue". Trial and error on a real bike needed for turn glyphs!
            let totalDistance = Int(route.distance - (route.distance * Double(currentStepIndex) / Double(route.steps.count)))
            
            bluetooth.sendNavigationUpdate(
                distanceMeters: Int(distanceToTurn),
                maneuverType: maneuverId,
                totalDistanceMeters: max(totalDistance, 0)
            )
        }
    }
    
    private func formatDistance(_ meters: CLLocationDistance) -> String {
        // Simple metric formatter
        if meters < 1000 {
            return "\(Int(meters)) m"
        } else {
            let kilometers = meters / 1000.0
            return String(format: "%.1f km", kilometers)
        }
    }
    
    private func determineArrowIcon(for instruction: String) -> String {
        let lower = instruction.lowercased()
        if lower.contains("right") {
            return "arrow.turn.up.right"
        } else if lower.contains("left") {
            return "arrow.turn.up.left"
        } else if lower.contains("u-turn") || lower.contains("uturn") {
            return "arrow.uturn.up"
        } else if lower.contains("arrive") {
            return "flag.fill"
        } else {
            return "arrow.up"
        }
    }
}
