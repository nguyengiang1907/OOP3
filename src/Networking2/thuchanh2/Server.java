package Networking2.thuchanh2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.StringTokenizer;

public class Server {
    public static void main(String[] args) throws IOException {
        int portServer = 1907;
        DatagramSocket serverSocket = new DatagramSocket(portServer);
        System.out.println("Server is running and waiting for client.....");
        while (true){
            byte[] receiveData = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(datagramPacket);
            String dataReceive = new String(datagramPacket.getData(),0, datagramPacket.getLength());
            System.out.println("Client : "+dataReceive);
            if ("exit".equalsIgnoreCase(dataReceive)){
                serverSocket.close();
                break;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(dataReceive);
            double number1 = Double.parseDouble(stringTokenizer.nextToken());
            String calculation = stringTokenizer.nextToken();
            double number2 = Double.parseDouble(stringTokenizer.nextToken());
            double result = 0;
            switch (calculation) {
                case "+" -> result = number1 + number2;
                case "-" -> result = number1 - number2;
                case "*" -> result = number1 * number2;
                case "/" -> result = number1 / number2;
                default -> System.out.println("Nhập vào không hợp lệ ");
            }
            String stringData = Double.toString(result);
            byte[] dataSend = stringData.getBytes();

            InetAddress clientAddress = datagramPacket.getAddress();
            int portClient = datagramPacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(dataSend, dataSend.length, InetAddress.getByAddress(clientAddress.getAddress()),portClient);
            serverSocket.send(sendPacket);
            System.out.println("kết quả tính đang được gửi !");

        }




    }
}
