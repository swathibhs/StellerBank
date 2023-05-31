package steller.Utilities;
 


import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Lokesh
 *
 */

public class JavaUtility {
	/**
	 * this method is used to get random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int randNum=random.nextInt(1000);
		return randNum;
	}
	/**
	 * this method will get current system date
	 * @return
	 */
	public String currentSystemDate()
	{
		Date date = new Date();
		String currentDate = date.toString();
		return currentDate;
		}
	/**
	 * this method is used to get current system date in required format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date date=new Date();
		String cdate=date.toString();
		String[] d=cdate.split(" ");
		
		int month=date.getMonth();
		String week = d[0];
		String Cdat = d[2];
		String year = d[5];
		String dateFormat = month+" "+week+" "+Cdat+" "+year;
		return dateFormat;
		
	}

}
