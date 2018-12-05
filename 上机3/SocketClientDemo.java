package thread4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class SocketClientDemo
{
	public static void main(String[] args) {
        Socket client = null;
        try {
            client = new Socket("localhost",7070);
            //��һ��ͨѶ
            //д����Ϣ��������
            PrintWriter out = new PrintWriter(client.getOutputStream());
            out.println("Ф�غ������£�Ф�غ�������");
            out.flush();

            //��ȡ�ӷ������ش�����Ϣ
            Reader reader = new InputStreamReader(client.getInputStream());
            BufferedReader in = new BufferedReader(reader);
            String serverMessage = in.readLine();  //��ȡһ�пͻ��˴�������Ϣ������
            System.out.println("�������ش�����Ϣ��"+serverMessage);

            TimeUnit.SECONDS.sleep(60);

            //�ڶ���ͨѶ
            out.println("�����ڲ������·������ȼ�գ�");
            out.flush();
            serverMessage = in.readLine();
            System.out.println("���������صİ��ţ�"+serverMessage);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if(client!=null){
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

   }
 }
}
       

