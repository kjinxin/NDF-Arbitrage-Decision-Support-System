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
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			for(int i = 0; i < values.length; i++)
				if(i < 4)
					value = value + "'" + values[i] + "',";		//���ַ����������д���
			value = value + values[4] +  ",'" + values[5] + "')";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into member values(" + value;
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
	public static int InsertDeal(String[] values, String name) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			for(int i = 0; i < 3; i++)
				value = value + "'" + values[i] + "',";		//���ַ����������д���
			value = value + values[3] + "," + values[4] + "," + values[5] + ")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into deal_" + name + " values(" + value;
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
	public static int InsertNotification(String[] values, String name) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + values[0] + ",'" + values[1] + "','" + values[2] + "',"
					+ values[3] + "," + values[4] + ",'" + values[5] + "','" + values[6] + "')";		//���ַ����������д���
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into noti_" + name + " values(" + value;
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
//			e.printStackTrace();
		}
		return rs;
	}
	
	//���뵽���ڸ���ı���
	public static int InsertForward(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + "'" + values[0] + "'," + values[1] + "," 
					+ values[2] + ",'" + values[3] + "')";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into forward values(" + value;
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
	public static int InsertList(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);			
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			for(int i = 0; i < values.length - 1; i++)
				value = value + values[i] + ",";
			value = value + "'" + values[values.length - 1] + "')";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into list values(" + value;
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
	public static int InsertMarket(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + "'" + values[0] + "',";
			for(int i = 1; i < values.length - 1; i++)
				value = value + values[i] + ",";
			value = value + "'" + values[values.length - 1] + "')";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into market values(" + value;
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
	
	public static int InsertAccount(String[] values) {
		Connection con = null;
		Statement stmt = null;
		int rs = 0;
		try {
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Connect.URL, Connect.USERNAME, Connect.PASSWORD);
			//��������
			stmt = con.createStatement();
			
			//�õ���Ҫִ�е�ָ��
			String value = "";
			value = value + "'" + values[0] + "'," + values[1] + "," + values[2] + ")";
			
			System.out.println(value);
			
			//����ָ��
			String insert = "insert into account values(" + value;
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
		String[] values = {"0", "test2", "2014/8/27 10:42", "000000", "0.001", "bafwewlabala"};
		String name = "hh";
		Insert.InsertNotification(values, name);
	}
}