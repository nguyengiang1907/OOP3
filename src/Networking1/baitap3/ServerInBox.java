package baitap3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerInBox {
    public static void main(String[] args) throws IOException {
        int point = 8080;
        ServerSocket serverSocket = new ServerSocket(point);
        System.out.println("Server đã sẳn sàng kết nối ");
        while (true) {
            Socket socket = serverSocket.accept();
            readInClient(socket);
            if (writeClient(socket, serverSocket)) break;

        }
    }

    private static boolean writeClient(Socket socket, ServerSocket serverSocket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ("ct".equalsIgnoreCase(input)){
            serverSocket.close();
            socket.close();
            return true;
        }
        outputStream.write(input.getBytes());
        return false;
    }

    private static void readInClient(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readByte = inputStream.read(bytes);
        String message = new String(bytes, 0, readByte);
        System.out.println("Client : " + message);
    }
}