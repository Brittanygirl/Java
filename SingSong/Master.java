package test;
import java.util.List;
import java.util.ArrayList;
public class Master
{
   static List<Song>listSong;//�����б�
   public Master() //���캯������ʼ���б�list
   {
	listSong=new ArrayList<Song>();   
   }
   public boolean play() //���Ÿ���
   {
	  System.out.println(listSong.get(0).toString()); 
	  //��ӡ�������ŵĸ�����Ϣ
	  return true;
   }
}
