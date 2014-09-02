package database;
import java.sql.*;
import java.util.ArrayList;

public class Select {
	//从指定表中选择出所有的元素
	public static int SelectAll(String table, ArrayList<String> selection) {
		int count = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			
			stmt = con.createStatement();
			String select = "select * from " + table;
			System.out.println(select);
			rs = stmt.executeQuery(select);
			
			ResultSetMetaData rsMetaData;
			while(rs.next()) {
				rsMetaData = rs.getMetaData();
				count = rsMetaData.getColumnCount();
				for(int i = 0; i < rsMetaData.getColumnCount(); i++)
					//System.out.println(rs.getString(i + 1));
					selection.add(rs.getString(i + 1));
			}
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
			//return count;
		}
		catch(Exception e) {
			e.printStackTrace();
			count = -1;
		}
		return count;
	}
	
	//从指定表中选择出满足某一特定条件的元素
	//传入的参数分别为元素、属性、表名、类型、约束，结果存放在ArrayList中返回给用户 
	public static int SelectElement(String[] elements, String[] property, 
			String table, String[] type, String[] restraints, ArrayList<String> selection) {	
		int count = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			
			stmt = con.createStatement();
			for(int i = 0; i < elements.length; i++) {
				if(type[i].equals("char"))
					elements[i] = "'" + elements[i] + "'";
				System.out.println(elements[i]);
			}
			
			String condition = "";
			for(int i = 0; i < elements.length; i++)
				if(i != elements.length - 1)
					condition = condition + property[i] + restraints[i] + elements[i] + " AND ";
				else
					condition = condition + property[i] + restraints[i] + elements[i];
				
			String select = "select * from " + table + " where " + condition;
			System.out.println(select);
			rs = stmt.executeQuery(select);
			
			ResultSetMetaData rsMetaData;
			while(rs.next()) {
				rsMetaData = rs.getMetaData();
				count = rsMetaData.getColumnCount();
				for(int i = 0; i < rsMetaData.getColumnCount(); i++)
					//System.out.println(rs.getString(i + 1));
					selection.add(rs.getString(i + 1));
			}
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
			return count;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//按时间排序
	public static int SelectRow(String table, ArrayList<String> selection, int row) {
		int count = 0;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);			
			stmt = con.createStatement();
			String select = "select * from " + table + " limit " + row + ",1";
			System.out.println(select);
			rs = stmt.executeQuery(select);
			
			ResultSetMetaData rsMetaData;
			while(rs.next()) {
				rsMetaData = rs.getMetaData();
				count = rsMetaData.getColumnCount();
				for(int i = 0; i < rsMetaData.getColumnCount(); i++)
					//System.out.println(rs.getString(i + 1));
					selection.add(rs.getString(i + 1));
			}
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
			//return count;
		}
		catch(Exception e) {
			e.printStackTrace();
			count = -1;
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		String[] elements = {"ab"};
		String[] property = {"name"};
		String table = "member";
		String[] type = {"char"};
		String[] restraints = {"="};
		ArrayList<String> selection = new ArrayList<String>();
		int count = Select.SelectElement(elements, property, table, type, restraints, selection);
		System.out.println(count);
	}
}
