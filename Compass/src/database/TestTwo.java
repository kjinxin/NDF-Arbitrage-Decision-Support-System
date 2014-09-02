package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

//http://quote.fx168.com/ndf.shtml
public class TestTwo extends java.util.TimerTask {
public static String testPost() throws IOException {   
        URL url = new URL("http://service.fx168.com/quote/handler/Datas.ashx");   
        URLConnection connection = url.openConnection();   
        connection.setDoOutput(true);   
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");   
        out.write("page=fx168-rmb-ndf&vtype=XHWH");
         
        out.flush();   
        out.close();   

        String sCurrentLine;    
        sCurrentLine = "";   
        InputStream l_urlStream;   
        l_urlStream = connection.getInputStream();   
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(   
                l_urlStream));
        String result = "";
        while ((sCurrentLine = l_reader.readLine()) != null) {   
//        	System.out.println(sCurrentLine);   
        	result = result + sCurrentLine;
        }
		return result;     
    }   
  
	public static void insertTable() throws IOException
	{
		String[] type = {"1W", "1M", "2M", "3M", "6M", "9M", "1Y", "2Y", "3Y", "4Y", "5Y"};
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date());
    	String[] values = new String[7];
    	String[] item = testPost().split(",");
    	int j = 0;
    	for(int i = 0; i < item.length; i++)
    	{
    		if(j % 7 == 0)
    		{
    			if(j != 0)
    				Insert.InsertMarket(values);
    			values[j % 7] = type[j / 7];
    			j++;
    		}
    		if(item[i].matches(".*\\d\\.\\d+") || item[i].matches("\\d{2}:\\d{2}:\\d{2}"))
    		{
    			if(item[i].charAt(1) != '.' && item[i].charAt(2) != ':' && item[i].charAt(0) != '-')
    			{
    				values[j % 7] = (String) item[i].subSequence(3, 9);
    				j++;
    			}
    			else
    			{
    				if(item[i].matches("\\d{2}:\\d{2}:\\d{2}"))
    				{
    					values[j % 7] = date;
    					j++;
    				}
    				else
    				{
    					values[j % 7] = item[i];
    					j++;
    				}
    			}
    		}
    	}
    	Insert.InsertMarket(values);	//把最后一项插入到表中
	}

	@Override  
	public void run() {  
	   // TODO Auto-generated method stub  
		try {
			TestTwo.insertTable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
	
    public static void main(String[] args) throws IOException { 
    	TestTwo.insertTable();
    }   
}