package test;

public class Drive
{
	public Master master;//������
	public Player player;//�����
	public Drive()//��ʼ��master��player
	{
		master=new Master();
		player=new Player();
	}
	public static void main(String[] args)//��ں���
	{
		Drive sd=new Drive();
		sd.player.addSong();
		sd.player.addSong();
		sd.master.play();
	}
}
