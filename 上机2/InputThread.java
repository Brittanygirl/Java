package crazyAdministrator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * עˮ�߳�
 * Created by captain on 2018/11/18.
 */
public class InputThread implements Callable<Object>{
	//Callable���з���ֵ���̣߳�������ִ�����ִ�к�����з���ֵ����Object���涨�ķ���Ϊcall����
   private BlockingQueue<String>queue;  
   //BlockingQueue���������У�ͨ��һ������Ķ��У�����ʹ�������ɶ��е�һ�����룬������һ�������ʵ�����ݹ���
   public InputThread(BlockingQueue queue) {
      this.queue=queue;
   }
   

@Override
public Object call() throws InterruptedException {
	// TODO Auto-generated method stub
 while(true){
	 boolean flag = true;
	 for(int cnt=0;cnt<15;cnt++){
	      flag = queue.offer("һ������");  //����Ԫ�أ��������أ��ɹ�����true��ʧ�ܷ���false
	      if(!flag){
	                  break;
	               }
	  }
	  System.out.println("עˮ5�����ף���ǰˮ����"+queue.size());
	  if(!flag){
	         break;
	  }
	      TimeUnit.SECONDS.sleep(5);
	  }
	      return "success";
	}
}
   
