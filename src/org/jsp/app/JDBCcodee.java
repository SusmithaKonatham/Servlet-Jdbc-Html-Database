package org.jsp.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JDBCcodee
{

		public static void reg()
		{
			//SQL code
			String url="jdbc:mysql://localhost:3306?user=root&password=12345";
			String query="insert into test.userinfo values(?,?,?,?)";
			//JDBC code
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1,Register.name);
				preparedStatement.setString(2,Register.phone);
				preparedStatement.setString(3,Register.email);
				preparedStatement.setString(4,Register.password);
				if(Register.password.equals(Register.confirmpassword))
				{
					preparedStatement.executeUpdate();
					System.out.println("Successfully updated");
					System.out.println("registered...");
				}
				else
				{
					System.out.println("Unsuccessful");
				}
		
				connection.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public static void fget() 
		{
			//SQL code
			String url="jdbc:mysql://localhost:3306?user=root&password=12345";
			String query="Update test.userinfo set password=? where phone=?";
			String query1="select phone from test.userinfo where phone=?";
		
			//JDBC code
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection(url);
				System.out.println("1");
				PreparedStatement preparedStatement1=connection.prepareStatement(query1);
				System.out.println("2");
				preparedStatement1.setString(1,forget.phone);
			
				ResultSet resultset=preparedStatement1.executeQuery();
			    System.out.println("3");
				PreparedStatement preparedStatement2=connection.prepareStatement(query);
				preparedStatement2.setString(2,forget.phone);
				preparedStatement2.setString(1,forget.newpassword);
				
				if(forget.newpassword.equals(forget.confirmpassword) && resultset.next() )
				{
					preparedStatement2.executeUpdate();
					System.out.println("Successfully updated");
				}
				else
				{
					System.out.println("Unsuccessful");
				}
				connection.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	public static void login(String phone, String password) 
	{
		// TODO Auto-generated method stub
		//SQL code
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="select phone from test.userinfo where phone=? and password=?";
		//JDBC code
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,phone);
			preparedStatement.setString(2,password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				System.out.println("Successsfully logged in.....");
			}
			else
			{
				System.out.println("UnSuccessful");
			}
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void supp(String name, String DescribeIssue) 
		// TODO Auto-generated method stub
		{
			//SQL code
			String url="jdbc:mysql://localhost:3306?user=root&password=12345";
			String query="insert into test.support values(?,?,?,?)";
			//JDBC code
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection=DriverManager.getConnection(url);
				Random random=new Random();
				int refNum=random.nextInt(1000000);
				if(refNum<0)
				{
					refNum=refNum*-1;
				}
				if(refNum>0 && refNum<=999999)
				{
					refNum=refNum+1000000;
				}
				int reference=refNum;
				Date date=new Date();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
				String date1=dateFormat.format(date);
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1,name);
				preparedStatement.setString(2,DescribeIssue);
				preparedStatement.setInt(3,reference);
				preparedStatement.setString(4,date1);
				preparedStatement.executeUpdate();
				System.out.println("reference Id is"+reference);
				System.out.println("Date & Time "+date1);
				connection.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}