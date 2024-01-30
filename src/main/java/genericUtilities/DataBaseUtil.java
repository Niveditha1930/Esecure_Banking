package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtil {
	
	Connection con;
	
	public void  getConnection() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("IpathConstants.DBURL","IpathConstants.DBUsername","IpathConstants.DBPassword");
		}
	
	public void executeAndGetData(String query,int colIndex, String ExpData) throws SQLException
	{
		Statement state = con.createStatement();
		ResultSet Result = state.executeQuery(query);
		boolean flag=false;
		while(Result.next())
		{
			String actualresult = Result.getString("colIndex");
			if(actualresult.equalsIgnoreCase(ExpData))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("Data is present");
		}
		else
		{
			System.out.println("Data is not present");
		}
		}
		
		public void closeConnection() throws SQLException
		{
			con.close();
		}
}
