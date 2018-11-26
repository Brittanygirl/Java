package crazyAdministrator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 放水线程
 * Created by captain on 2018/11/18.
 */

public class OutputThread implements Callable<Object>{
	private BlockingQueue<String>queue;
	public OutputThread(BlockingQueue queue) {
		this.queue=queue;
	}
	
     
	@Override
	public Object call() throws InterruptedException {
		while(true) //一直放水
		{
			if(queue.size()==10000)
			{
				break;
			}
			for(int cnt=0;cnt<3;cnt++) {
			   queue.poll(10,TimeUnit.SECONDS);
			   //从BlockingQueue取出一个队首的对象，如果在指定时间内，队列一旦有数据可取，则立即返回队列中的数据。
			   //否则知道时间超时还没有数据可取，返回失败。
			   //poll（long timeosut, TimeUnit unit ）获取并移除头部元素，若队列为空等待指定长度的时间.
			 }
			System.out.println("放水3立方米，当前水量："+queue.size());
			TimeUnit.SECONDS.sleep(1);
		 }			
		return "success";
	}

}
