package Transport;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

abstract public class Abstract {

     public String transname; //��ͨ���ߵ�����
     public Date setofftime;  //��վʱ��
     public Date returntime;  //����ʱ��
     public Date picktime;    //ȡƱʱ��
     public Date securitytime;//����ʱ��
     public Date waittime;    //��ʱ��
     public double speed;     //���٣�ÿСʱ����
     public double unitprice; //���۹���
     //���󷽷���ֻ�з�����������û�з����壬������abstract���Ρ�
     public abstract ArrayList<String>cost(String departure,String destination,double distance);//�������ĵ�ʱ��ͽ�Ǯ
     public void TimeandPrice(String departure,String destination,double distance)
     {    //���ó��󷽷��������
    	 //�������ĵ�ʱ��ͼ۸�
    	 ArrayList<String>list=cost(departure,destination,distance);//ʱ��ͷ��ñ�
    	 System.out.println("����"+transname+"����ʱ�䣺"+list.get(0));//��ȡʱ��
    	 System.out.println("�����ǣ�"+list.get(1));//��ȡ����
     }

}
