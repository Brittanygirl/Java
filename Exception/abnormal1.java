package test1;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class abnormal1 {
	public static void main(String[] args)
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		List<Date>list=new ArrayList(10);
		try
		{
			for(int cnt1=0;cnt1<10;cnt1++)
			{
				Date date=dateformat.parse("09-12");
				list.add(date);
			}
		}catch(ParseException e)
		{
			e.printStackTrace();
			System.out.println("Error");
		}
	}

}
