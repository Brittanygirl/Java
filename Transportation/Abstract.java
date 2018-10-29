package Transport;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

abstract public class Abstract {

     public String transname; //交通工具的名称
     public Date setofftime;  //到站时间
     public Date returntime;  //返回时间
     public Date picktime;    //取票时间
     public Date securitytime;//安检时间
     public Date waittime;    //候车时间
     public double speed;     //车速，每小时多少
     public double unitprice; //单价公里
     //抽象方法，只有方法的声明，没有方法体，必须用abstract修饰。
     public abstract ArrayList<String>cost(String departure,String destination,double distance);//计算消耗的时间和金钱
     public void TimeandPrice(String departure,String destination,double distance)
     {    //调用抽象方法进行输出
    	 //计算消耗的时间和价格
    	 ArrayList<String>list=cost(departure,destination,distance);//时间和费用表
    	 System.out.println("乘坐"+transname+"花费时间："+list.get(0));//获取时间
    	 System.out.println("费用是："+list.get(1));//获取费用
     }

}
