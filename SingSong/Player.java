package test;
import java.util.Scanner;//Scanner类来获取用户的输入
public class Player 
{
	public boolean addSong()
	{
	  Scanner sc=new Scanner(System.in);//从键盘接受数据
	/*Scanner类有next()与nextLine(),俩种方法获取字符串
	 * 读取前一般需要使用hasNext()与hasNextLine()判断是否还有数据输入
	 * next，读取到有效字符才可以结束，有效字符之前的空格自动去掉，有效字符之后的空白
	 * 作为 分隔符或者结束符
	   nextLine,以Enter作为结束符，该方法返回的是输入回车之前的所有字符，包括空格
	 */
	  //if(sc.hasNext())
	 // {
	    System.out.println("输入歌曲名:");
	    String songName=sc.next();
	    System.out.println("输入歌手名:");
	    String  singer=sc.next();
	    System.out.println("歌曲时长:");
	    double time=sc.nextDouble();
	    
	 // }
	  //sc.close();
	   Song song=new Song(songName,singer,time);
	   Master.listSong.add(song);
	  return true;
	}
	
}
