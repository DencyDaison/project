package cust_project;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;


public class Admin_Process
{
	static Connect con=new Connect();
	public void admin_process() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		int ch;
		String s;
		
		do
		{
			System.out.println("MENU\n1. Add Product\n2. Display Inventory Details\n3. Logout\n enter your choice:");
			ch=sc.nextInt();			
			switch(ch)
			{
					case 1: add();
							break;
					case 2:display();
							break;
					case 3: Cust_Project obj=new Cust_Project();
							obj.customer();
					default: System.out.println("You Entered wrong menuOption");
							 break;
			}
			
			//System.out.println("Do you want to proceed?(yes/no)");
			// n=sc.nextLine();
		}
		 while(ch!=4);
	}

	public static void add() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		Statement stmt=(Statement) con.connection().createStatement();
		String p_name;
		int p_price,p_minsellq;
		System.out.println("Enter product name");
		p_name=sc.nextLine();
		System.out.println("Enter product minsellquantity");
		p_minsellq=sc.nextInt();		
		System.out.println("Enter product price");
		p_price=sc.nextInt();			
		stmt.executeUpdate("INSERT INTO admin_table(p_name,p_minsellq,p_price) VALUES ('"+p_name+"','"+p_minsellq+"','"+p_price+"')");
			
	}
	public static void display() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s="select p_id,p_name,p_minsellq,p_price from admin_table";
		Statement stmt=(Statement) con.connection().createStatement();
		ResultSet rs=stmt.executeQuery(s);
		System.out.println("product_id  product_name  product_quantity  product_price");
		while(rs.next())
		{
			int p_id=rs.getInt("p_id");
			String p_name=rs.getString("p_name");
			int p_minsellq=rs.getInt("p_minsellq");
			int p_price=rs.getInt("p_price");
			System.out.print(p_id+"          ");
			System.out.print(p_name+"                ");
			System.out.print(p_minsellq+"            ");
			System.out.print(p_price+"       ");
			System.out.println();
			
		}
		
	}
	

	
	}

