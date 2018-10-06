package test;
import java.util.List;
import java.util.ArrayList;
public class Master
{
   static List<Song>listSong;//歌曲列表
   public Master() //构造函数，初始化列表list
   {
	listSong=new ArrayList<Song>();   
   }
   public boolean play() //播放歌曲
   {
	  System.out.println(listSong.get(0).toString()); 
	  //打印即将播放的歌曲信息
	  return true;
   }
}
