import os

wifi_path = "/Users/anngracefrancis/Desktop/motoStream iOS/MotoStream/Managers/WiFiStreamingManager.swift"
video_path = "/Users/anngracefrancis/Desktop/motoStream iOS/MotoStream/Managers/VideoStreamingManager.swift"

with open(video_path, 'r') as f:
    video_code = f.read()

# Remove the import Foundation, ReplayKit etc from the top
video_code = video_code.replace("import Foundation\n", "")
if "import ReplayKit" not in open(wifi_path).read():
    with open(wifi_path, 'r') as f:
        wifi_code = f.read()
    
    wifi_code = "import ReplayKit\nimport VideoToolbox\nimport CoreMedia\n" + wifi_code + "\n\n" + video_code
    
    with open(wifi_path, 'w') as f:
        f.write(wifi_code)

os.remove(video_path)
print("Merged!")
