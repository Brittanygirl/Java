package crazyAdministrator;

import java.util.Calendar;
import java.util.Timer;
//��ʱ����ʵ�����Ǹ��̣߳��ɶ�ʱ����ִ��TimerTask��������Ķ���
//����ĳ��������һ�������ڼ������ִ��
//TimerTask��һ�������࣬ʵ����������������������run������������ľ���ִ���߼�������ÿ�α�����ִ��ʱ��ִ��run����
//Timer���schedule�������������ִ��ʱ��



/**
 * Created by captain on 2017/7/27.
 */

public class MainDrive {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();  
		//Calendar����Ҫ���ڡ����ڡ����ꡢ�¡��յ�����ֵ��ת��
		//Calendar��һ�������࣬����ֱ�Ӵ�������ʹ�þ�̬����getInstance��ô���ǰ���ڵĶ���Date�����
		//ͨ���ö���calendar����set��������������ָ����һ��ʱ��,void set(int year,int month,int date,int hour,int minute,int second)
		//�������л�ȡ�й��ꡢ�¡����ڡ��ȵ���Ϣ��ͨ��int get(int field)����������field��ֵ��Calendar��ľ�̬����������.
		//��get(Calendar.YEAR)
		calendar.set (calendar.get(Calendar.YEAR), //��ȡ��ǰ���
				      calendar.get(Calendar.MONTH),//��ȡ��ǰ�·�
                      calendar.get(Calendar.DATE),20,0,0);//��ȡ�������ڣ����㼸�ּ���
		//���������õ���ǰ��ʱ��
		 WaterTimeTask task = new WaterTimeTask();
	     Timer timer = new Timer();
	     
	     timer.schedule(task,calendar.getTime(),1000*60*60*24); //ʹ�ö�ʱ��������ʱ����
	     //��ʱ����ѭ��ִ�еģ�task����������󣬵ڶ��������ǵó�ִ�����������ʱ�䣬������������ѭ��ִ�е�ʱ��������λΪ���룬
	     //���������������ʼʱ�俪ʼ��ÿ��һ��ִ������taskһ��
	     //calendar.getTime���ص�ǰ������Ӧ�����ڶ���
	}
}
