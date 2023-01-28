package GenericLiberary;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstant.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		
		return value;
	}
	public String readDataFromPropertyFile1(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstant.FilePath1);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		
		return value;
	}


}
