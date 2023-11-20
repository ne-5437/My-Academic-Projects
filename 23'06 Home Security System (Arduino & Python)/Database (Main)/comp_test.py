from cv2 import imread, cvtColor, COLOR_BGR2RGB
from face_recognition import face_encodings, compare_faces

def recognise(img1, img2):
    img_encoding1 = readImage(img1)
    img_encoding2 = readImage(img2)
    return compare_faces([img_encoding1], img_encoding2)

def readImage(image):
    img = imread(image)
    rgb_img = cvtColor(img, COLOR_BGR2RGB)
    return face_encodings(rgb_img)[0]

def main():
    # [True]
    print(recognise("pic1.jpg", "pic10.jpg"))
    # [True]
    print(recognise("pic32.jpg", "photo.jpg"))
     # [True]
    print(recognise("pic0.jpg", "photo.jpg"))

if __name__ == '__main__':
    main()
    
