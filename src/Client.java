import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 1020)){
            OutputStream outputStream = socket.getOutputStream();
            for(int i = 1; i < 11; i++) {
                outputStream.write(i);
                outputStream.flush();
                InputStream inputStream = socket.getInputStream();
                int response = inputStream.read();
                System.out.println(response);
            }
        }
    }
}
