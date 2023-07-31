package baitap1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerInSumNumber {
    public static void main(String[] args) throws IOException {
        int pointServer = 8080;
        ServerSocket serverSocket = new ServerSocket(pointServer);
        System.out.println("Server đã sẳn sàng lắng nghe.....");
        Socket socket = serverSocket.accept();
        readToClientandSum(socket);
        serverSocket.close();
        socket.close();
    }

    private static void readToClientandSum(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int bytesRead = inputStream.read(bytes);
        String[] message = (new String(bytes,0,bytesRead)).split(",");
        int intLuu =0;
        for (String line: message
             ) {
            intLuu += Integer.parseInt(line);
        }
        replyToClient(socket,intLuu);
    }

    private static void replyToClient(Socket socket, int intLuu) throws IOException {
        String message = String.valueOf(intLuu);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());
        outputStream.close();
    }
}
