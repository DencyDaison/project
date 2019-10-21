package cust_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public Connection connection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cust_project","root","");  

	if (con != null)
	{
	//System.out.println("Connected");
	}
	else
	{
	System.out.println("not Connected");
	}
	return con;
	}

	}