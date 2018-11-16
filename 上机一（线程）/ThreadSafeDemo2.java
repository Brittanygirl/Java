package Thread;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadSafeDemo2 implements Runnable{
	 private List<String> list;

	    public ThreadSafeDemo2(List<String> list){
	        this.list = list;
	    }

	    @Override
	    public void run() {
	    	synchronized(this) {
	        while(true) {
	            list.add("��Ȩ���������У��κ���ʽת������ϵ���ߡ����ߣ�KY�����ǣ����Զ�����Դ��https://www.douban.com/note/630084526/������ר���о�����è������cat-human communication)����ѧ����Ϊ����ӡ��Ҳ����ȫ�Ǿ�ȷ�ġ����ǵģ�����һ����ʵ���ڵ��о�ѧ�ơ��о�������Ϊ��ѧ������һ�ȱ�ȡ������Ϊ������Ϊ�����о��ı�����һ�������ۣ�anthropomorphism�����������о����ѧ�Ƶ�ѧ���Ѿ�����������Ϊ�ˣ���������Ϊ�о����������ʵ����壩��");
	            System.out.println("���һ����ߴ磺"+list.size());
	            try {
	            	//Thread.sleep(5*1000);
	            	TimeUnit.MILLISECONDS.sleep(5000);  //TimeUnit��˯����Thread�ĸ߼�˯����ʽ�������������˽�˯�ߵ�ʱ��
				} catch (InterruptedException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
	  }
	}


