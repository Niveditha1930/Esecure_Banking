package genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class JavaUtils {
	
	public int random(int num)
	{
		Random ran=new Random();
		int random = ran.nextInt(num);
		return random;
	}
	
	/**
	 * This method is used to get System date
	 * @return
	 */
	public String getSystemDate()
	{
	  Date d=new Date();
	  String date = d.toString();
	  return date;
	}
	
	/**
	 * This method is used to get System date in format
	 * @return
	 */
	
	public String getFormattedDate()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		
		Date dt=new Date();
	
		
		String SystemDateInFormat = dateformat.format(dt);
		return SystemDateInFormat;
	}
	
	/**
	 * This method is used to press enter button using robot class
	 * @throws AWTException
	 */
	public int enterKeyUsingRobot(int value) throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(value);
		return value;
	}
	
	/**
	 * This method is used to release the key using robot class
	 * @return 
	 * @throws AWTException
	 */
	public int enterRelease(int value) throws AWTException
	{
		Robot r=new Robot();
		r.keyRelease(value);
		return value;
	
	}
	
	public String extractDigit(WebDriver driver)
	{
		WebDriverUtils w=new WebDriverUtils();
		//w.alert(driver);
		String text = w.alertGetText(driver);	
		String appl="";
		char[] ch = text.toCharArray();
		for(int i=0;i<text.length();i++) {

			if(Character.isDigit(ch[i])) {
				appl=appl+ch[i];
			}
		}
		w.alertAccept(driver);
		return appl;
	}

}
