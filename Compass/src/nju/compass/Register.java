package nju.compass;

import java.awt.*;
import javax.swing.*;
import database.Create;
import database.Insert;
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
		// set the size of the window
		setBounds(100, 100, 270, 249);
		
		int windowWidth = getWidth();                    //获得窗口宽
        int windowHeight = getHeight();                  //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
        Dimension screenSize = kit.getScreenSize();            //获取屏幕的尺寸
        int screenWidth = screenSize.width;                    //获取屏幕的宽
        int screenHeight = screenSize.height;                  //获取屏幕的高
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
        
        contentPane = new JPanel();
        setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("Account");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUserName.setForeground(new Color(0x3, 0x3, 0x3));
		lblUserName.setBounds(10, 25, 130, 20);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(150, 28, 90, 25);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(0x3, 0x3, 0x3));
		lblNewLabel_2.setBounds(10, 60, 130, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblConfirmPassword.setForeground(new Color(0x3, 0x3, 0x3));
		lblConfirmPassword.setBounds(10, 95, 140, 20);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblMailBox = new JLabel("Mail Box");
		lblMailBox.setFont(new Font("Arial", Font.PLAIN, 16));
		lblConfirmPassword.setForeground(new Color(0x3, 0x3, 0x3));
		lblMailBox.setBounds(10, 130, 130, 20);
		contentPane.add(lblMailBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(149, 130, 90, 28);
		contentPane.add(textField_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(150, 60, 90, 28);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(149, 95, 90, 28);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(82, 178, 93, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textField.getText().equals("") || passwordField.getText().equals("") 
						|| passwordField_1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Input cannot be null!", "Input Wrong", JOptionPane.ERROR_MESSAGE);
				else if(!passwordField.getText().equals(passwordField_1.getText()))
					JOptionPane.showMessageDialog(null, "Password is not accordance!", "Password Wrong", JOptionPane.ERROR_MESSAGE);
				else
				{
					String Name = textField.getText();
					String Email = textField_3.getText();
					String Password = passwordField.getText();
					String[] values = {Name, Password, Email, "", "0", ""};
					Insert.InsertMember(values);
					String[] values2 = {Name, "0", "0"};
					Insert.InsertAccount(values2);
					Create.CreateTable(Name);
					dispose();
				}
			}
		});
	}
}
