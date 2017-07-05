import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by nhs3108 on 05/07/2017.
 */
public class PipedInAndOutputStreamExample {
    public static void main(String[] args) throws InterruptedException, IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);

        Thread thread1 = new Thread(() -> {
            try {
                pipedOutputStream.write("Welcome to Nguyen Hong Son's tutorials".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                int b;
                while (pipedInputStream.available() > 0 && (b = pipedInputStream.read()) != -1) {
                    System.out.print((char) b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
