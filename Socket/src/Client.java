import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Client
public class Client {
    public static void main(String[] args) {
        try {
            // Kết nối tới máy chủ
            Socket socket = new Socket("localhost", 1234);

            // Gửi thông điệp tới máy chủ
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, server!");

            // Đọc dữ liệu từ máy chủ
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine();
            System.out.println("Server says: " + message);

            // Đóng kết nối
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
