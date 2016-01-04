package nju.compass;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.IOException;

public class CSH extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CSH frame = new CSH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CSH() {
		setBounds(100, 100, 300, 200);
		setResizable(false);
		int windowWidth = getWidth();                    //��ô��ڿ�
        int windowHeight = getHeight();                  //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();             //���幤�߰�
        Dimension screenSize = kit.getScreenSize();            //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                    //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                  //��ȡ��Ļ�ĸ�
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
        
        // set background picture
		JLabel contentPane = new JLabel(){
			public void paintComponent(Graphics g){
				  try{
				    g.drawImage(ImageIO.read(new    File("image/CSH.jpg")),0
				                            ,0,this.getWidth(),this.getHeight(),this);
				   }catch(IOException e){}
				  }};
		setContentPane(contentPane);
	}
}
