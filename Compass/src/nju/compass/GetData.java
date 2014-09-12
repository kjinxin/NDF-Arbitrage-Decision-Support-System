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
	private double [] deposit = {0.0035, 0.0035, 0.0285, 0.0305, 0.0305, 0.0325};
	private double [] dollardeposit = {0.0005, 0.002, 0.003, 0.005, 0.005, 0.0075};
	private double [] WMP = {0.041, 0.042, 0.049, 0.05, 0.051, 0.053};
	private double [] rmbloan = {0.056, 0.056, 0.056, 0.056, 0.06, 0.06};
	private double [] dollarloan = {0.0104, 0.01052, 0.011735, 0.01385, 0.01585, 0.017865};
	private double [] dftime = {0.25, 1, 3, 6, 9, 12};
	private String [] dftype = {"1W", "1M", "3M", "6M", "9M", "1Y"};
	private double [] ndftime = {0.25, 1, 3, 6, 9, 12};
	private String [] ndftype = {"1W", "1M", "3M", "6M", "9M", "1Y"};
	private String [] code = {"00", "01", "03", "06", "09", "12"};
	private String [] time = {" seven days ", " one month ", " three months ", " six months ", " nine months ", " one year "};
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
		
		rowData_t = new String [120][4];
		content = new String [120];
		addcontent = new String [120];
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
		String [][] rowData = new String[120][4];
		int rowNumber = 0; 
		DecimalFormat df = new DecimalFormat("0.00");
		double A;
		double B;
		double r;
		double n;
		double m;
		double R;
		double C;
		// 代号一
		for (int i = 0; i < 6; i++) {
			rowData[rowNumber][0] = "00" + "01" + code[i];
			rowData[rowNumber][1] = "Yes";
			rowData[rowNumber][2] = dftype[i];
			A = Double.parseDouble(list[3]);
			B = Double.parseDouble(forward[i][1]);
			r = WMP[i];
			n = dftime[i];
			rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B) / A);
			content[rowNumber] = "Prompt settlement of exchange, and at the same time forward contracts sold within the territory of" 
			+ time[i] + "s'equivalence the RMB to buy Dollars.";
			addcontent[rowNumber] = "This method successfully carry premise for forward contracts in the Chinese currency to rise in" 
			+ time[i] + "later.";
			rowNumber++;
		}
		// 代号二
		for (int i = 0; i < 6; i++) {
			rowData[rowNumber][0] = "00" + "02" + code[i];
			rowData[rowNumber][1] = "Yes";
			rowData[rowNumber][2] = dftype[i];
			A = Double.parseDouble(list[1]);
			B = Double.parseDouble(forward[i][2]);
			R = dollardeposit[i];
			n = dftime[i];
			rowData[rowNumber][3] = df.format(1000.0 * (B * (1 + R * n / 12) - A) / A);
			content[rowNumber] = "Prompt settlement of exchange and at the same time forward contracts sold within the territory of" 
			+ time[i] + "s' equivalence dollars to buy the RMB.";
			addcontent[rowNumber] = "This method successfully carry premise for forward contracts in the dollars to rise in" 
			+ time[i] + "later.";
			rowNumber++;
		}
		// 代号三
		for (int i = 0; i < 6; i++) {
			for (int j = i; j < 6; j++) {
				rowData[rowNumber][0] = "00" + "03" + code[i];
				rowData[rowNumber][1] = "Yes";
				rowData[rowNumber][2] = dftype[i];
				B = Double.parseDouble(forward[i][2]);
				C = Double.parseDouble(forward[i][1]);
				r = WMP[i];
				m = dftime[j];
				n = dftime[i];
				rowData[rowNumber][3] = df.format(1000.0 * (B * (1 + r * (m - n) / 12) - C) / B);
				content[rowNumber] = "Sell the dollars forward contracts within the territory of" 
						+ time[i] + "to buy the yuan, at the same time" + time[j] + "forward contracts sold within the territory of equivalence the yuan to buy dollars.";
				addcontent[rowNumber] = "This method successfully carry premise for forward contracts in the yuan in the first"
						+ time[i] + "to the first" + time[j] + "during appreciation.";
				rowNumber++;
			}
		}
		// 代号四
		for (int i = 0; i < 6; i++) {
			for (int j = i; j < 6; j++) {
				rowData[rowNumber][0] = "00" + "04" + code[i];
				rowData[rowNumber][1] = "Yes";
				rowData[rowNumber][2] = dftype[i];
				B = Double.parseDouble(forward[i][1]);
				C = Double.parseDouble(forward[i][2]);
				R = dollardeposit[i];
				m = dftime[j];
				n = dftime[i];
				rowData[rowNumber][3] = df.format(1000.0 * (C * (1 + R * (m - n) / 12) - B) / B);
				content[rowNumber] = "Forward contracts signed" + time[i] + "to sell yuan to buy the dollar, at the same time" + time[j] + "forward contracts sold dollars buy the currency equivalent.During the interval months will buy dollars in the bank, yields to the current deposit rate included in the dollar.";
				addcontent[rowNumber] = "This method successfully carry premise for forward contracts in dollars in the first" 
						+ time[i] + "to the first" + time[j] + "during appreciation.";
				rowNumber++;
			}
		}
		// 代号五
		/*
		for (int i = 0; i < 6; i++) {
			rowData[rowNumber][0] = "00" + "05" + code[i];
			rowData[rowNumber][1] = "Yes";
			rowData[rowNumber][2] = dftype[i];
			A = Double.parseDouble(list[1]);
			B = Double.parseDouble(forward[i][2]);
			R = WMP[i];
			R = dollardeposit[i];
			n = dftime[i];
			rowData[rowNumber][3] = df.format(1000.0 * (B * (1 + R * n / 12) - A) / A);
			content[rowNumber] = "Prompt settlement of exchange, and at the same time forward contracts sold within the territory of \n" 
			+ time[i] + "s' equivalence dollars to buy the RMB.";
			addcontent[rowNumber] = "This method successfully carry premise for forward contracts in the dollars to rise in\n " 
			+ time[i] + "later.";
			rowNumber++;
		}*/
		// 代号六
		// 代号七
		//*************** 代号八  ***********************
		// 一个星期
		for (int i = 0; i < 6; i++) {
			rowData[rowNumber][0] = "00" + "08" + code[i];
			rowData[rowNumber][1] = "No";
			rowData[rowNumber][2] = dftype[i];
			A = Double.parseDouble(list[3]);
			B = Double.parseDouble(forward[i][1]);
			r = WMP[i];
			n = dftime[i];
			R = dollarloan[i];
			rowData[rowNumber][3] = df.format(1000.0 * (A * (1 + r * n / 12) - B * (1 + R * n / 12)));
			content[rowNumber] = "At sight for dollar loans, with credit for dollars into RMB in the bank.At the same time a" 
					+ time[i] + "forward contracts to buy dollars to sell within the territory of the yuan. ";
			addcontent[rowNumber] = "Yuan deposited in Banks yield with the current term financial product yield increment ";
			rowNumber ++;
		}
		
		//****************代号九**************************
		for (int i = 0; i < 6; i++) {
			rowData[rowNumber][0] = "00" + "09" + code[i];
			rowData[rowNumber][1] = "No";
			rowData[rowNumber][2] = dftype[i];
			A = Double.parseDouble(list[1]);
			B = Double.parseDouble(forward[0][2]);
			r = deposit[i];
			n = dftime[i];
			R = dollardeposit[i];
			rowData[rowNumber][3] = df.format(1000.0 * (B * (1 + R * n / 12) - A * (1 + r * n / 12)));
			content[rowNumber] = "At sight for RMB loans, with credit for RMB into Dollars in the bank. At the same time" 
					+ time[i] + "s' equivalence dollars to buy the RMB.";
			addcontent[rowNumber] = "This method successfully carry premise for forward contracts in the dollars to rise in" 
					+ time[i] + "forward contracts to buy RMB to sell within the territory of the Dollar.";
			rowNumber ++;
		}
		
		// 代号十
		for (int i = 0; i < 6; i++) {
			for (int j = i; j < 6; j++) {
			rowData[rowNumber][0] = "00" + "10" + code[i];
			rowData[rowNumber][1] = "No";
			rowData[rowNumber][2] = dftype[i];
			B = Double.parseDouble(forward[0][2]);
			C = Double.parseDouble(forward[0][1]);
			r = WMP[i];
			n = dftime[i];
			m = dftime[j];
			R = dollarloan[i];
			rowData[rowNumber][3] = df.format(1000.0 * ( B * (1 + r * (m - n) / 12) - C*(1 + R * (m - n) / 12)));
			content[rowNumber] = "With loan dollars" 
					+ time[i] + "in the future, the duration of the loan for the interval months. Now a" + time[i] +
					"period in sell the dollars forward contracts to buy the yuan, a" + time[j] + 
					"period forward contracts to buy dollars to sell within the territory of the equivalent of RMB.";
			addcontent[rowNumber] = "In interval months period, the RMB in the bank, with current term financial product yield increment.";
			rowNumber ++;
			}
		}
		// 代号十一
		for (int i = 0; i < 6; i++) {
			for (int j = i; j < 6; j++) {
			rowData[rowNumber][0] = "00" + "11" + code[i];
			rowData[rowNumber][1] = "No";
			rowData[rowNumber][2] = dftype[i];
			B = Double.parseDouble(forward[0][1]);
			C = Double.parseDouble(forward[0][2]);
			r = rmbloan[i];
			n = dftime[i];
			m = dftime[j];
			R = dollardeposit[i];
			rowData[rowNumber][3] = df.format(1000.0 * ( C * (1 + R * (m - n) / 12) - B*(1 + r * (m - n) / 12)));
			content[rowNumber] = "With loan the yuan" 
					+ time[i] + "in the future, the duration of the loan for the interval months. Now a" + time[i] +
					"period in sell the RMB forward contracts to buy the dollars, a" + time[j] + 
					"period forward contracts to buy yuan to sell within the territory of the equivalent of dollars.";
			addcontent[rowNumber] = "In interval months period, the dollars in the bank, with current term financial product yield increment.";
			rowNumber ++;
			}
		}
		
		//System.out.print("{");
		for (int i = 0; i < rowNumber; i++)
		{
			//System.out.print("{");
			for (int j = 0; j < 4; j++)
			{
				rowData_t[i][j] = rowData[i][j];
				//System.out.print("\"" + rowData[i][j] + "\"");
				//if (j != 3) System.out.print(",");
			}
			//System.out.println("},");
		}
		/*
		System.out.println("}");
		System.out.print("{");
		for (int i = 0; i < rowNumber; i++)
		{
			System.out.println("\"" + content[i] + "\",");
		}
		System.out.println("}");
		System.out.print("{");
		for (int i = 0; i < rowNumber; i++)
		{
			System.out.println("\"" + addcontent[i] + "\",");
		}
		System.out.println("}");
		*/
		System.out.println(rowNumber + "jinxin");
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
