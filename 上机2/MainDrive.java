package crazyAdministrator;

import java.util.Calendar;
import java.util.Timer;
//定时器，实际上是个线程，可定时调度执行TimerTask类型任务的对象
//安排某个任务以一定的周期间隔反复执行
//TimerTask是一个抽象类，实际任务是其子类对象，子类的run方法安排任务的具体执行逻辑，任务每次被调度执行时将执行run方法
//Timer类的schedule方法安排任务的执行时间



/**
 * Created by captain on 2017/7/27.
 */

public class MainDrive {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();  
		//Calendar类主要用于“日期”与年、月、日等整数值的转换
		//Calendar是一个抽象类，不能直接创建对象，使用静态方法getInstance获得代表当前日期的对象即Date类对象
		//通过该对象calendar调用set方法将日历翻到指定的一个时间,void set(int year,int month,int date,int hour,int minute,int second)
		//从日历中获取有关年、月、星期、等的信息，通过int get(int field)方法，参数field的值由Calendar类的静态常量来决定.
		//如get(Calendar.YEAR)
		calendar.set (calendar.get(Calendar.YEAR), //获取当前年份
				      calendar.get(Calendar.MONTH),//获取当前月份
                      calendar.get(Calendar.DATE),20,0,0);//获取当天日期，几点几分几秒
		//将日历设置到当前的时间
		 WaterTimeTask task = new WaterTimeTask();
	     Timer timer = new Timer();
	     
	     timer.schedule(task,calendar.getTime(),1000*60*60*24); //使用定时器启动定时任务
	     //定时器是循环执行的，task代表任务对象，第二个参数是得出执行任务的启动时间，第三个参数是循环执行的时间间隔，单位为毫秒，
	     //即从任务的启动开始时间开始，每隔一天执行任务task一次
	     //calendar.getTime返回当前日历对应的日期对象
	}
}
