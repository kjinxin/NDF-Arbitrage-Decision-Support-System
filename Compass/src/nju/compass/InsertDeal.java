package nju.compass;

import java.text.*;
import java.util.*;

import database.Insert;

public class InsertDeal {
	public InsertDeal(String type, String operation, String dollar, String RMB, String profit)
	{
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar current = Calendar.getInstance();
		String order_time = sdf.format(current.getTime());
		switch(type.trim())
		{
			case "1W": case "SW" : current.add(Calendar.DAY_OF_WEEK, 7); break;
			case "1M": current.add(Calendar.MONTH, 1); break;
			case "3M": current.add(Calendar.MONTH, 3); break;
			case "6M": current.add(Calendar.MONTH, 6); break;
			case "9M": current.add(Calendar.MONTH, 9); break;
			case "1Y": current.add(Calendar.YEAR, 1); break;
			default: System.out.println("type: " + type + "##"); break;
		}
		String settle_time = sdf.format(current.getTime());
		System.out.println(order_time);
		System.out.println(settle_time);
		String[] values = {order_time, settle_time, operation, dollar, RMB, profit};
		Insert.InsertDeal(values, User.username);
	}
	public static void main(String[] args)
	{
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar current = Calendar.getInstance();
		String order_time = sdf.format(current.getTime());
		current.add(Calendar.DAY_OF_WEEK, 7);
		String settle_time = sdf.format(current.getTime());
		System.out.println(order_time);
		System.out.println(settle_time);
	}
}
