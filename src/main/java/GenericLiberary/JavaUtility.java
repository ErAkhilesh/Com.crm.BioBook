package GenericLiberary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNo()
	{
		Random ran= new Random();
		int random=ran.nextInt(500);
		return random;
		
	}
	public String getSystemDate() {
		Date dt=new Date();
		String date=dt.toString();
		return date;
	}
	public String getSystemDateAndTimeFormate() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		Date sysDateTime=new Date();
		String getDateAndTime=dateformat.format(sysDateTime);
		return getDateAndTime.replaceAll(":", "-");
	}
}
