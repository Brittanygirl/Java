package crazyAdministrator;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;


/**
 * ���ڷ�ˮ��
 * Created by captain on 2018/11/18.
 */

public class WaterTimeTask extends TimerTask{
	//TimerTask��һ�������࣬ʵ����Runnable�ӿڣ����Ծ߱��˶��̵߳�����
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BlockingQueue<String>queue =new ArrayBlockingQueue<String>(10000);
		//�����������������ʵ�֣���ArrayBlockingQueue�ڲ���ά����һ���������飬�Ա㻺������е����ݶ�������һ�����õ���������
		//ArrayBlockingQueue�������߷������ݺ������߻�ȡ���ݣ����ǹ���ͬһ���������ɴ�Ҳ��ζ�������޷�������������.
		InputThread  thread1 = new InputThread(queue); //עˮ
		InputThread  thread2 = new InputThread(queue); 
		InputThread  thread3= new InputThread(queue); 
		OutputThread thread4 = new OutputThread(queue);//��ˮ
		OutputThread thread5 = new OutputThread(queue);
		List<Callable<Object>>threadList=new ArrayList<>(5);
		threadList.add(thread1);
		threadList.add(thread2);
		threadList.add(thread3);
		threadList.add(thread4);
		threadList.add(thread5);
		List<Object>returnValue=null;
		//����һ�������������洢�߳�ִ�еĽ��
		try {
			    //returnValue��һ����������
            returnValue = ThreadUtil.runCheckCallable(threadList,true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        System.out.println("Ӿ���Ѿ�ע��");
        System.out.println(returnValue.get(0));
        System.out.println(returnValue.get(1));
        System.out.println(returnValue.get(2));
        System.out.println(returnValue.get(3));
        System.out.println(returnValue.get(4));
    }	
}

