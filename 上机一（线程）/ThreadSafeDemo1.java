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
		System.out.println("�߳�:"+random.nextInt());
		/*
		 * public int nextInt(int n)
              �÷���������������һ�������intֵ����ֵ����[0,n)�����䣬Ҳ����0��n֮������intֵ������0��������n��
              ����������nextInt�����������Ч��������
		 */
		 
		synchronized(list) { 
			
			/*
			 * ��Java�У�synchronized�ؼ��������������߳�ͬ���ġ�
			 * �����ڶ��̵߳Ļ����£�����synchronized����β�������߳�ͬʱִ�С�
			 * synchronized�ȿ��Լ���һ�δ����ϣ�Ҳ���Լ��ڷ����ϡ�
			 */
			
			/*synchronized(this)��ס���ǵ�ǰ�Ķ���ʹ�õĶ����������һ��
			 * �����������̷߳���ͬһ������object�е����synchronized(this)ͬ�������ʱ��ͬһ��ʱ����ֻ����һ���̵߳õ�ִ�С�
			 * ��һ���̱߳���ȴ���ǰ�߳�ִ�������������Ժ����ִ�иô���顣
			 * ������Դ��ʱ��ʱֻ��һ�����Խ���
			 */
			
			//synchronized(�������)�����������Ϊ������
			//����̳߳��ж����������Ϊͬһ�������ǰ���£�ͬһʱ��ֻ��һ���߳̿���ִ��synchronized(�����Զ������)ͬ������졣
			//������һ���߳����֮������һ���߳���Ȼ����ִ����δ��롣
	
			Iterator<String>iterator=list.iterator();
			int cnt=0;
			while(iterator.hasNext())
			{
				iterator.next();
				iterator.remove();
				cnt++;
				try {
				   TimeUnit.MILLISECONDS.sleep(10);//��ǰ�߳�˯��ʮ��
				}catch(InterruptedException e) {
				  e.printStackTrace();
				}
			}
			System.out.println("�Ƴ�Ԫ�ص�����:"+cnt);
		}
	}
}
	


