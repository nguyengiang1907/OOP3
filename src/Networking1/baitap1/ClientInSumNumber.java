package baitap1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientInSumNumber {
    public static void main(String[] args) throws IOException {
        String addressId = "127.0.0.1";
        int pointServer = 8080;
        Socket socket = new Socket(addressId,pointServer);
        replyToServer(socket);
        readToServer(socket);
        socket.close();
    }

    private static void replyToServer(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String number = "";
        System.out.println("Nhap so 1 ");
        number += scanner.next() + ",";
        System.out.println("nhap so 2");
        number += scanner.next();
        outputStream.write(number.getBytes());
    }
    private static void readToServer(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readBytes = inputStream.read(bytes);
        String message = new String(bytes,0,readBytes);
        System.out.println("Sum = "+message);
        socket.close();
    }
}
