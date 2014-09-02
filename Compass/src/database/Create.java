package database;

import java.sql.*;

public class Create {
	public static int CreateTable(String name)
	{
		Connection con = null;
		Statement stmt = null;
		int rs1 = 0;
		int rs2 = 0;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			stmt = con.createStatement();
			
			String create1 = "create table deal_" + name +
							" (order_time char(20), settle_time char(20), operation char(100),"
							+ " dollar double, RMB double, profit double);";
			
			String create2 = "create table noti_" + name +
							" (mark bit, title char(20), time char(16), number int,"
							+ " profit double, content char(100), time_limit char(2),"
							+ " unique(number, profit));";
			
			System.out.println(create1);
			System.out.println(create2);
			
			rs1 = stmt.executeUpdate(create1);
			rs2 = stmt.executeUpdate(create2);
			
			System.out.println(rs1);
			System.out.println(rs2);
			
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return (rs1 < rs2) ? rs1 : rs2;
	}
	
	public static void main(String[] args) 
	{
		String friend = "haha";
		System.out.println(Create.CreateTable(friend));
	}
}
