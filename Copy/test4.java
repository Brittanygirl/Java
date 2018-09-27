package test;
import java.util.List;
import java.util.ArrayList;
public class test4 
{
	public static void main(String[ ]args)
	{
	List<Integer>list=new ArrayList<>();
	//list是List的一个变量，相当于一个接口，List集合是一个容器，接口里面有着各种各样的方法
	//ArraryList是List的实现，是一种动态数组，即动态分配数组的长度
	Integer integer=new Integer(10);//integer是Integer类的一个实例,封包并赋值
	list.add(integer);
	integer=list.get(0);
	int cnt= integer.intValue();//解包
	System.out.println(integer);
	integer=4;
	integer=list.get(0);
	int cnt1= integer.intValue();//解包
	System.out.println(integer);//封包并赋值
	/* Integer integer=new Integer1(3)
	   integer1=4;
	   list.add(integer1);
	   integer1=list.get(1);
	   int cnt1= integer1.intValue();//解包
	   System.out.println(integer1);
	*/
	}
}
