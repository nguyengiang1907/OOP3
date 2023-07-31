package NhanTin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    public static void main(String[] args)throws IOException {
        int ma = 1907;
        String diaChi = "127.0.0.1";
        Socket socket = new Socket(diaChi,ma);
        Socket socket1 = new Socket();
        vietTinNhan(socket,diaChi);
        docTinNhan(socket1,ma);
    }
    public static void vietTinNhan(Socket socket,String diaChi)throws IOException{
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        outputStream.write(message.getBytes());
        socket.close();
    }
    public static void docTinNhan(Socket socket1,int ma)throws IOException{
        ServerSocket serverSocket = new ServerSocket(ma);
        socket1 = serverSocket.accept();
        InputStream inputStream = socket1.getInputStream();
        byte[] bytes = new byte[1024];
        int bytesRead = inputStream.read(bytes);
        String message = new String(bytes,0,bytesRead);
        System.out.println("Thảo Anh " + message);
        serverSocket.close();
        socket1.close();
    }
}
