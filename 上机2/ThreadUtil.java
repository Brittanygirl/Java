package crazyAdministrator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ThreadUtil {
	private static ExecutorService exec; //声明一个变量线程池
	 /*
          * 线程池管理工具
         * 传入一组带有返回值的线程，然后由工具类统一管理，并把最终的线程运行集合返回
     * @param list       线程集合
     * @param isBlock    是否阻塞标示位，如果为false，则线程启动后立即返回，否则等待所有线程均有结果后返回（推荐使用true）
     * @return           线程运行结果集合，仅返回已运行结束的线程集合，如都未结束，则返回尺寸为0的list
     */
	
    public static List<Object> runCheckCallable(List<Callable<Object>> threadList, boolean b) 
    throws InterruptedException,ExecutionException
 {
	//对参数进行检测
    if (CheckNull(threadList)) {
        return new ArrayList<>(); 
    }

    //初始化线程，打开一个线程池
    exec = Executors.newCachedThreadPool();
    //添加线程并返回Future线程
    List<Future<Object>> futureList = exec.invokeAll(threadList); 
    // ExecutorService中批量执行任务的方法：invokeAll()和invokeAny()
    //nvokeAll()在所有任务都完成（包括成功/被中断/超时）后才会返回。
    //invokeAny()在任意一个任务成功（或ExecutorService被中断/超时）后就会返回
    //Object为返回值类型

    if (!b){
        return new ArrayList<>(); //b一开始是true
    }
    
    //检查并获取线程返回值
    return getAllCallableReturn(futureList); //线程结果集集合
 }
    
    
    
    
 private static boolean CheckNull(List<Callable<Object>> threadList)
{
	//检测list是否为空
    if (threadList==null||threadList.size()<1){
        return true;
    }
    //检测list中对象是否为空
    for (Callable callable :threadList){
        if (callable==null){
            return true;
        }
    }
    return false;
 }
 
 
 /**
  * 轮询获取所有Callable线程的返回值，直到所有返回值都被获取到（阻塞）
  * @param futureList     所有线程的管理类集合
  * @return
  * @throws ExecutionException
  * @throws InterruptedException
  */
 
   private static List<Object> getAllCallableReturn(List<Future<Object>> futureList)
   throws ExecutionException, InterruptedException 
  {
     List<Object> returnValue = new ArrayList<>(futureList.size());
     //为了使性能比较好，因此将ArrayList的长度为线程数量
     while(true){
        Iterator<Future<Object>> iterator = futureList.iterator();
        
        while(iterator.hasNext()){
            Future<Object> future = iterator.next();
            if (future.isDone()){    //判断线程是否已完成
                Object o = future.get();
                //如果该线程已经完成了，submit() 方法会返回一个 Future 对象
                //Future 对象把 Callable#call() 的返回值按特定进行进行参数化，调用 Future#get() 可以得到 call() 的返回结果。
                //用 Future#isDone() 判断线程是否执行结束 ，如果直接调用 Future#get() ，get() 将会阻塞，直到结果准备就绪（success）。
                returnValue.add(o);//将返回结果
                iterator.remove();
            }
        }
        //if循环的目的是阻塞调用invokeAll的线程，直到所有任务都执行完毕。
        if(futureList.size()==0){
            break;
        }
        TimeUnit.MILLISECONDS.sleep(10*1000);
     }
     
     return returnValue;
  }
}
