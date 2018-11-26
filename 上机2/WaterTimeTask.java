package crazyAdministrator;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;


/**
 * 定期放水类
 * Created by captain on 2018/11/18.
 */

public class WaterTimeTask extends TimerTask{
	//TimerTask是一个抽象类，实现了Runnable接口，所以具备了多线程的能力
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BlockingQueue<String>queue =new ArrayBlockingQueue<String>(10000);
		//基于数组的阻塞队列实现，在ArrayBlockingQueue内部，维护了一个定长数组，以便缓存队列中的数据对象，这是一个常用的阻塞队列
		//ArrayBlockingQueue在生产者放入数据和消费者获取数据，都是共用同一个锁对象，由此也意味着两者无法真正并行运行.
		InputThread  thread1 = new InputThread(queue); //注水
		InputThread  thread2 = new InputThread(queue); 
		InputThread  thread3= new InputThread(queue); 
		OutputThread thread4 = new OutputThread(queue);//放水
		OutputThread thread5 = new OutputThread(queue);
		List<Callable<Object>>threadList=new ArrayList<>(5);
		threadList.add(thread1);
		threadList.add(thread2);
		threadList.add(thread3);
		threadList.add(thread4);
		threadList.add(thread5);
		List<Object>returnValue=null;
		//定义一个空链表，用来存储线程执行的结果
		try {
			    //returnValue是一个数组链表
            returnValue = ThreadUtil.runCheckCallable(threadList,true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        System.out.println("泳池已经注满");
        System.out.println(returnValue.get(0));
        System.out.println(returnValue.get(1));
        System.out.println(returnValue.get(2));
        System.out.println(returnValue.get(3));
        System.out.println(returnValue.get(4));
    }	
}

