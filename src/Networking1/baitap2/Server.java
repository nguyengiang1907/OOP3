package baitap2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;

public class Server {
    public static void main(String[] args) throws IOException {
        int pointServer = 8888;
        ServerSocket serverSocket = new ServerSocket(pointServer);
        System.out.println("Sever đang chờ lắng nghe lắng nghe....");
        Socket socket = serverSocket.accept();
        readToClient(socket);
        socket.close();
    }

    private static void readToClient(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readByte = inputStream.read(bytes);
        writeClient(socket, bytes, readByte);
    }

    private static void writeClient(Socket socket, byte[] bytes, int readByte) throws IOException {
        String[] message = new String(bytes,0, readByte).split("\\.");
        int luu1 = Integer.parseInt(message[0]);
        int luu2 = Integer.parseInt(message[1]);
        int luu3 = Integer.parseInt(message[2]);
        while (true){
            if (luu1 > 0 && luu1 < 255 && luu2 > 0 && luu2 < 255 && luu3 > 0 && luu3 < 255 ){
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("true".getBytes());
                socket.close();
                break;
            }else {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("false".getBytes());
                socket.close();
                break;
            }
        }
    }

}
