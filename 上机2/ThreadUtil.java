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
	private static ExecutorService exec; //����һ�������̳߳�
	 /*
          * �̳߳ع�����
         * ����һ����з���ֵ���̣߳�Ȼ���ɹ�����ͳһ�����������յ��߳����м��Ϸ���
     * @param list       �̼߳���
     * @param isBlock    �Ƿ�������ʾλ�����Ϊfalse�����߳��������������أ�����ȴ������߳̾��н���󷵻أ��Ƽ�ʹ��true��
     * @return           �߳����н�����ϣ������������н������̼߳��ϣ��綼δ�������򷵻سߴ�Ϊ0��list
     */
	
    public static List<Object> runCheckCallable(List<Callable<Object>> threadList, boolean b) 
    throws InterruptedException,ExecutionException
 {
	//�Բ������м��
    if (CheckNull(threadList)) {
        return new ArrayList<>(); 
    }

    //��ʼ���̣߳���һ���̳߳�
    exec = Executors.newCachedThreadPool();
    //����̲߳�����Future�߳�
    List<Future<Object>> futureList = exec.invokeAll(threadList); 
    // ExecutorService������ִ������ķ�����invokeAll()��invokeAny()
    //nvokeAll()������������ɣ������ɹ�/���ж�/��ʱ����Ż᷵�ء�
    //invokeAny()������һ������ɹ�����ExecutorService���ж�/��ʱ����ͻ᷵��
    //ObjectΪ����ֵ����

    if (!b){
        return new ArrayList<>(); //bһ��ʼ��true
    }
    
    //��鲢��ȡ�̷߳���ֵ
    return getAllCallableReturn(futureList); //�߳̽��������
 }
    
    
    
    
 private static boolean CheckNull(List<Callable<Object>> threadList)
{
	//���list�Ƿ�Ϊ��
    if (threadList==null||threadList.size()<1){
        return true;
    }
    //���list�ж����Ƿ�Ϊ��
    for (Callable callable :threadList){
        if (callable==null){
            return true;
        }
    }
    return false;
 }
 
 
 /**
  * ��ѯ��ȡ����Callable�̵߳ķ���ֵ��ֱ�����з���ֵ������ȡ����������
  * @param futureList     �����̵߳Ĺ����༯��
  * @return
  * @throws ExecutionException
  * @throws InterruptedException
  */
 
   private static List<Object> getAllCallableReturn(List<Future<Object>> futureList)
   throws ExecutionException, InterruptedException 
  {
     List<Object> returnValue = new ArrayList<>(futureList.size());
     //Ϊ��ʹ���ܱȽϺã���˽�ArrayList�ĳ���Ϊ�߳�����
     while(true){
        Iterator<Future<Object>> iterator = futureList.iterator();
        
        while(iterator.hasNext()){
            Future<Object> future = iterator.next();
            if (future.isDone()){    //�ж��߳��Ƿ������
                Object o = future.get();
                //������߳��Ѿ�����ˣ�submit() �����᷵��һ�� Future ����
                //Future ����� Callable#call() �ķ���ֵ���ض����н��в����������� Future#get() ���Եõ� call() �ķ��ؽ����
                //�� Future#isDone() �ж��߳��Ƿ�ִ�н��� �����ֱ�ӵ��� Future#get() ��get() ����������ֱ�����׼��������success����
                returnValue.add(o);//�����ؽ��
                iterator.remove();
            }
        }
        //ifѭ����Ŀ������������invokeAll���̣߳�ֱ����������ִ����ϡ�
        if(futureList.size()==0){
            break;
        }
        TimeUnit.MILLISECONDS.sleep(10*1000);
     }
     
     return returnValue;
  }
}
