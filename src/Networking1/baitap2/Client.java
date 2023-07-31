package baitap2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int pointServer = 8888;
        Socket socket = new Socket(ip,pointServer);
        Scanner scanner = new Scanner(System.in);
        writeServer(socket, scanner);
        readServer(socket);
        socket.close();
    }

    private static void writeServer(Socket socket, Scanner scanner) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("nhập địa chỉ ip");
        String number = scanner.nextLine();
        outputStream.write(number.getBytes());
    }

    private static void readServer(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readByte = inputStream.read(bytes);
        String message = new String(bytes,0,readByte);
        System.out.println( message);
    }
}
