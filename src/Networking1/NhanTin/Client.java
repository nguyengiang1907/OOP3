package NhanTin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int ma = 1907;
        Socket socket = new Socket();
        vietTinNhan();
        docTinNhan(socket);
    }
    public static void vietTinNhan()throws IOException{
        int ma = 1907;
        String ip = "127.0.0.1";
        Socket socket = new Socket(ip,ma);
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        outputStream.write(message.getBytes());
        socket.close();
    }
    public static void docTinNhan(Socket socket)throws IOException{
        int ma = 1907;
        ServerSocket serverSocket = new ServerSocket(ma);
        socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int bytesRead = inputStream.read(bytes);
        String message = new String(bytes,0,bytesRead);
        System.out.println("Giang " + message);
        serverSocket.close();
        socket.close();
    }
}
