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
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 2)
					value = value + "'" + values[i] + "',";		//对字符串操作进行处理
			value = value + "'" + values[2] + "'" +")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into Member values(" + value;
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
	public static int InsertMail(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 4)
					value = value + "'" + values[i] + "',";		//对字符串操作进行处理
			value = value + values[4] + "," + values[5] +")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into Mail values(" + value;
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
	public static int InsertTransaction(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + "'" + values[0] + "'," + values[1] + ','
					+ "'" + values[2] + "'" + values[3] + ")";		//对字符串操作进行处理
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into TRANSCATION values(" + value;
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
	
	//插入到即期付款方的表中
	public static int InsertI_P(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + "'" + values[0] + "'," + "'" + values[1] + "'";
			for(int i = 1; i < values.length; i++)
				value = value + "," +values[i];
			value = value + ")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into I_P values(" + value;
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
	public static int InsertD_C(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + "'" + values[0] + "'," + "'" + values[1] + "'";
			for(int i = 1; i < values.length; i++)
				value = value + "," +values[i];
			value = value + ")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into D_C values(" + value;
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
	public static int InsertD_P(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + "'" + values[0] + "'," + "'" + values[1] + "'";
			for(int i = 1; i < values.length; i++)
				value = value + "," +values[i];
			value = value + ")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into D_P values(" + value;
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
	
	//插入到历史数据表中
	public static int InsertHistory(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + values[0] + "," + "'" + values[1] + "'," 
					+ values[2] + "," + values[3] + ")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into HISTORY_DATA values(" + value;
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
	
	public static int InsertPredict(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//建立数据库连接
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//创建命令
			stmt = con.createStatement();
			
			//得到需要执行的指令
			String value = "";
			value = value + values[0] + "," + "'" + values[1] + "'," 
					+ values[2] + "," + values[3] + ")";
			
			System.out.println(value);
			
			//生成指令
			String insert = "insert into PERIDICT_DATA values(" + value;
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
		String[] values = {"haha", "Profit", "haha@163.com"};
		Insert.InsertMember(values);
	
	}
}