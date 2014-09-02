package nju.compass;


import javax.swing.JOptionPane;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.*;
import org.htmlparser.util.NodeList;


public class GetNews extends java.util.TimerTask {
	private String[][] rowData_t;
	private String[] linkData_t;
	private int num;
	private int rowNumber;
	
	public Object [][] getrowData() {
		return rowData_t;
	}
	
	public String [] getlinkData() {
		return linkData_t;
	}
	
	public GetNews(int num_1) {
		num = num_1;
		rowData_t = new String [num * 5][3];
		linkData_t = new String[num * 5];
		rowNumber = 0;
	}

	@Override
	public void run() {
		String [][] rowData = new String [num * 5][3];
		String [] linkData = new String[num * 5];
		rowNumber = 0;
		// TODO Auto-generated method stub
		try {
			// 查询http://money.sohu.com/waihui_scrollnews/页面 滚动新闻的  标签 以及class
			NodeFilter filter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("class", "f14list"));
			Parser parser = new Parser();
			parser.setURL("http://stock.sohu.com/kuaixun/");  
			NodeList list = parser.extractAllNodesThatMatch(filter);
			for (int i = 0; i < list.size(); i++) {
				Tag node = (Tag) list.elementAt(i);
				for (int j = 0; j < node.getChildren().size(); j++) {
					String textstr = node.getChildren().elementAt(j).toHtml().trim();
					//System.out.println(textstr);
					if (textstr.length() > 0) {
						int linkbegin=0, linkend=0, titlebegin=0, titleend=0, timebegin=0, timeend=0;
						while(true){
							// achieve of the link
							linkbegin = textstr.indexOf("href=\'",timeend);			// 截取链接字符串起始位置
							//如果不存在 href了 也就结束了
							if(linkbegin < 0) break;
							linkend = textstr.indexOf(".shtml",linkbegin);				// 截取链接字符串结束位置
							String sublink = textstr.substring(linkbegin + 6,linkend+6);
					
							// achieve of the title
							titlebegin = textstr.indexOf(">",linkend);    				// get the beginning position of the title
							titleend = textstr.indexOf("</a>",titlebegin);      		// get the end position of the title
							String title = textstr.substring(titlebegin + 1,titleend);
							
							// achieve of the time                                        
							timebegin = textstr.indexOf("(",titleend);                  // get the beginning of the time
							timeend = textstr.indexOf(")",timebegin);                   // get the start position of the time
							String time = textstr.substring(timebegin+1, timeend);
							
							if (rowNumber < num) {
								rowData[rowNumber][0] = time;
								rowData[rowNumber][1] = "搜狐财经";
								rowData[rowNumber][2] = title;
								linkData[rowNumber] = sublink;
								rowNumber ++; 
							}
						}
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check your network connection", "Network failure", JOptionPane.ERROR_MESSAGE);
		}
		
		// 查询http://money.sohu.com/waihui_scrollnews/页面 滚动新闻的  标签 以及class
		try {
			NodeFilter filter = new AndFilter(new TagNameFilter("ul"), new HasAttributeFilter("class", "list_009"));
			Parser parser = new Parser();
			parser.setURL("http://roll.finance.sina.com.cn/finance/wh/whgdxw/index.shtml");  
			NodeList list = parser.extractAllNodesThatMatch(filter);
			for (int i = 0; i < list.size(); i++) {
				Tag node = (Tag) list.elementAt(i);
				for (int j = 0; j < node.getChildren().size(); j++) {
					String textstr = node.getChildren().elementAt(j).toHtml().trim();
					if (textstr.length() > 0) {
						int linkbegin=0, linkend=0, titlebegin=0, titleend=0, timebegin=0, timeend=0;
						while(true){
							// achieve of the link
							linkbegin = textstr.indexOf("href=\"", timeend);			// 截取链接字符串起始位置
							//如果不存在 href了 也就结束了
							if(linkbegin < 0) break;
							linkend = textstr.indexOf(".shtml", linkbegin);				// 截取链接字符串结束位置
							String sublink = textstr.substring(linkbegin + 6,linkend+6);
					
							// achieve of the title
							titlebegin = textstr.indexOf(">",linkend);    				// get the beginning position of the title
							titleend = textstr.indexOf("</a>",titlebegin);      		// get the end position of the title
							String title = textstr.substring(titlebegin + 1,titleend);
							
							// achieve of the time                                        
							timebegin = textstr.indexOf("(",titleend);                  // get the beginning of the time
							timeend = textstr.indexOf(")",timebegin);                   // get the start position of the time
							String time = textstr.substring(timebegin+1, timeend);
							time = time.replace('月', '/');
							time = time.replace("日", "");
							
							if (rowNumber < num * 2) {
								rowData[rowNumber][0] = time;
								rowData[rowNumber][1] = "新浪财经";
								rowData[rowNumber][2] = title;
								linkData[rowNumber] = sublink;
								rowNumber ++; 
							}
							
						}
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check your network connection", "Network failure", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		// 查询http://finance.qq.com/stock/gsxw.htm页面 滚动新闻的  标签 以及class
		try {
			NodeFilter filter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("id", "listZone"));
			Parser parser = new Parser();
			parser.setURL("http://finance.qq.com/stock/gsxw.htm");  
			NodeList list = parser.extractAllNodesThatMatch(filter);
			for (int i = 0; i < list.size(); i++) {
				Tag node = (Tag) list.elementAt(i);
				for (int j = 0; j < node.getChildren().size(); j++) {
					String textstr = node.getChildren().elementAt(j).toHtml().trim();
					//System.out.println(textstr);
					if (textstr.length() > 0) {
						int linkbegin=0, linkend=0, titlebegin=0, titleend=0, timebegin=0, timeend=0;
						while(true){	
							// achieve of the link
							linkbegin = textstr.indexOf("blank\" href=", timeend);			// 截取链接字符串起始位置
							//如果不存在 href了 也就结束了
							if(linkbegin < 0) break;
							linkend = textstr.indexOf(".htm", linkbegin);				// 截取链接字符串结束位置
							String sublink = textstr.substring(linkbegin + 12,linkend + 4);
							sublink = sublink.replace("\"", "http://finance.qq.com");
						
							// achieve of the title
							titlebegin = textstr.indexOf("\">",linkend);    				// get the beginning position of the title
							titleend = textstr.indexOf("</a>",titlebegin);      		// get the end position of the title
							String title =  (titlebegin + 2 < titleend) ? textstr.substring(titlebegin + 2,titleend) : "中国金融市场一周走势回顾";
							
							// achieve of the time                                        
							timebegin = textstr.indexOf("date\">",titleend);                  // get the beginning of the time
							timeend = textstr.indexOf("</span>",timebegin);                   // get the start position of the time
							String time = textstr.substring(timebegin+6, timeend);
							time = time.replace('月', '/');
							time = time.replace("日", "");
							
							if (rowNumber < 3 * num) {
								rowData[rowNumber][0] = time;
								rowData[rowNumber][1] = "腾讯财经";
								rowData[rowNumber][2] = title;
								linkData[rowNumber] = sublink;
								rowNumber ++; 
							}
						}
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check your network connection", "Network failure", JOptionPane.ERROR_MESSAGE);
		}
		
		// 查询http:http://forex.hexun.com/fxobservation/index.html页面 滚动新闻的  标签 以及class
		try {
			NodeFilter filter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("id", "zx1615"));
			Parser parser = new Parser();
			parser.setURL("http://forex.hexun.com/fxobservation/index.html");  
			NodeList list = parser.extractAllNodesThatMatch(filter);
			for (int i = 0; i < list.size(); i++) {
				Tag node = (Tag) list.elementAt(i);
				for (int j = 0; j < node.getChildren().size(); j++) {
					String textstr = node.getChildren().elementAt(j).toHtml().trim();
					if (textstr.length() > 0) {
						int linkbegin=0, linkend=0, titlebegin=0, titleend=0, timebegin=0, timeend=0;
						while(true){
							
							// achieve of the time     
							timebegin = textstr.indexOf("(",titleend);                  // get the beginning of the time
							if(timebegin < 0) break;
							timeend = textstr.indexOf(")",timebegin);                   // get the start position of the time
							String time = textstr.substring(timebegin+1, timeend);
							
							// achieve of the link
							linkbegin = textstr.indexOf("href=", timeend);			// 截取链接字符串起始位置
							//如果不存在 href了 也就结束了
							if(linkbegin < 0) break;
							linkend = textstr.indexOf(".html", linkbegin);				// 截取链接字符串结束位置
							String sublink = textstr.substring(linkbegin + 5,linkend + 5);
							
							// achieve of the title
							titlebegin = textstr.indexOf(">",linkend);    				// get the beginning position of the title
							titleend = textstr.indexOf("</a>",titlebegin);      		// get the end position of the title
							String title = (titlebegin + 1 < titleend) ? textstr.substring(titlebegin + 1,titleend) : "中国金融市场一周走势回顾";
							
							if (rowNumber < 4 * num) {
								rowData[rowNumber][0] = time;
								rowData[rowNumber][1] = "和讯网";
								rowData[rowNumber][2] = title;
								linkData[rowNumber] = sublink;
								rowNumber ++;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Check your network connection", "Network failure", JOptionPane.ERROR_MESSAGE);
		}
		
		// 查询http://www.cs.com.cn/sylm/jsxw/中证网 页面 滚动新闻的  标签 以及class
				try {
					NodeFilter filter = new AndFilter(new TagNameFilter("div"), new HasAttributeFilter("class", "content_left"));
					Parser parser = new Parser();
					parser.setURL("http://www.cs.com.cn/sylm/jsxw/");  
					NodeList list = parser.extractAllNodesThatMatch(filter);
					for (int i = 0; i < list.size(); i++) {
						Tag node = (Tag) list.elementAt(i);
						for (int j = 0; j < node.getChildren().size(); j++) {
							String textstr = node.getChildren().elementAt(j).toHtml().trim();
							if (textstr.length() > 0) {
								int linkbegin=0, linkend=0, titlebegin=0, titleend=0, timebegin=0, timeend=0;
								while(true){
									
									// achieve of the time                                        
									timebegin = textstr.indexOf("(",titleend);                  // get the beginning of the time
									timeend = textstr.indexOf(")",timebegin);                   // get the start position of the time
									String time = textstr.substring(timebegin+1, timeend);
									time = time.replace('-', '/');
									// achieve of the link
									linkbegin = textstr.indexOf("href=\"", timeend);			// 截取链接字符串起始位置
									//如果不存在 href了 也就结束了
									if(linkbegin < 0) break;
									linkend = textstr.indexOf(".html", linkbegin);				// 截取链接字符串结束位置
									String sublink = textstr.substring(linkbegin + 6,linkend+5);
									sublink = sublink.replace("../..", "http://www.cs.com.cn");
									// achieve of the title
									titlebegin = textstr.indexOf(">",linkend);    				// get the beginning position of the title
									titleend = textstr.indexOf("</a>",titlebegin);      		// get the end position of the title
									String title = textstr.substring(titlebegin + 1,titleend);
									
									if (rowNumber < 5 * num) {
										rowData[rowNumber][0] = time;
										rowData[rowNumber][1] = "中证网";
										rowData[rowNumber][2] = title;
										linkData[rowNumber] = sublink;
										rowNumber ++; 
									}
								}
							}
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Check your network connection", "Network failure", JOptionPane.ERROR_MESSAGE);
				}	
				
				
				// sort
				String [] midArrString;
		 		String  midString;
				for (int i = 0; i < rowNumber-1; i++) {
					for (int j= i+1; j< rowNumber; j++) {
						int t = rowData[i][0].compareTo(rowData[j][0]); 
						if (t < 0) {
							midArrString = rowData[i]; 
							rowData[i] = rowData[j];
							rowData[j] = midArrString;
							
							midString = linkData[i];
							linkData[i] = linkData[j];
							linkData[j] = midString;
						}
					}
				}
			 for (int i = 0; i < rowNumber;  i++) {
				 rowData_t[i] = rowData[i];
				 linkData_t[i] = linkData[i];
			 }
	}

}

