import java.io.*;
public class Car
{
  private String   Name;
  private double Tank;//汽车的最大存储油量
  private double  OilConsumption;//汽车每小时的油耗
  public void display()
{
 System.out.println("汽车的名称:"+Name+"汽车的最大存储油量:"+Tank+"汽车的每小时的油耗:"+ OilConsumption);
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
    System.out.println("请输入汽车的各个属性:");
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