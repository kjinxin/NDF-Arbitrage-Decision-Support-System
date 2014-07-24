package database;
import java.sql.*;

public class Insert {
	//���뵽�û���Ϣ����
	public static int InsertMember(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 2)
					value = value + "'" + values[i] + "',";		//���ַ����������д���
			value = value + "'" + values[2] + "'" +")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into Member values(" + value;
			System.out.println(insert);
			
			//ִ��ָ��
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//�ر������ݿ������
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
	
	//���뵽�ʼ�����
	public static int InsertMail(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 4)
					value = value + "'" + values[i] + "',";		//���ַ����������д���
			value = value + values[4] + "," + values[5] +")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into Mail values(" + value;
			System.out.println(insert);
			
			//ִ��ָ��
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//�ر������ݿ������
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
	
	//���뵽���׼�¼����
	public static int InsertTransaction(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + "'" + values[0] + "'," + values[1] + ','
					+ "'" + values[2] + "'" + values[3] + ")";		//���ַ����������д���
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into TRANSCATION values(" + value;
			System.out.println(insert);
			
			//ִ��ָ��
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//�ر������ݿ������
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
	
	//���뵽���ڸ���ı���
	public static int InsertI_P(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + "'" + values[0] + "'," + "'" + values[1] + "'";
			for(int i = 1; i < values.length; i++)
				value = value + "," +values[i];
			value = value + ")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into I_P values(" + value;
			System.out.println(insert);
			
			//ִ��ָ��
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//�ر������ݿ������
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
	
	//���뵽Զ���տ�ı���
	public static int InsertD_C(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + "'" + values[0] + "'," + "'" + values[1] + "'";
			for(int i = 1; i < values.length; i++)
				value = value + "," +values[i];
			value = value + ")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into D_C values(" + value;
			System.out.println(insert);
			
			//ִ��ָ��
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//�ر������ݿ������
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
	
	//���뵽Զ�ڸ���ı���
	public static int InsertD_P(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + "'" + values[0] + "'," + "'" + values[1] + "'";
			for(int i = 1; i < values.length; i++)
				value = value + "," +values[i];
			value = value + ")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into D_P values(" + value;
			System.out.println(insert);
			
			//ִ��ָ��
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//�ر������ݿ������
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
	
	//���뵽��ʷ���ݱ���
	public static int InsertHistory(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + values[0] + "," + "'" + values[1] + "'," 
					+ values[2] + "," + values[3] + ")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into HISTORY_DATA values(" + value;
			System.out.println(insert);
			
			//ִ��ָ��
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//�ر������ݿ������
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
			//�������ݿ�����
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=Compass", "sa", "19891201");
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + values[0] + "," + "'" + values[1] + "'," 
					+ values[2] + "," + values[3] + ")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into PERIDICT_DATA values(" + value;
			System.out.println(insert);
			
			//ִ��ָ��
			rs = stmt.executeUpdate(insert);

			System.out.println(rs);
			//�ر������ݿ������
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