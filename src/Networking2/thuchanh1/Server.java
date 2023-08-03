package Networking2.thuchanh1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // tạo cổng 8888
        int serverPort = 8888;


        // tạo đối tượng DatagramSocket để liên kết với cổng port
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server is running and waiting for client....");
        while (true){


            // tạo mảng byte để nhận dữ liệu từ gói tin nhận được
            byte[] receiveData = new byte[1024];


            // tạo đối tượng DatagramPacket để nhận gói từ client
            DatagramPacket datagramPacket = new DatagramPacket(receiveData, receiveData.length);


            // nhận gói tin từ client
            serverSocket.receive(datagramPacket);


            // lấy địa chỉ và cổng của client
            InetAddress clientAdress = datagramPacket.getAddress();
            int clientPort = datagramPacket.getPort();


            // chuyển đỏi dữ liệu thành dạng chuổi
            String message = new String(datagramPacket.getData(),0,datagramPacket.getLength());
            System.out.println("Received from client: "+ message);


            // dữ liệu chuẩn bị gửi đi
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("ct".equalsIgnoreCase(input)){
                serverSocket.close();
                break;
            }


            // chuyển dạng byte để gửi đi
            byte[] senData = input.getBytes();


            // taoj dataPacket để gửi gói tin đến Client
            DatagramPacket sendPacket = new DatagramPacket(senData,senData.length,clientAdress,clientPort);

            // gửi dữ liệu tới client
            serverSocket.send(sendPacket);



        }

    }

}
