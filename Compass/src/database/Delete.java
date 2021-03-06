package database;
import java.sql.*;

public class Delete {
	//参数含义分别为：删除的条件，删除的属性（如姓名）、从哪个表里删除、该属性的类型（char或者int）、删除的约束（如"<"、"="）
	public static void DeleteElement(String[] elements, String[] property, String table, String[] type, String[] restraints) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
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
			
			String delete = "delete from " + table + " where " + condition;
			System.out.println(delete);
			rs = stmt.executeUpdate(delete);
			
			System.out.println(rs);
			
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		String[] elements = {"haha"};
		String[] property = {"MNAME"}; 
		String table = "Member";
		String[] type = {"char"}; 
		String[] restraints = {"="};
		Delete.DeleteElement(elements, property, table, type, restraints);
	}
}
