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
	            // 注意，这个地方，那个true的参数，代表如果这个文件已经存在了，就把新的内容添加到该文件的最后
	            // 如果你想重新创建新文件，把true改成false就好了
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
