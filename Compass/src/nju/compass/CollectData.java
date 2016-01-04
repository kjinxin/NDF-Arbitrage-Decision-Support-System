package nju.compass;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Timer;
public class CollectData extends java.util.TimerTask{
	    public static void main(String[] args) {
	    	CollectData businessData = new CollectData();
	    	Timer timer = new Timer();
			timer.schedule(businessData, 0, 5 * 60 * 1000);
	    }

		@Override
		public void run() {
			File file = new File("F:\\data.txt");
			GetData1 data = new GetData1();
			data.run();
			System.out.println("jinxinalo");
			String [][] dd = (String[][]) data.getrowData();
	        try {
	            // ע�⣬����ط����Ǹ�true�Ĳ����������������ļ��Ѿ������ˣ��Ͱ��µ�������ӵ����ļ������
	            // ����������´������ļ�����true�ĳ�false�ͺ���
	            Writer writer = new OutputStreamWriter(new FileOutputStream(file, true), "GBK");
	            StringBuilder builder = new StringBuilder();
	            for (int i = 0; i < 100; i++) {
	                builder.append(dd[i][3]);
	                builder.append(" ");
	            }
	            builder.append("\n\n\n");
	            writer.write(builder.toString());
	            writer.close();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
}
