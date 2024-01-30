package genericUtilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method contains wait condition to load the page
	 * @param driver
	 * @param sec
	 */
	public void pageLoadtimeOut(WebDriver driver, int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	
	/**
	 * This method contains wait condition to wait for particular duration in seconds
	 * @param driver
	 * @param sec
	 */
	public void impwait(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
	/**
	 * This method is used to check whether alert is present or not within particular given seconds
	 * @param driver
	 * @param sec
	 */
	public void alertIsPresent(WebDriver driver, int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * This method will wait for particular given seconds for the element to be visible
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, int sec,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method will wait for particular given seconds for the element to be able to clickable
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element ,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to select the element based on index value
	 * @param element
	 * @param index
	 */
	
	public void selectByIndex(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method is used to select the element based on attribute value
	 * @param element
	 * @param Data
	 */
	public void selectByValue(WebElement element, String Data)
	{
		Select s=new Select(element);
		s.selectByValue(Data);
	}
	
	/**
	 * This method is used to select the element based on visible text
	 * @param text
	 * @param element
	 */
	public void selectVisibleText(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to move the mouse pointer to a particular element
	 * @param driver
	 * @param element
	 */
	
	public void mouseOver(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to move the element from one location to other location by giving source and destination position of element
	 * @param driver
	 * @param element
	 * @param element1
	 */
	
	public void dragAndDrop(WebDriver driver, WebElement element, WebElement element1)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(element, element1).perform();
	}
	
	/**
	 * This method is used to right click on mouse
	 * @param driver
	 */
	public void contextClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method is used right click on element
	 * @param element
	 * @param driver
	 */
	public void contextClickElement(WebElement element,WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method is used double click
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * This method is used double click on  element
	 * @param driver
	 * @param element
	 */
	public void doubleClickElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element);
	}
	
	/**
	 * This method is used to drag and drop on particular element by passing x and y axis 
	 * @param driver
	 * @param element
	 * @param Xaxis
	 * @param Yaxis
	 */
	public void clikElement(WebDriver driver,WebElement element,int Xaxis,int Yaxis)
	{
		Actions a=new Actions(driver);
		a.dragAndDropBy(element,Xaxis, Yaxis).perform();
	}
	
	/**
	 * This method is used to enter by using keys class
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	
	/**
	 * This method is used to switch the frame using index value
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame using element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	
	}
	/**
	 * This method is used to switch the frame using frame name or id
	 * @param driver
	 * @param name
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used to switch the frame using frame address
	 * @param address
	 * @param driver
	 */
	public void switchToFrame(String address,WebDriver driver)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * This method is used to click on ok button on alert popup
	 * @param driver
	 */
	public void alert(WebDriver driver)
	{
		driver.switchTo().alert();
	}
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();	}
	
	/**
	 * This method is used to click on cancel button on alert popup
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	/**
	 * This method is used to enter data on  alert popup
	 * @param driver
	 * @param data
	 */
	public void alertSendKeys(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method is used to get the text from  alert popup
	 * @param driver
	 */
	public String alertGetText(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		return a.getText();
	}
	
	/**
	 * This method switch between windows
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//Use getWindowHandles to capture all the windows
		Set<String> windows = driver.getWindowHandles();
		
		//iterate over all the windows
		Iterator<String> it = windows.iterator();
		
		//check whether next window is there or not
		while(it.hasNext())
		{
			//capture current window ID
			String winId = it.next();
			
			//iterate over window based on that ID and capture the title
			String CurrentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//check whether current window is as expected
			if(CurrentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take  screenshot and stored it into a folder called as screenshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException 
	 */
	
	public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		JavaUtils j=new JavaUtils();
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenShotName+j.getFormattedDate()+".png";
		File dist=new File(path);
		FileUtils.copyFile(src, dist);
		return dist.getAbsolutePath();
			}
		/**
		 * This method is used to get the location of particular element
		 * @param driver
		 */
	public void scroll(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void notification()
	{
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		
	}
	
	
}

