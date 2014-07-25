package nju.compass;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		// set the size of the window
		setBounds(100, 100, 240, 260);
		
		int windowWidth = getWidth();                    //获得窗口宽
        int windowHeight = getHeight();                  //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
        Dimension screenSize = kit.getScreenSize();            //获取屏幕的尺寸
        int screenWidth = screenSize.width;                    //获取屏幕的宽
        int screenHeight = screenSize.height;                  //获取屏幕的高
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
        
        
		// set background picture
		JLabel lblNewLabel = new JLabel();
		ImageIcon bg = new ImageIcon("E:\\myjava\\background.jpg");
		lblNewLabel.setIcon(bg);
		lblNewLabel.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		getLayeredPane().add(lblNewLabel, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel) getContentPane();
		getContentPane().setLayout(null);
		
		
		
		JLabel lblUserName = new JLabel("Account");
		lblUserName.setFont(new Font("Arial", Font.BOLD, 15));
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(37, 45, 67, 20);
		getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 15));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(140, 45, 80, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(37, 75, 80, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		label.setIcon(new ImageIcon(Register.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		label.setBounds(225, 0, 15, 15);
		getContentPane().add(label);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setBounds(0, 105, 139, 20);
		getContentPane().add(lblConfirmPassword);
		
		JLabel lblMailBox = new JLabel("Mail Box");
		lblMailBox.setFont(new Font("Arial", Font.BOLD, 15));
		lblMailBox.setHorizontalAlignment(SwingConstants.LEFT);
		lblMailBox.setForeground(Color.WHITE);
		lblMailBox.setBounds(37, 135, 88, 20);
		getContentPane().add(lblMailBox);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 15));
		textField_3.setForeground(Color.WHITE);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.DARK_GRAY);
		textField_3.setBounds(140, 135, 80, 20);
		getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(74, 192, 105, 23);
		getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Arial", Font.BOLD, 15));
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(140, 75, 80, 20);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(Color.WHITE);
		passwordField_1.setFont(new Font("Arial", Font.BOLD, 15));
		passwordField_1.setBackground(Color.DARK_GRAY);
		passwordField_1.setBounds(140, 105, 80, 20);
		getContentPane().add(passwordField_1);
		jp.setOpaque(false);
	}
}
