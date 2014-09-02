package database;
import java.sql.*;

public class Insert {
	//插入到用户信息表中
	public static int InsertMember(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 4)
					value = value + "'" + values[i] + "',";		//对字符串操作进行处理
			value = value + values[4] +  ",'" + values[5] + "')";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into member values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);
			
			System.out.println(rs);
			//关闭与数据库的连接
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//插入到邮件表中
	public static int InsertDeal(String[] values, String name) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < 3; i++)
				value = value + "'" + values[i] + "',";		//对字符串操作进行处理
			value = value + values[3] + "," + values[4] + "," + values[5] + ")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into deal_" + name + " values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//插入到交易记录表中
	public static int InsertNotification(String[] values, String name) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + values[0] + ",'" + values[1] + "','" + values[2] + "',"
					+ values[3] + "," + values[4] + ",'" + values[5] + "','" + values[6] + "')";		//对字符串操作进行处理
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into noti_" + name + " values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e) {
//			e.printStackTrace();
		}
		return rs;
	}
	
	//插入到即期付款方的表中
	public static int InsertForward(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + "'" + values[0] + "'," + values[1] + "," 
					+ values[2] + ",'" + values[3] + "')";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into forward values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//插入到远期收款方的表中
	public static int InsertList(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < values.length - 1; i++)
				value = value + values[i] + ",";
			value = value + "'" + values[values.length - 1] + "')";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into list values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//插入到远期付款方的表中
	public static int InsertMarket(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + "'" + values[0] + "',";
			for(int i = 1; i < values.length - 1; i++)
				value = value + values[i] + ",";
			value = value + "'" + values[values.length - 1] + "')";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into market values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int InsertAccount(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + "'" + values[0] + "'," + values[1] + "," + values[2] + ")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into account values(" + value;
			System.out.println(insert);
			
			//执行指令
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//关闭与数据库的连接
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void main(String[] args)
	{
		String[] values = {"0", "test2", "2014/8/27 10:42", "000000", "0.001", "bafwewlabala"};
		String name = "hh";
		Insert.InsertNotification(values, name);
	}
}