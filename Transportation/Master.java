package Transport;


import java.util.Scanner;

public class Master {
   public void show() {
		Car car=new Car();
		Train train=new Train();
		Plane plane=new Plane();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("����������أ�");
		String departure=scanner.nextLine();
		System.out.println("������Ŀ�ĵأ�");
		String destination=scanner.nextLine();
		System.out.println("���������صľ��룺");
		Double distance=scanner.nextDouble();
		
	    car.TimeandPrice(departure, destination, distance);
	    train.TimeandPrice(departure, destination, distance);
	    plane.TimeandPrice(departure, destination, distance);
		scanner.close();//�û��������
	}
	    
	    
	    
	   public static void main(String[] args)
	{
		Master master=new Master();
		master.show();
	}
}

	
