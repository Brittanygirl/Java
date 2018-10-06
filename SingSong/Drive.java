package test;

public class Drive
{
	public Master master;//主持人
	public Player player;//点歌者
	public Drive()//初始化master和player
	{
		master=new Master();
		player=new Player();
	}
	public static void main(String[] args)//入口函数
	{
		Drive sd=new Drive();
		sd.player.addSong();
		sd.player.addSong();
		sd.master.play();
	}
}
