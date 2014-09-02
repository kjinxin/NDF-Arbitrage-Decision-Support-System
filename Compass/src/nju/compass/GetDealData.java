package nju.compass;

import java.util.ArrayList;

import database.Select;

public class GetDealData {
	private String [][] rowData;
	public GetDealData() {
		ArrayList<String> selection = new ArrayList<String>();
		String table = "deal_" + User.username;
		int count = Select.SelectAll(table, selection);
		int rowNum = selection.size() / count;
		rowData = new String[rowNum][7];
		for(int i = 0; i < rowNum; i ++)
		{
			rowData[rowNum - i - 1][0] = rowNum - i +  "";
			rowData[rowNum - i - 1][1] = selection.get(i * count);
			rowData[rowNum - i - 1][2] = selection.get(i * count + 1);
			rowData[rowNum - i - 1][3] = selection.get(i * count + 2);
			rowData[rowNum - i - 1][4] = selection.get(i * count + 3);
			rowData[rowNum - i - 1][5] = selection.get(i * count + 4);
			rowData[rowNum - i - 1][6] = selection.get(i * count + 5);
		}
	}
	

	public Object [][] getrowData() {
		return rowData;
	}
}
