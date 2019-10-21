package cust_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Agent_Process {

	
		// TODO Auto-generated method stub
		static Connect con=new Connect();
		
		public void agent_process() throws ClassNotFoundException, SQLException 
		{
			Scanner sc=new Scanner(System.in);
			int ch;
			String s;
			
			do
			{
				System.out.println("MENU\n1. Buy/Sell\n2. Show history \n3. Logout\n enter your choice:");
				ch=sc.nextInt();			
				switch(ch)
				{
						case 1: buysell();
								break;
						case 2:showhistory();
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
		
		public void buysell() throws ClassNotFoundException, SQLException 
		{
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			Statement stmt=(Statement) con.connection().createStatement();
			ResultSet rs;
			System.out.println("enter product id:");
			int p_id1=sc.nextInt();
			sc.nextLine();
			System.out.println("choose buy or sell:");	
			String buy=sc.nextLine();
			if(buy.equalsIgnoreCase("buy"))
			{
				String s="select p_name,p_price from admin_table where p_id='"+p_id1+"';";
				 rs=stmt.executeQuery(s);
				System.out.println("Product_name  Product_price");
				while(rs.next()) 
				{
					String p_name=rs.getString("p_name");
					int p_price=rs.getInt("p_price");
					System.out.print(p_name+"          ");
					System.out.print(p_price+"       ");
					System.out.println();
				}
			}
			//Statement stmt1=(Statement) con.connection().createStatement();
			
			System.out.println("Enter the quantity:");
			int qty=sc.nextInt();			
			 rs=stmt.executeQuery("select p_minsellq,p_price,p_name from admin_table where p_id='"+p_id1+"'");
					 while(rs.next())
					 {
						 int qty1=rs.getInt("p_minsellq");
			//System.out.println(qty1);
						 int p_price=rs.getInt("p_price");
						 String p_name=rs.getString("p_name");
					 
					 
						 if(qty<qty1)
						 {
							 int tot=qty*p_price;
							 	System.out.println("total cost:"+tot);
							 	sc.nextLine();
							 	System.out.println("confirm booking(yes/no)");
							 	String confirm=sc.nextLine();
							 	if(confirm.equalsIgnoreCase("yes"))
							 	{
							 		stmt.executeUpdate("insert into agent_table(transaction,p_id,p_name,qty,tot_cost,price)values('"+buy+"','"+p_id1+"','"+p_name+"','"+qty+"','"+tot+"','"+p_price+"')");
							 		qty1=qty1-qty;
							 		String s1="update admin_table set p_minsellq='"+qty1+"' where p_id='"+p_id1+"';";
							 		stmt.executeUpdate(s1);
							 	}
							 	
						 }
						 else
						 {
							 System.out.println("only available quantity is "+qty1);
				
						 }
					}				
		}
		public void showhistory() throws SQLException, ClassNotFoundException 
		{
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			String s="select p_id,p_name,transaction,qty,price,tot_cost from agent_table";
			Statement stmt=(Statement) con.connection().createStatement();
			ResultSet rs=stmt.executeQuery(s);
			System.out.println("product_id  product_name transaction  product_quantity  product_price Total_cost");
			while(rs.next())
			{
				int p_id=rs.getInt("p_id");
				String p_name=rs.getString("p_name");
				String t=rs.getString("transaction");
				int p_minsellq=rs.getInt("qty");
				int p_price=rs.getInt("price");
				int tot=rs.getInt("tot_cost");
				System.out.print(p_id+"          ");
				System.out.print(p_name+"         ");
				System.out.print(t+"            ");
				System.out.print(p_minsellq+"          ");
				System.out.print(p_price+"        ");
				System.out.print(tot+"        ");
				System.out.println();
				
			}
			
			
		}
		
	}


