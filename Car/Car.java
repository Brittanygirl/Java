import java.io.*;
public class Car
{
  private String   Name;
  private double Tank;//���������洢����
  private double  OilConsumption;//����ÿСʱ���ͺ�
  public void display()
{
 System.out.println("����������:"+Name+"���������洢����:"+Tank+"������ÿСʱ���ͺ�:"+ OilConsumption);
}
  public Car(String name,double tank,double oilconsumption)
{
   this.Name=name;
   this.Tank=tank;
   this.OilConsumption=oilconsumption;
}

public static void main(String a[ ])
{
    String  name="";
    String  ta ="";
    String  oil="";
    System.out.println("�����������ĸ�������:");
    try{
          BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
          name=in.readLine();
          ta=in.readLine();
          oil=in.readLine();
        }catch(IOException e){};
     double tank=Double.parseDouble(ta);
     double oilconsumption =Double.parseDouble(oil);
    Car car=new Car(name,tank,oilconsumption);
    car.display();
}
}