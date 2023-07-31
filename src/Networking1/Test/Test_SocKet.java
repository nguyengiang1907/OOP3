package Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test_SocKet {
    String severAddres = "192.160.0.1";
    int severPoirt = 8000;
    Socket socket = new Socket(severAddres,severPoirt);

    public Test_SocKet() throws IOException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();


        // gửi dữ liệu
        String gui = "Hello, Server!";
        outputStream.write(gui.getBytes());

        // nhận dữ liệu
        byte[] buffer = new byte[1024];
        int byterRead = inputStream.read(buffer);
        String response = new String(buffer,0,byterRead);
        System.out.println("Server response:" + response);
        socket.close();
    }
}
