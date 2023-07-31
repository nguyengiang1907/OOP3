package baitap3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientInBox {
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int point = 8080;
        while (true){
            Socket socket = new Socket(ip, point);
            writeInBox(socket);
            readInBox(socket);
            socket.close();
        }
    }

    private static void writeInBox(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String nhap = scanner.nextLine();
        outputStream.write(nhap.getBytes());
    }

    private static void readInBox(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readServer = inputStream.read(bytes);
        String message = new String(bytes, 0, readServer);
        System.out.println("Server : " + message);
    }
}
