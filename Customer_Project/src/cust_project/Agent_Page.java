package cust_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Agent_Page {

	public void login() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		Connect con=new Connect();
		Statement stmt=(Statement) con.connection().createStatement();
		Scanner sc=new Scanner(System.in);
		String uname,pswd;
		System.out.println("Enter Username:");
		uname=sc.nextLine();
		System.out.println("Enter Password:");
		pswd=sc.nextLine();	
						
						ResultSet rs=stmt.executeQuery("select uname,pswd from agent_table where uname='"+uname+"' AND pswd='"+pswd+"'");
						if(rs.next())
						{
							Agent_Process ob=new Agent_Process();
							ob.agent_process();

				        }
						 else
				        {
				        System.out.println("Invalid login details");	
				        }
				  		  
		

	}

}
