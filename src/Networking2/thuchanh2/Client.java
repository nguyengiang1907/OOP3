package Networking2.thuchanh2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIp = "127.0.0.1";
        int serverPort = 1907;

        DatagramSocket clientSocket = new DatagramSocket();
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập số tính :");
            String input = scanner.nextLine();
            byte[] sendData = input.getBytes();
            InetAddress clientAddress = InetAddress.getByName(serverIp);
            DatagramPacket sendToClient = new DatagramPacket(sendData,sendData.length,clientAddress,serverPort);
            clientSocket.send(sendToClient);
            if ("exit".equalsIgnoreCase(input)){
                clientSocket.close();
                break;
            }

            byte[] receiveData = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(datagramPacket);
            String dataReceive = new String(datagramPacket.getData(),0, datagramPacket.getLength());
            System.out.println("Kết quả : "+dataReceive);
        }




    }
}
