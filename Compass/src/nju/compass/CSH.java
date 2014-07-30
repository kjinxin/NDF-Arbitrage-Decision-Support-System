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
		int windowWidth = getWidth();                    //��ô��ڿ�
        int windowHeight = getHeight();                  //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();             //���幤�߰�
        Dimension screenSize = kit.getScreenSize();            //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                    //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                  //��ȡ��Ļ�ĸ�
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
        
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
