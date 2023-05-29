package server_;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class likeTomcat {
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (!serverSocket.isClosed()){
            Socket accept = serverSocket.accept();
            System.out.println("有客户端连接了");
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("<h1>123123123</h1>".getBytes());
            outputStream.close();
            accept.close();
        }
        serverSocket.close();
    }
}
