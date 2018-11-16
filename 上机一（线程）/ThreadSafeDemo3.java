package Thread;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadSafeDemo3 implements Runnable {
	private List<String> list;

    public ThreadSafeDemo3(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
    	synchronized(list) {
            if(list.size()>0){
            	  while(true)
            	  { 
                     list.remove(0);
                
                     System.out.println("É¾³ýÒ»¸öºó³ß´ç£º"+list.size());
                
                     try {
                    	 //Thread.sleep(1*1000);
                    	 TimeUnit.MILLISECONDS.sleep(1000);
      			     } catch (InterruptedException e) {
      				// TODO Auto-generated catch block
      				   e.printStackTrace();
      			}
            }
        }
      }
   }
}


