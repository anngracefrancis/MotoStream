import SwiftUI

struct NavigationCanvasView: View {
    let distanceText: String
    let instructionText: String
    let arrowImageName: String
    
    var body: some View {
        ZStack {
            // Premium background: Deep radial gradient that mimics a glass screen or glowing panel
            RadialGradient(
                gradient: Gradient(colors: [Color(white: 0.20), .black]),
                center: .center,
                startRadius: 20,
                endRadius: 200
            )
            
            // Subtle "grid" lines to give it a futuristic instrument cluster vibe
            Circle()
                .stroke(Color.white.opacity(0.1), lineWidth: 1)
            Circle()
                .stroke(Color.white.opacity(0.05), lineWidth: 1)
                .frame(width: 300, height: 300)
            Circle()
                .stroke(Color.white.opacity(0.03), lineWidth: 1)
                .frame(width: 200, height: 200)
            
            VStack {
                Spacer()
                
                // Top: Large, glowing directional arrow
                Image(systemName: arrowImageName)
                    .resizable()
                    .scaledToFit()
                    .frame(width: 110, height: 110)
                    .foregroundColor(.white)
                    .shadow(color: .white.opacity(0.5), radius: 8, x: 0, y: 0)
                    .padding(.top, 20)
                
                Spacer()
                
                // Middle: Massive, highly readable neon yellow distance text
                Text(distanceText)
                    .font(.system(size: 80, weight: .heavy, design: .rounded))
                    .foregroundColor(Color(red: 0.8, green: 1.0, blue: 0.1)) // Neon yellow/green
                    .shadow(color: Color(red: 0.8, green: 1.0, blue: 0.1).opacity(0.4), radius: 10, x: 0, y: 0)
                
                Spacer()
                
                // Bottom: Clean instruction text
                Text(instructionText)
                    .font(.system(size: 24, weight: .semibold, design: .default))
                    .foregroundColor(.white)
                    .multilineTextAlignment(.center)
                    .lineLimit(2)
                    .minimumScaleFactor(0.7)
                    .padding(.horizontal, 40)
                    
                Spacer()
                
                // Connection Badge at the very bottom
                HStack(spacing: 6) {
                    Circle()
                        .fill(Color(red: 0.2, green: 1.0, blue: 0.4)) // Neon green
                        .frame(width: 8, height: 8)
                    Text("Connected to iPhone")
                        .font(.system(size: 14, weight: .medium, design: .rounded))
                        .foregroundColor(.gray)
                }
                .padding(.bottom, 25)
            }
        }
        .frame(width: 400, height: 400) // Fixed physical size of the pod
        .clipShape(Circle()) // Physically clip the rendering to a circle!
    }
}

#Preview {
    NavigationCanvasView(
        distanceText: "300 ft",
        instructionText: "Turn right onto Elm Street",
        arrowImageName: "arrow.turn.up.right"
    )
}
