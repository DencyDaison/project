package cust_project;

import java.sql.SQLException;
import java.util.Scanner;

public class Cust_Project
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		
		customer();
	}
	public static void customer() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	
	// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int ch;
		String s;
		
		do
		{
			System.out.println("MENU\n1. Admin Login\n2. Agent Login\n3. Logout\n enter your choice:");
			ch=sc.nextInt();			
			switch(ch)
			{
					case 1: Admin_Page ob1=new Admin_Page();
					       System.out.println("redirecting to admin page");
							ob1.login();
							break;
					case 2:Agent_Page ob2=new Agent_Page(); 
							ob2.login();
							break;
					case 3: System.exit(0);
						
					default: System.out.println("You Entered wrong menuOption");
							 break;
			}
			
			//System.out.println("Do you want to proceed?(yes/no)");
			// n=sc.nextLine();
		}
		 while(ch!=4);
	}}

	
	


