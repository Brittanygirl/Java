package crazyAdministrator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * ��ˮ�߳�
 * Created by captain on 2018/11/18.
 */

public class OutputThread implements Callable<Object>{
	private BlockingQueue<String>queue;
	public OutputThread(BlockingQueue queue) {
		this.queue=queue;
	}
	
     
	@Override
	public Object call() throws InterruptedException {
		while(true) //һֱ��ˮ
		{
			if(queue.size()==10000)
			{
				break;
			}
			for(int cnt=0;cnt<3;cnt++) {
			   queue.poll(10,TimeUnit.SECONDS);
			   //��BlockingQueueȡ��һ�����׵Ķ��������ָ��ʱ���ڣ�����һ�������ݿ�ȡ�����������ض����е����ݡ�
			   //����֪��ʱ�䳬ʱ��û�����ݿ�ȡ������ʧ�ܡ�
			   //poll��long timeosut, TimeUnit unit ����ȡ���Ƴ�ͷ��Ԫ�أ�������Ϊ�յȴ�ָ�����ȵ�ʱ��.
			 }
			System.out.println("��ˮ3�����ף���ǰˮ����"+queue.size());
			TimeUnit.SECONDS.sleep(1);
		 }			
		return "success";
	}

}
