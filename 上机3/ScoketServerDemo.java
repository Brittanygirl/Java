package thread3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ScoketServerDemo {
	public static void main(String[] args) {
        ServerSocket serverSocket = null;  //�򿪷�����
        try {
            serverSocket = new ServerSocket(7070);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(serverSocket==null){
            return;
        }
        System.out.println("�����������");
        while(true){
            try {
                System.out.println("�������ȴ��ͻ�������");
                Socket socket = serverSocket.accept();  //�ȴ��ͻ��˵����� ����
                SocketServerThread socketThread = new SocketServerThread(socket);
                new Thread(socketThread).start();
                System.out.println("����������ͻ����������");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
  }
}
