package test;
import java.util.List;
import java.util.ArrayList;
public class test4 
{
	public static void main(String[ ]args)
	{
	List<Integer>list=new ArrayList<>();
	//list��List��һ���������൱��һ���ӿڣ�List������һ���������ӿ��������Ÿ��ָ����ķ���
	//ArraryList��List��ʵ�֣���һ�ֶ�̬���飬����̬��������ĳ���
	Integer integer=new Integer(10);//integer��Integer���һ��ʵ��,�������ֵ
	list.add(integer);
	integer=list.get(0);
	int cnt= integer.intValue();//���
	System.out.println(integer);
	integer=4;
	integer=list.get(0);
	int cnt1= integer.intValue();//���
	System.out.println(integer);//�������ֵ
	/* Integer integer=new Integer1(3)
	   integer1=4;
	   list.add(integer1);
	   integer1=list.get(1);
	   int cnt1= integer1.intValue();//���
	   System.out.println(integer1);
	*/
	}
}
