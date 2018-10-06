package test;

public class Song {
	String SongName;//歌曲名
	String Singer;//歌手
	double Time;//歌曲时长
	public Song(String songName,String singer,double time)
	{
		SongName=songName;
		Singer=singer;
		Time=time;
	}
	//重写Song类对象的toString()函数，以便在listSong中打印歌曲信息
	public String toString()
	{
		StringBuffer s=new StringBuffer("");
		//A string buffer is like a String, but can be modified
		s.append("歌曲名:"+SongName);
		s.append("歌手:"+Singer);
		s.append("歌曲时长:"+Time);
		return s.toString();//返回重写后的字符串		
	}
	

}
