package database;
import java.sql.*;

public class Update {
	//更改指定表里的指定元素
	//所传入的参数分别为：
	public static int UpdateElement(String[] new_elements, String[] property1, String[] type1, 
			String[] old_elements, String[] property2, String[] type2, String[] restraints, String table) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			stmt = con.createStatement();

			for(int i = 0; i < new_elements.length; i++) {
				if(type1[i].equals("char"))
					new_elements[i] = "'" + new_elements[i] + "'";
				System.out.println(new_elements[i]);
			}
			for(int i = 0; i < old_elements.length; i++)
			{
				if(type2[i].equals("char"))
					old_elements[i] = "'" + old_elements[i] + "'";
				System.out.println(old_elements[i]);
			}

			String condition1 = "";
			for(int i = 0; i < new_elements.length; i++)
				if(i != new_elements.length - 1)
					condition1 = condition1 + property1[i] + "=" + new_elements[i] + " , ";
				else
					condition1 = condition1 + property1[i] + "=" + new_elements[i];
			
			String condition2 = "";
			for(int i = 0; i < old_elements.length; i++)
				if(i != old_elements.length - 1)
					condition2 = condition2 + property2[i] + restraints[i] + old_elements[i] + " AND ";
				else
					condition2 = condition2 + property2[i] + restraints[i] + old_elements[i];
			
			String update = "update " + table + " set " + condition1 +  " where " + condition2;
			System.out.println(update);
			rs = stmt.executeUpdate(update);
			
			System.out.println(rs);
			
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
		String[] new_elements = {"heihei"};
		String[] property1 = {"MNAME"};
		String[] type1 = {"char"};
		String[] old_elements = {"haha"};
		String[] property2 = {"MNAME"};
		String[] type2 = {"char"};
		String[] restraints = {"="};
		String table = "Member";
		Update.UpdateElement(new_elements, property1, type1, old_elements, property2, type2, restraints, table);
	}
}
