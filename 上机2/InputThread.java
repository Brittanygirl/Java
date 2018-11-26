package crazyAdministrator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 注水线程
 * Created by captain on 2018/11/18.
 */
public class InputThread implements Callable<Object>{
	//Callable可有返回值的线程，即任务执行完成执行后可以有返回值，即Object，规定的方法为call（）
   private BlockingQueue<String>queue;  
   //BlockingQueue：阻塞队列，通过一个共享的队列，可以使得数据由队列的一端输入，从另外一端输出；实现数据共享
   public InputThread(BlockingQueue queue) {
      this.queue=queue;
   }
   

@Override
public Object call() throws InterruptedException {
	// TODO Auto-generated method stub
 while(true){
	 boolean flag = true;
	 for(int cnt=0;cnt<15;cnt++){
	      flag = queue.offer("一立方米");  //插入元素，立即返回，成功返回true，失败返回false
	      if(!flag){
	                  break;
	               }
	  }
	  System.out.println("注水5立方米，当前水量："+queue.size());
	  if(!flag){
	         break;
	  }
	      TimeUnit.SECONDS.sleep(5);
	  }
	      return "success";
	}
}
   
