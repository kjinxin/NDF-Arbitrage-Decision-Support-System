package nju.compass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//http://www.kvbfinance.com/DataCenter/ForwardData.aspx
public class ForwardData  extends java.util.TimerTask {
	private String [][] values;
	public ForwardData() {
		values = new String [6][3];
	}
	public String [][] getValues() {
		return values;
	}
	public static String getHtmlContent(URL url, String encode) {
		StringBuffer contentBuffer = new StringBuffer();

		int responseCode = -1;
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			con.setConnectTimeout(60000);
			con.setReadTimeout(60000);

			responseCode = con.getResponseCode();
			if (responseCode == -1) {
				System.out.println(url.toString() + " : connection is failure...");
				con.disconnect();
				return null;
			}
			if (responseCode >= 400){
				System.out.println("«Î«Û ß∞‹:get response code: " + responseCode);
				con.disconnect();
				return null;
			}

			InputStream inStr = con.getInputStream();
			InputStreamReader istreamReader = new InputStreamReader(inStr, encode);
			BufferedReader buffStr = new BufferedReader(istreamReader);

			String str = null;
			while ((str = buffStr.readLine()) != null)
				contentBuffer.append(str);
			inStr.close();
		} catch (IOException e) {
			e.printStackTrace();
			contentBuffer = null;
			System.out.println("error: " + url.toString());
		} finally {
			con.disconnect();
		}
		return contentBuffer.toString();
	}

	public static String getHtmlContent(String url, String encode) {
		if (!url.toLowerCase().startsWith("http://")) {
			url = "http://" + url;
		}
		try {
			URL rUrl = new URL(url);
			return getHtmlContent(rUrl, encode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String argsp[]){
		new ForwardData();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String result = getHtmlContent("http://www.kvbfinance.com/DataCenter/kvbQuotes.aspx?type=4","utf-8");
		String [] item = result.split(",");
		int j = 0;
		for(int i = 0; i < item.length; i++) {
			if(item[i].substring(0, 3).equals("CNY")) {
				values[j][0] = item[i].substring(13, 15);
				values[j][1] = item[i].substring(20, 26);
				values[j][2] = item[i].substring(31, 37);
				//System.out.println(values[j][0] + " " + values[j][1] + " " + values[j][2]);
				j++;
			}
		}
	}
}