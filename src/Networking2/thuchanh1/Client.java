package Networking2.thuchanh1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // tạo địa chỉ ip
        String serverIp = "127.0.0.1";

        // tạo cổng kết nối với server
        int serverPort = 8888;
        // Tạo đối tượng để kết nối với máy chủ
        DatagramSocket clientSocket = new DatagramSocket();
        while (true){


            // tạo tin nhắn muốn gửi đi và chuyển sang dạng byte
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            byte[] senData = input.getBytes();
            if ("ct".equalsIgnoreCase(input)){
                clientSocket.close();
                break;
            }

            // gửi gói tin đến server
            InetAddress serverAddress = InetAddress.getByName(serverIp);
            DatagramPacket sendPacket = new DatagramPacket(senData,senData.length,serverAddress,serverPort);
            clientSocket.send(sendPacket);

            // Chuẩn bị mảng byte để nhận dữ liệu từ server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePaket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePaket);

            String responeseMessage = new String(receivePaket.getData(),0,receiveData.length);
            System.out.println("Received from server: " + responeseMessage);




        }
    }

}
