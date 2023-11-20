import cv2
import math
import winsound

# Set known parameters
object_width = 0.2  # Width of the object in meters
focal_length = 1000  # Focal length of the camera in pixels

cap = cv2.VideoCapture(0)

if not cap.isOpened():
    raise IOError("Cannot open camera")

font_scale = 3
font = cv2.FONT_HERSHEY_PLAIN

warning_message = "Obstacle Ahead!"

# Buzzer sound file path
buzzer_sound_file = "D:\Desktop\mini project\car-alarm-1.wav"

buzzer_playing = False  # Flag to track if the buzzer is currently playing

while True:
    ret, frame = cap.read()
    
    if not ret:
        break
    
    # Perform object detection using your model
    ClassIndex, confidence, bbox = model.detect(frame, confThreshold=0.55)
    
    print(ClassIndex)
    
    if len(ClassIndex) != 0:
        for ClassInd, conf, boxes in zip(ClassIndex.flatten(), confidence.flatten(), bbox):
            if ClassInd <= 80:
                cv2.rectangle(frame, boxes, (255, 0, 0), 2)
                cv2.putText(frame, classLabels[ClassInd-1], (boxes[0]+10, boxes[1]+40), font, fontScale=font_scale, color=(0, 255, 0), thickness=3)
                
                # Calculate distance from camera
                object_pixel_width = abs(boxes[2] - boxes[0])
                distance = (object_width * focal_length) / object_pixel_width
                
                if distance < 2:
                    # Show warning message
                    cv2.putText(frame, warning_message, (50, 50), font, fontScale=1.5, color=(0, 0, 255), thickness=2)
                    
                    if not buzzer_playing:
                        # Play the buzzer sound
                        winsound.PlaySound(buzzer_sound_file, winsound.SND_ASYNC | winsound.SND_FILENAME)
                        buzzer_playing = True
                else:
                    if buzzer_playing:
                        # Stop the buzzer sound
                        winsound.PlaySound(None, winsound.SND_ASYNC)
                        buzzer_playing = False
                
                if distance < 1:
                    # Show stop message
                    cv2.putText(frame, "STOP", (50, 100), font, fontScale=1.5, color=(0, 0, 255), thickness=2)
                    
                    if not buzzer_playing:
                        # Play the buzzer sound
                        winsound.PlaySound(buzzer_sound_file, winsound.SND_ASYNC | winsound.SND_FILENAME)
                        buzzer_playing = True
                else:
                    if buzzer_playing:
                        # Stop the buzzer sound
                        winsound.PlaySound(None, winsound.SND_ASYNC)
                        buzzer_playing = False
                
                # Determine obstacle position
                obstacle_center = (boxes[0] + boxes[2]) // 2
                frame_center = frame.shape[1] // 2
                
                if obstacle_center < frame_center:
                    move_message = "Move Right"
                else:
                    move_message = "Move Left"
                    
                # Display move message
                cv2.putText(frame, move_message, (50, 150), font, fontScale=1.5, color=(0, 0, 255), thickness=2)
    
    cv2.imshow('Object Detection Tutorial', frame)
    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        # Stop the buzzer sound if it is playing
        if buzzer_playing:
            winsound.PlaySound(None, winsound.SND_ASYNC)
        break

cap.release()
cv2.destroyAllWindows()