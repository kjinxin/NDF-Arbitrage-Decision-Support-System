package database;

import java.util.Timer; 

public class CatchData {
	public static void main(String[] args){  
		   Timer timer = new Timer();  
		   
		   //һ���Ӻ�ÿ1��ִ��һ��
		   timer.schedule(new TestOnly(), 0, 86400000);
		   timer.schedule(new TestThree(), 0, 86400000);
		   timer.schedule(new TestTwo(), 0, 86400000);
	} 
}
