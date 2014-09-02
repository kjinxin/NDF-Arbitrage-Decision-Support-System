package nju.compass;

import java.util.ArrayList;

import javax.swing.JPanel;

import database.Select;

public class GetNotificationData {
	private String [][] rowData_t;
	private JPanel contentPane_t;
	private int rowNumber;
	public GetNotificationData(JPanel contentPane) {
		contentPane_t = contentPane;
		contentPane_t.repaint();
	}
	

	public void run(int t) {
		ArrayList<String> result = new ArrayList<String>();
		String table = "noti_" + User.username;
		int count = Select.SelectAll(table, result);
		rowNumber = result.size()/count;
		String[][] rowData = new String[rowNumber][5];
		for(int i = 0 ; i < rowNumber; i++)
		{
			rowData[i][0] = i + 1 + "";
			if(result.get(count * (rowNumber - i - 1)).equals("0"))
				rowData[i][1] = "unread";
			else
				rowData[i][1] = "read";
			rowData[i][2] = result.get(count * (rowNumber - i - 1) + 1);
			rowData[i][3] = result.get(count * (rowNumber - i - 1) + 2);
			rowData[i][4] = "编码： " + result.get(count * (rowNumber - i - 1) + 3)  + "\n套利操作说明： " + result.get(count * (rowNumber - i - 1) + 5)
					+ "\n收益率： " + result.get(count * (rowNumber - i - 1) + 4);
		}
		if (t == 1) {
			rowData_t = new String [rowNumber][5];
		} 
		else {
			for (int i = 0; i < 5; i++) {
				rowData_t[rowNumber][i] = "";
			}
		}
		for (int i = 0; i < rowNumber; i++)
			for (int j = 0; j < 5; j++)
				rowData_t[i][j] = rowData[i][j];
		contentPane_t.repaint();
	}

	public Object [][] getrowData() {
		return rowData_t;
	}
	
	public int getnumber() {
		return rowNumber;
	}
}
