import Foundation
import MapKit
import Combine

class SearchManager: NSObject, ObservableObject, MKLocalSearchCompleterDelegate {
    @Published var searchQuery: String = ""
    @Published var searchResults: [MKLocalSearchCompletion] = []
    
    private var completer: MKLocalSearchCompleter
    private var cancellables = Set<AnyCancellable>()
    
    override init() {
        self.completer = MKLocalSearchCompleter()
        super.init()
        
        self.completer.delegate = self
        // Bias towards destinations over queries
        self.completer.resultTypes = [.address, .pointOfInterest]
        
        // Listen to changes in the search query and update the completer
        $searchQuery
            .debounce(for: .milliseconds(300), scheduler: RunLoop.main)
            .sink { [weak self] query in
                guard let self = self else { return }
                if query.isEmpty {
                    self.searchResults = []
                } else {
                    self.completer.queryFragment = query
                }
            }
            .store(in: &cancellables)
    }
    
    // Set region based on current location to give better local results
    func updateRegion(_ region: MKCoordinateRegion) {
        self.completer.region = region
    }
    
    // MARK: - MKLocalSearchCompleterDelegate
    
    func completerDidUpdateResults(_ completer: MKLocalSearchCompleter) {
        DispatchQueue.main.async {
            self.searchResults = completer.results
        }
    }
    
    func completer(_ completer: MKLocalSearchCompleter, didFailWithError error: Error) {
        print("Error fetching autocomplete results: \(error.localizedDescription)")
    }
    
    // Helper to turn a completion into an actual MKMapItem (with coordinates)
    func resolve(completion: MKLocalSearchCompletion, completionHandler: @escaping (MKMapItem?) -> Void) {
        let searchRequest = MKLocalSearch.Request(completion: completion)
        let search = MKLocalSearch(request: searchRequest)
        search.start { response, error in
            guard let mapItem = response?.mapItems.first else {
                print("Failed to resolve map item: \(error?.localizedDescription ?? "Unknown error")")
                completionHandler(nil)
                return
            }
            completionHandler(mapItem)
        }
    }
}
