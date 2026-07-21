import SwiftUI
import CoreMedia
import CoreLocation
import MapKit

@MainActor
struct ContentView: View {
    @EnvironmentObject var backgroundEngine: BackgroundEngine
    @StateObject private var wifiManager = WiFiStreamingManager()
    
    @StateObject private var locationManager = LocationManager()
    @StateObject private var navigationManager = NavigationManager()
    @StateObject private var searchManager = SearchManager()
    
    @State private var isNavigating = false
    @State private var mapRegion = MKCoordinateRegion(
        center: CLLocationCoordinate2D(latitude: 37.3346, longitude: -122.0090), // Default Apple HQ
        span: MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05)
    )
    
    var body: some View {
        ZStack(alignment: .top) {
            // 1. Live Background Map
            Map(coordinateRegion: $mapRegion, showsUserLocation: true)
                .ignoresSafeArea()
            
            // 2. Foreground UI
            if isNavigating {
                navigationControlPanel
            } else {
                floatingSearchUI
            }
        }
        .preferredColorScheme(.dark) // Force Premium Dark Mode
        .onAppear {
            locationManager.requestPermissions()
            // wifiManager.connect() // Can auto-connect here later
        }
        .onChange(of: navigationManager.distanceText) { _ in pushNavigationToDash() }
        .onChange(of: navigationManager.instructionText) { _ in pushNavigationToDash() }
        .onChange(of: navigationManager.arrowImageName) { _ in pushNavigationToDash() }
        .onChange(of: locationManager.currentLocation) { _ in
            if let location = locationManager.currentLocation {
                navigationManager.updateNavigationState(with: location)
                let region = MKCoordinateRegion(center: location.coordinate, latitudinalMeters: 5000, longitudinalMeters: 5000)
                searchManager.updateRegion(region)
                
                // Only update map region automatically if NOT navigating so user can browse
                if !isNavigating {
                    withAnimation {
                        mapRegion = region
                    }
                }
            }
        }
    }
    
    // MARK: - Floating Search UI
    private var floatingSearchUI: some View {
        VStack(spacing: 0) {
            // Search Bar
            HStack {
                Image(systemName: "magnifyingglass")
                    .foregroundColor(.gray)
                TextField("Where to?", text: $searchManager.searchQuery)
                    .font(.system(size: 18, weight: .medium))
            }
            .padding()
            .background(.ultraThinMaterial)
            .cornerRadius(16)
            .shadow(color: .black.opacity(0.3), radius: 10, x: 0, y: 5)
            .padding(.horizontal)
            .padding(.top, 20)
            
            // Search Results Dropdown
            if !searchManager.searchResults.isEmpty {
                ScrollView {
                    VStack(alignment: .leading, spacing: 16) {
                        ForEach(searchManager.searchResults, id: \.self) { result in
                            Button(action: {
                                startNavigation(to: result)
                            }) {
                                VStack(alignment: .leading, spacing: 4) {
                                    Text(result.title)
                                        .font(.headline)
                                        .foregroundColor(.white)
                                    if !result.subtitle.isEmpty {
                                        Text(result.subtitle)
                                            .font(.subheadline)
                                            .foregroundColor(.gray)
                                    }
                                }
                                .padding(.horizontal)
                            }
                            Divider().background(Color.white.opacity(0.1))
                        }
                    }
                    .padding(.vertical)
                }
                .background(.ultraThinMaterial)
                .cornerRadius(16)
                .shadow(color: .black.opacity(0.3), radius: 10, x: 0, y: 5)
                .padding(.horizontal)
                .padding(.top, 8)
                .frame(maxHeight: 300)
            }
        }
    }
    
    // MARK: - Navigation Control Panel
    private var navigationControlPanel: some View {
        VStack {
            Spacer()
            
            VStack(spacing: 20) {
                // Header
                HStack {
                    VStack(alignment: .leading) {
                        Text("Routing to:")
                            .font(.subheadline)
                            .foregroundColor(.gray)
                        Text(navigationManager.destinationName)
                            .font(.title2)
                            .bold()
                            .foregroundColor(.white)
                    }
                    Spacer()
                    // Connection Status Indicator
                    HStack(spacing: 6) {
                        Circle()
                            .fill(wifiManager.isConnected ? Color.green : Color.orange)
                            .frame(width: 10, height: 10)
                            .shadow(color: wifiManager.isConnected ? .green : .clear, radius: 5)
                        Text(wifiManager.connectionStatus.uppercased())
                            .font(.caption)
                            .bold()
                            .foregroundColor(wifiManager.isConnected ? .green : .orange)
                    }
                    .padding(.horizontal, 12)
                    .padding(.vertical, 6)
                    .background(Color.white.opacity(0.1))
                    .cornerRadius(20)
                }
                .padding(.horizontal, 20)
                .padding(.top, 20)
                
                // Dash Canvas Preview
                NavigationCanvasView(
                    distanceText: navigationManager.distanceText,
                    instructionText: navigationManager.instructionText,
                    arrowImageName: navigationManager.arrowImageName
                )
                // Scale it down just a bit to fit nicely on the iPhone screen
                .scaleEffect(0.7)
                .frame(width: 400 * 0.7, height: 400 * 0.7)
                
                // Action Buttons
                VStack(spacing: 12) {
                    
                    // Telemetry Readout
                    if wifiManager.isConnected {
                        Text("Dash Telemetry: \\(wifiManager.lastReceivedCommand.isEmpty ? "Waiting for joystick..." : wifiManager.lastReceivedCommand)")
                            .font(.caption2)
                            .foregroundColor(.cyan)
                            .frame(height: 40)
                    }
                    
                    HStack(spacing: 16) {
                        Button(action: {
                            isNavigating = false
                            wifiManager.disconnect()
                        }) {
                            Text("CANCEL ROUTE")
                                .font(.headline)
                                .bold()
                                .foregroundColor(.white)
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(
                                    RoundedRectangle(cornerRadius: 16)
                                        .fill(Color.red.opacity(0.8))
                                )
                                .shadow(color: .red.opacity(0.5), radius: 8)
                        }
                        
                        if !wifiManager.isConnected {
                            Button(action: {
                                wifiManager.connect()
                            }) {
                                HStack {
                                    Image(systemName: "wifi")
                                    Text("CONNECT DASH")
                                }
                                .font(.headline)
                                .bold()
                                .foregroundColor(.black)
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(
                                    RoundedRectangle(cornerRadius: 16)
                                        .fill(Color(red: 0.2, green: 1.0, blue: 0.4)) // Neon Green
                                )
                                .shadow(color: Color(red: 0.2, green: 1.0, blue: 0.4).opacity(0.5), radius: 8)
                            }
                        }
                    }
                }
                .padding(.horizontal, 20)
                .padding(.bottom, 30)
            }
            .background(.ultraThinMaterial)
            .cornerRadius(30)
            .shadow(color: .black.opacity(0.5), radius: 20, x: 0, y: -10)
        }
        .onAppear {
            // wifiManager.connect() 
        }
    }
    
    private func startNavigation(to result: MKLocalSearchCompletion) {
        guard let userLocation = locationManager.currentLocation else { return }
        
        searchManager.resolve(completion: result) { mapItem in
            if let item = mapItem {
                navigationManager.calculateRoute(from: userLocation, to: item)
                // Center map on destination
                withAnimation {
                    mapRegion = MKCoordinateRegion(center: item.placemark.coordinate, latitudinalMeters: 2000, longitudinalMeters: 2000)
                }
                searchManager.searchQuery = ""
                isNavigating = true
                wifiManager.connect()
            }
        }
    }
    
    private func pushNavigationToDash() {
        guard isNavigating else { return }
        wifiManager.sendNavigationUpdate(
            distance: navigationManager.distanceText,
            instruction: navigationManager.instructionText,
            arrowType: navigationManager.arrowImageName
        )
    }
}

#Preview {
    ContentView()
        .environmentObject(BackgroundEngine())
}
