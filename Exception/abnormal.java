package test1;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.*;

public class abnormal
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		List<Date>list=new ArrayList(10);
		for(int cnt=0;cnt<10;cnt++)
		{
			try 
			{
			  Date date=dateformat.parse("09-12");
			  list.add(date);
			}
			catch(ParseException e)
			{
		      e.printStackTrace();
		      System.out.println("ERROR");
		    } 
	   }
    }
}
