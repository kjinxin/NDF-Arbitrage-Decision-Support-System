package nju.compass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class MarketData extends java.util.TimerTask {
	private String [][] values;
	public MarketData() {
		values = new String [11][6];
	}
	
	public String [][] getValues() {
		return values;
	}
	
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
        	result = result + sCurrentLine;
        }
		return result;     
    }   
  
	public static void main(String[] args) throws IOException { 
		new MarketData();
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String[] type = {"1W", "1M", "2M", "3M", "6M", "9M", "1Y", "2Y", "3Y", "4Y", "5Y"};
    	String[] item;
		try {
			item = testPost().split(",");
			int j = 0;
	    	int t = 0;
	    	for(int i = 0; i < item.length; i++) {
	    		if(j % 6 == 0) {
	    			if (j != 0) {
	    				//System.out.println(values[t][0] + " " +values[t][1] + " " +values[t][2] + " " +values[t][3] + " " +values[t][4] + " " +values[t][5]);
	    				t++;
	    			}
	    			if (t < 11) values[t][j % 6] = type[j / 6];
	    			j++;
	    		}
	    		if(item[i].matches(".*\\d\\.\\d+") || item[i].matches("\\d{2}:\\d{2}:\\d{2}")) {
	    			if(item[i].charAt(1) != '.' && item[i].charAt(2) != ':' && item[i].charAt(0) != '-') {
	    				values[t][j % 6] = (String) item[i].subSequence(3, 9);
	    				j++;
	    			}
	    			else {
	    				if(!item[i].matches("\\d{2}:\\d{2}:\\d{2}")) {
	    					values[t][j % 6] = item[i];
	    					j++;
	    				}
	    			}
	    		}
	    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
