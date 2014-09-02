package nju.compass;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;

import database.Insert;
import database.Select;

public class GetData extends java.util.TimerTask {
	private String [][] rowData_t;
	private String [] content;
	private String [] addcontent;
	private String [][] forward;
	private String [][] market;
	private String [] list;
	private double [] deposit = {0.0035, 0.0285, 0.0305, 0.0325, 0.0375, 0.0425, 0.0475};
	private double [] rmbloan = {0.056, 0.06, 0.0615, 0.064, 0.0655};
	private double [] dollarloan = {0.0005, 0.0005, 0.002, 0.003, 0.005, 0.0075, 0.0075};
	private double [] dftime = {0.25, 1, 3, 6, 9, 12};
	private String [] dftype = {"1W", "1M", "3M", "6M", "9M", "1Y"};
	private double [] ndftime = {0.25, 1, 2, 3, 6, 9, 12, 24, 36, 48, 60};
	private String [] ndftype = {"1W", "1M", "2M", "3M", "6M", "9M", "1Y", "2Y", "3Y", "4Y", "5Y"};
	private MarketData marketData;
	private ForwardData forwardData;
	private ListData listData;
	
	public static void main(String [] args) {
		new GetData();
	}
	public GetData() {
		marketData = new MarketData();
		forwardData = new ForwardData();
		listData = new ListData();
		listData.run();
		forwardData.run();
		marketData.run();
		Timer timer = new Timer();
		timer.schedule(marketData, 0, 5 * 60 * 1000);
		timer.schedule(forwardData, 0, 5 * 60 * 1000);
		timer.schedule(listData, 0, 5 * 60 * 1000);
		forward = forwardData.getValues();
		market = marketData.getValues();
		list = listData.getValues();
		
		rowData_t = new String [100][4];
		content = new String [100];
		addcontent = new String [100];
	} 
	public Object [][] getrowData() {
		return rowData_t;
	}
	
	public String [] getcontent() {
		return content;
	}
	
