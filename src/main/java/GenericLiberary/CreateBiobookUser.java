package GenericLiberary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


		public class CreateBiobookUser {

			public static void main(String[] args) throws IOException {
				
				Random ran=new Random();
				int random= ran.nextInt(500);
				
				// step 1 get common data
				FileInputStream fis = new FileInputStream("./src/test/resources/BioBookcommondata.Properties");
				Properties p = new Properties();
				p.load(fis);
				String URL = p.getProperty("url");
				String EMAIL = p.getProperty("email");
				String PASSWORD = p.getProperty("password");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//signin to Biobook
				driver.findElement(By.className("btn-sign-in")).click();
				driver.findElement(By.name("email")).sendKeys(EMAIL);
				driver.findElement(By.name("password")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//input[@name='submit']")).click();
				
				// goto profile module
				driver.findElement(By.xpath("//label[text()='Profile']")).click();
				//click on update profile
				driver.findElement(By.xpath("//button[text()='Update Picture']")).click();
				driver.findElement(By.xpath("//input[@type='file']")).sendKeys("D:\\BioBook\\khan.jpeg");
				driver.findElement(By.xpath("(//input[@name='image'])[2]")).click();
				driver.findElement(By.xpath("//label[text()='Users1']")).click();
				driver.findElement(By.name("content_comment")).sendKeys("gud nyt everone");
				driver.findElement(By.className("btn-comment")).click();
				driver.findElement(By.xpath("(//div[text()='gud nyt everone']/parent::*/div[1])[1]")).click();
				System.out.println("delete the comment successfully");
				driver.findElement(By.xpath("//label[text()='Home']")).click();
				driver.findElement(By.xpath("//button[text()='Log out']")).click();
				

			}

		

	}


