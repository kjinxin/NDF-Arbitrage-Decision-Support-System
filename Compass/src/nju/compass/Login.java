package nju.compass;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import database.Select;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Login {

	private JFrame frame;
	private JButton btnNewButton;
	private JButton btnRegister;
	static Point origin = new Point();  //全局的位置变量，用于表示鼠标在窗口上的位置
	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.setProperty( "Quaqua.tabLayoutPolicy","wrap");
				try	{
				      UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");    
				}	catch(Exception e){}
				JFrame.setDefaultLookAndFeelDecorated(true); 
				JDialog.setDefaultLookAndFeelDecorated(true);
				try {
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Compass :: online service");
		Image icon = Toolkit.getDefaultToolkit().getImage("image/image_2.jpg");   
		frame.setIconImage(icon);
		frame.setResizable(false);
		JPanel contentPane = new JPanel(){
			public void paintComponent(Graphics g){
			  try{
			    g.drawImage(ImageIO.read(new    File("image/pic_11.jpg")),0
			                            ,0,this.getWidth(),this.getHeight(),this);
			   }catch(IOException e){}
			  }};
		frame.setContentPane(contentPane);
		frame.setBounds(100, 100, 450, 334);
		
		int windowWidth = frame.getWidth();                    //获得窗口宽
        int windowHeight = frame.getHeight();                  //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
        Dimension screenSize = kit.getScreenSize();            //获取屏幕的尺寸
        int screenWidth = screenSize.width;                    //获取屏幕的宽
        int screenHeight = screenSize.height;                  //获取屏幕的高
        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lbAccount = new JLabel("Account");
		lbAccount.setFont(new Font("Arial", Font.BOLD, 16));		
		lbAccount.setForeground(new Color(0xfa, 0xfa, 0xfa));
		lbAccount.setBounds(118, 190, 80, 20);
		
		textField = new JTextField();
		textField.setBounds(220, 186, 100, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 16));
		lblPassword.setForeground(new Color(0xfa, 0xfa, 0xfa));
		lblPassword.setBounds(118, 220, 100, 20);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 216, 100, 30);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(81, 256, 93, 23);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Name = textField.getText();
				@SuppressWarnings("deprecation")
				String Password = passwordField.getText();
				String[] elements = {Name};
				String[] property = {"name"};
				String table = "member";
				String[] type = {"char"};
				String[] restraints = {"="};
				ArrayList<String> selection = new ArrayList<String>();
				int count = Select.SelectElement(elements, property, table, type, restraints, selection);
				if(count <= 0)
					JOptionPane.showMessageDialog(null, "This account doesn't exist", "Invalid Permission", JOptionPane.ERROR_MESSAGE);
				else if(!selection.get(1).trim().equals(Password))
					JOptionPane.showMessageDialog(null, "Invalid Password", "Invalid Permission", JOptionPane.ERROR_MESSAGE);
				else
				{
					User.username = Name;
					new Home();
					frame.dispose();
				}
			}
		});
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Register frame = new Register();
							//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnRegister.setBounds(253, 256, 109, 23);
		
		
		JLabel helpLabel = new JLabel("CSH");
		helpLabel.setFont(new Font("Arial", Font.BOLD, 14));
		helpLabel.setForeground(new Color(0x48, 0x76, 0xff));
		helpLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		});
		helpLabel.setBounds(372, 275, 54, 15);
		
		contentPane.setLayout(null);
		contentPane.add(lbAccount);
		contentPane.add(btnNewButton);
		contentPane.add(btnRegister);
		contentPane.add(helpLabel);
		frame.setVisible(true);
	}
}
