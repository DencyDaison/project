package cust_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Admin_Page {

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
						
						ResultSet rs=stmt.executeQuery("select adm_uname,adm_pswd from admin_table where adm_uname='"+uname+"' AND adm_pswd='"+pswd+"'");
						if(rs.next())
						{
							Admin_Process ob=new Admin_Process();
							ob.admin_process();
				        }
						 else
				        {
				        System.out.println("Invalid login details");	
				        }
				  		  
		

	}

}
