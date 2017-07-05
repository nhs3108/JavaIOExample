import java.io.*;

/**
 * Created by nhs3108 on 05/07/2017.
 */
public class FileInputStreamExample {
    public static void main(String[] args) {
        String absoluteFilePath = "/home/nhs3108/Desktop/test.txt";
        try {
            String content = FileInputStreamExample.getContentFile(absoluteFilePath);
            System.out.println("-------------------------------------------------");
            System.out.println(content);
            System.out.println("-------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getContentFile(String absoluteFilePath) throws IOException {
        StringBuilder result = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(absoluteFilePath);
        int b;
        while ((b = fileInputStream.read()) != -1) {
            result.append((char) b);
        }
        return result.toString();
    }
}
