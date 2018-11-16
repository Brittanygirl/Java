package Thread;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadSafeDemo1 implements Runnable {
	private List<String> list;
	public ThreadSafeDemo1(List<String>list)
	{
		this.list=list;
	}
	
	@Override
	public void run() {
		Random random=new Random();
		System.out.println("线程:"+random.nextInt());
		/*
		 * public int nextInt(int n)
              该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
              不带参数的nextInt会产生所有有效的整数。
		 */
		 
		synchronized(list) { 
			
			/*
			 * 在Java中，synchronized关键字是用来控制线程同步的。
			 * 就是在多线程的环境下，控制synchronized代码段不被多个线程同时执行。
			 * synchronized既可以加在一段代码上，也可以加在方法上。
			 */
			
			/*synchronized(this)锁住的是当前的对象，使用的对象监视器是一个
			 * 当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，同一个时间内只能有一个线程得到执行。
			 * 另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
			 * 争夺资源的时候时只有一个可以进行
			 */
			
			//synchronized(任意对象)将任意对象作为监视器
			//多个线程持有对象监视器作为同一个对象的前提下，同一时间只有一个线程可以执行synchronized(任意自定义对象)同步代码快。
			//但是在一个线程完成之后，另外一个线程依然可以执行这段代码。
	
			Iterator<String>iterator=list.iterator();
			int cnt=0;
			while(iterator.hasNext())
			{
				iterator.next();
				iterator.remove();
				cnt++;
				try {
				   TimeUnit.MILLISECONDS.sleep(10);//当前线程睡眠十秒
				}catch(InterruptedException e) {
				  e.printStackTrace();
				}
			}
			System.out.println("移除元素的数量:"+cnt);
		}
	}
}
	


