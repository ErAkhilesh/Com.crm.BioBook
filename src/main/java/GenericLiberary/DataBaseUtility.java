package GenericLiberary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	public void connectToDB() throws Throwable
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstant.DBURL,IPathConstant.DBUSERNAME,IPathConstant.DBPASSWORD);
	}
	public String executeAndgetData(String query,int coulumIndex,String expData) throws Throwable
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data=result.getString(coulumIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData));//compairing
			{
				flag=true;
				break;
			}
			
			
		}
		if(flag) {
			System.out.println(expData+"Project is Created");
			return expData;
		}
		else {
		System.out.println("Project is not created");
			return null;
	}
	}
	public void closeDataBase() throws Throwable
	{
		con.close();
	}
}
