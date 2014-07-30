package nju.compass;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CSH extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		setUndecorated(true);
		int windowWidth = getWidth();                    //获得窗口宽
        int windowHeight = getHeight();                  //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
        Dimension screenSize = kit.getScreenSize();            //获取屏幕的尺寸
        int screenWidth = screenSize.width;                    //获取屏幕的宽
        int screenHeight = screenSize.height;                  //获取屏幕的高
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
        
        // set background picture
		JLabel lblNewLabel = new JLabel();
		ImageIcon bg = new ImageIcon("image/background.jpg");
		lblNewLabel.setIcon(bg);
		lblNewLabel.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		getLayeredPane().add(lblNewLabel, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel) getContentPane();
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(CSH.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		lblNewLabel_1.setBounds(285, 0, 15, 15);
		getContentPane().add(lblNewLabel_1);
		
		jp.setOpaque(false);
	}
}
