package test;

public class Song {
	String SongName;//������
	String Singer;//����
	double Time;//����ʱ��
	public Song(String songName,String singer,double time)
	{
		SongName=songName;
		Singer=singer;
		Time=time;
	}
	//��дSong������toString()�������Ա���listSong�д�ӡ������Ϣ
	public String toString()
	{
		StringBuffer s=new StringBuffer("");
		//A string buffer is like a String, but can be modified
		s.append("������:"+SongName);
		s.append("����:"+Singer);
		s.append("����ʱ��:"+Time);
		return s.toString();//������д����ַ���		
	}
	

}
