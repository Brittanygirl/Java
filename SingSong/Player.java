package test;
import java.util.Scanner;//Scanner������ȡ�û�������
public class Player 
{
	public boolean addSong()
	{
	  Scanner sc=new Scanner(System.in);//�Ӽ��̽�������
	/*Scanner����next()��nextLine(),���ַ�����ȡ�ַ���
	 * ��ȡǰһ����Ҫʹ��hasNext()��hasNextLine()�ж��Ƿ�����������
	 * next����ȡ����Ч�ַ��ſ��Խ�������Ч�ַ�֮ǰ�Ŀո��Զ�ȥ������Ч�ַ�֮��Ŀհ�
	 * ��Ϊ �ָ������߽�����
	   nextLine,��Enter��Ϊ���������÷������ص�������س�֮ǰ�������ַ��������ո�
	 */
	  //if(sc.hasNext())
	 // {
	    System.out.println("���������:");
	    String songName=sc.next();
	    System.out.println("���������:");
	    String  singer=sc.next();
	    System.out.println("����ʱ��:");
	    double time=sc.nextDouble();
	    
	 // }
	  //sc.close();
	   Song song=new Song(songName,singer,time);
	   Master.listSong.add(song);
	  return true;
	}
	
}
