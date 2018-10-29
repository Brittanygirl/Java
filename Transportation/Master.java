package Transport;


import java.util.Scanner;

public class Master {
   public void show() {
		Car car=new Car();
		Train train=new Train();
		Plane plane=new Plane();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入出发地：");
		String departure=scanner.nextLine();
		System.out.println("请输入目的地：");
		String destination=scanner.nextLine();
		System.out.println("请输入俩地的距离：");
		Double distance=scanner.nextDouble();
		
	    car.TimeandPrice(departure, destination, distance);
	    train.TimeandPrice(departure, destination, distance);
	    plane.TimeandPrice(departure, destination, distance);
		scanner.close();//用户输入结束
	}
	    
	    
	    
	   public static void main(String[] args)
	{
		Master master=new Master();
		master.show();
	}
}

	
