import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Máy chủ
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is running...");

            // Chấp nhận kết nối từ client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Nhận thông điệp từ client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            // Gửi dữ liệu tới client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, client!");

            // Đóng kết nối
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}