	public String [] getaddcontent() {
		return addcontent;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String [][] rowData = new String[100][4];
		int rowNumber = 0; 
		DecimalFormat df = new DecimalFormat("0.00");
		// 代号一
		double A;
		double B;
		double r;
		double n;
		double R;
		rowData[rowNumber][0] = "000000";
		rowData[rowNumber][1] = "有";
		rowData[rowNumber][2] = dftype[0];
		A = Double.parseDouble(list[3]);
		B = Double.parseDouble(forward[0][2]);
		r = deposit[0];
		n = dftime[0];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B) / A);
		content[rowNumber] = "即期结汇，同时签订X个月境内远期\n 合约卖出等值人民币买入美元。";
		addcontent[rowNumber] = "此方法成功套利前提为远期合约中人民币于\n 七天后升值。";
		rowNumber ++;
		rowData[rowNumber][0] = "000001";
		rowData[rowNumber][1] = "有";
		rowData[rowNumber][2] = dftype[1];
		A = Double.parseDouble(list[3]); 
		B = Double.parseDouble(forward[1][2]);
		r = deposit[0];
		n = dftime[0];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B) / A);
		rowNumber ++;
		
		// 代号二

		// 代号三

		// 代号四

		// 代号五

		// 代号六
		// 代号七
		//*************** 代号八  ***********************
		// 一个星期
		rowData[rowNumber][0] = "000800";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[0];
		A = Double.parseDouble(list[3]);
		B = Double.parseDouble(forward[0][1]);
		r = deposit[0];
		n = dftime[0];
		R = dollarloan[0];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 1M
		rowData[rowNumber][0] = "000801";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[1];
		A = Double.parseDouble(list[3]);
		B = Double.parseDouble(forward[1][1]);
		r = deposit[0];   // 活期
		n = dftime[1];
		R = dollarloan[2];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 3M
		rowData[rowNumber][0] = "000803";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[2];
		A = Double.parseDouble(list[3]);
		B = Double.parseDouble(forward[2][1]);
		r = deposit[1];   
		n = dftime[2];
		R = dollarloan[3];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 6M
		rowData[rowNumber][0] = "000806";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[3];
		A = Double.parseDouble(list[3]);
		B = Double.parseDouble(forward[3][1]);
		r = deposit[2];   
		n = dftime[3];
		R = dollarloan[4];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 9M
		rowData[rowNumber][0] = "000809";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[4];
		A = Double.parseDouble(list[3]);
		B = Double.parseDouble(forward[4][1]);
		r = deposit[2];   
		n = dftime[4];
		R = dollarloan[5];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 1Y 
		rowData[rowNumber][0] = "000812";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[5];
		A = Double.parseDouble(list[3]);
		B = Double.parseDouble(forward[5][1]);
		r = deposit[3];   
		n = dftime[5];
		R = dollarloan[5];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		//****************代号九**************************
		// 一个星期
		rowData[rowNumber][0] = "000900";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[0];
		A = Double.parseDouble(list[1]);
		B = Double.parseDouble(forward[0][2]);
		r = deposit[0];
		n = dftime[0];
		R = dollarloan[0];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 1M
		rowData[rowNumber][0] = "000901";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[1];
		A = Double.parseDouble(list[1]);
		B = Double.parseDouble(forward[1][2]);
		r = deposit[0];   // 活期
		n = dftime[1];
		R = dollarloan[2];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 3M
		rowData[rowNumber][0] = "000903";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[2];
		A = Double.parseDouble(list[1]);
		B = Double.parseDouble(forward[2][2]);
		r = deposit[1];   
		n = dftime[2];
		R = dollarloan[3];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 6M
		rowData[rowNumber][0] = "000906";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[3];
		A = Double.parseDouble(list[1]);
		B = Double.parseDouble(forward[3][2]);
		r = deposit[2];   
		n = dftime[3];
		R = dollarloan[4];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 9M
		rowData[rowNumber][0] = "000909";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[4];
		A = Double.parseDouble(list[1]);
		B = Double.parseDouble(forward[4][2]);
		r = deposit[2];   
		n = dftime[4];
		R = dollarloan[5];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		
		// 1Y 
		rowData[rowNumber][0] = "000912";
		rowData[rowNumber][1] = "无";
		rowData[rowNumber][2] = dftype[5];
		A = Double.parseDouble(list[1]);
		B = Double.parseDouble(forward[5][2]);
		r = deposit[3];   
		n = dftime[5];
		R = dollarloan[5];
		rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
		rowNumber ++;
		//
		// 代号十
		// 代号十一

		for (int i = 0; i < rowNumber; i++)
			for (int j = 0; j < 4; j++)
				rowData_t[i][j] = rowData[i][j];
		
		String Name = User.username;
		String[] elements = {Name};
		String[] property = {"name"};
		String table = "member";
		String[] type = {"char"};
		String[] restraints = {"="};
		ArrayList<String> selection = new ArrayList<String>();
		Select.SelectElement(elements, property, table, type, restraints, selection);
		String period = selection.get(3).trim();	//用户设定的时间期限
		String rate = selection.get(4).trim();		//用户设定的指定收益率
		for(int i = 0; i < rowNumber; i++)
		{
			if(rowData[i][1].equals("无") || (period.equals("") && rate.equals("0")))
			{
				if(Double.parseDouble(rowData[i][3]) > 0)
				{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					String date=sdf.format(new Date());
					String[] values = {"0", "有重大套利机会！", date, rowData[i][0], rowData[i][3], content[i], rowData[i][2]};
					Insert.InsertNotification(values, Name);
				}
			}
			else
			{
				if(period.equals(rowData[i][2]) && 
						Double.parseDouble(rowData[i][3]) > Double.parseDouble(rate))	//满足用户设置的条件
				{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
					String date=sdf.format(new Date());
					String[] values = {"0", "有重大套利机会！", date, rowData[i][0], rowData[i][3], content[i], rowData[i][2]};
					Insert.InsertNotification(values, Name);
				}
			}
		}
	}
	
	
}
