import java.io.*;

public class ImageByteArrayIO {
    public static void main(String[] args) {
        File inputImg = new File("photo.jpg");
        File outputImg = new File("copy_photo.jpg");

        try (FileInputStream in = new FileInputStream(inputImg);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                baos.write(buffer, 0, read);
            }

            byte[] imgBytes = baos.toByteArray();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(imgBytes);
                 FileOutputStream out = new FileOutputStream(outputImg)) {

                while ((read = bais.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
            }

            System.out.println("Image clone complete 🖼️");
        } catch (IOException e) {
            System.out.println("Image IO error: " + e.getMessage());
        }
    }
}
