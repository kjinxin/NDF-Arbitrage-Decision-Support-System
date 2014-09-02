package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//http://srh.bankofchina.com/search/whpj/search.jsp
public class TestThree extends java.util.TimerTask {
	public static ArrayList<String> testPost() throws IOException {   
        URL url = new URL("http://srh.bankofchina.com/search/whpj/search.jsp");   
        URLConnection connection = url.openConnection();   
        connection.setDoOutput(true);   
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date());
        
        out.write("erectDate="+date+"&nothing="+date+"&pjname=1316&page=1");
         
        out.flush();   
        out.close();   

        String sCurrentLine;    
        sCurrentLine = "";   
        InputStream l_urlStream;   
        l_urlStream = connection.getInputStream();   
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(   
                l_urlStream));  
        ArrayList<String> result = new ArrayList<String>();
        while ((sCurrentLine = l_reader.readLine()) != null) {
        	if(sCurrentLine.replaceAll("[\t]", "").matches("<td>\\d+\\.\\d+</td>"))
        	{
        		System.out.println(sCurrentLine.replaceAll("[\t]", ""));
        		result.add(sCurrentLine.replaceAll("[\t]", ""));
        	}
        }
        return result;
    }   
  
	public static void insertTable() throws IOException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date());
		ArrayList<String> result = testPost();
    	String[] values = new String[5];

    	try {
			result = testPost();
			if(result.get(0).charAt(9) == '<')
	    		values[0] = result.get(0).substring(4, 9);
	    	else
	    		values[0] = result.get(0).substring(4, 10);
	    	if(result.get(1).charAt(9) == '<')
	    		values[1] = result.get(1).substring(4, 9);
	    	else
	    		values[1] = result.get(1).substring(4, 10);
	    	if(result.get(2).charAt(9) == '<')
	    		values[2] = result.get(2).substring(4, 9);
	    	else
	    		values[2] = result.get(2).substring(4, 10);
	    	if(result.get(3).charAt(9) == '<')
	    		values[3] = result.get(3).substring(4, 9);
	    	else
	    		values[3] = result.get(3).substring(4, 10);
	    	values[4] = date;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Insert.InsertList(values);
	}
	
	@Override  
	public void run() {  
	   // TODO Auto-generated method stub  
		try {
			TestThree.insertTable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}  
	
    public static void main(String[] args) throws IOException {
    	TestThree.insertTable();
    }   
}