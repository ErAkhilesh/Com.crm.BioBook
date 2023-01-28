package userModule;

import org.testng.annotations.Test;

import com.BioBook.Pom.HomeModulePage;
import com.BioBook.Pom.HomePage;

import GenericLiberary.BaseClass;


public class WriteAndDeleteCommentWithTestNGTest extends BaseClass {
	
	@Test
	public void writeAndDeleteComment() throws Throwable
	{
	HomePage hp= new HomePage(driver);
	hp.getHomepage().click();
	String Comment2 = fLib.readDataFromPropertyFile("comment2")+random;
	String Comment = fLib.readDataFromPropertyFile("comment");
	String ImagePath3=fLib.readDataFromPropertyFile("ImagePath3");
	HomeModulePage hm=new HomeModulePage(driver);
	hm.comment(Comment);
	hm.shareStatus(Comment2,ImagePath3);
	

	
	}
}
