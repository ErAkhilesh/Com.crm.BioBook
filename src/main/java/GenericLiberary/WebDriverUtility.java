package GenericLiberary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

 
public class WebDriverUtility {
	WebDriver driver ;
	
			
	public   WebDriver browser(String browserTag) {
		//	f
		
		if(browserTag.equalsIgnoreCase("Chrome"))

		{
			driver =new ChromeDriver();
		}
		else if (browserTag.equalsIgnoreCase("FireFox"))
		{

			driver=new FirefoxDriver();
		}
		else {
			System.out.println("No such driver");
		}
		return driver;
	}
	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * 
	 * @param visibleText
	 * @param element
	 */
	public void select(String visibleText,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element);
	}
	/**
	 * 
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest);
	}
	/**
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);

	}
	/**
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver,String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * 
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlart(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver,String partialTitle)
	{
		//step1: use getWindowhandel to captuer all window all window id's
		Set<String> windows =driver.getWindowHandles();
		//step2:iterate through the windows
		java.util.Iterator<String> it = windows.iterator();
		//step:check whether there is next window
		while(it.hasNext())
		{
			//step4:capture current window id
			String winId=it.next();

			//step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle()	;	
			//setp6:check whether current window is expected
			if(currentWinTitle.contains(partialTitle));
			{
				break;
			}

		}


	}	
	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshot\\"+screenShotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;

	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000);");
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		//int y=element.getLocation().getY();
		//jse.executeScript("window.scroolBy(0,"+y+")",element);
		jse.executeScript("argument[0].scrollIntoView(true);",element);
	}
	public static void  fullPageScreenShot(WebDriver driver,String screenShotName) throws Throwable 
	{
	//	Screenshot screenshoot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	//	ImageIO.write(screenshoot.getImage(),"jpg",new File("./SreenShot/"+screenShotName+".jpg"));
	}

	public void customWaitAndClick(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<20) {
			try {
				element.click();
				break;
			}
			catch(Throwable e){
				Thread.sleep(1000);
				count++;
			}
		}
	}
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
			FluentWait wait = new FluentWait(driver);
			wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
			wait.wait(20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			}

}