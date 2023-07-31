package thuchanh4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPoint = 8080;
        Socket socket = new Socket(serverIP, serverPoint);
        OutputStream outputStream = socket.getOutputStream();
        String message = "Hello, Server!";
        outputStream.write(message.getBytes());
        socket.close();

    }
}
