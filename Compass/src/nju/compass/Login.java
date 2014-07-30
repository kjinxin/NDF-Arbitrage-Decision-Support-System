package nju.compass;

import java.awt.*;

import javax.swing.*;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel;

import java.awt.event.*;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblPassword;
	private JButton btnNewButton;
	private JButton btnRegister;
	private JPasswordField passwordField;
	private JLabel lblJinxin;
	static Point origin = new Point();  //全局的位置变量，用于表示鼠标在窗口上的位置
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					//window.frame.setVisible(true);
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
		frame.setUndecorated(true);
		// move the window
		frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {  //按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
                    origin.x = e.getX();  //当鼠标按下的时候获得窗口当前的位置
                    origin.y = e.getY();
            }
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {  //拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
              
                    Point p = frame.getLocation();  //当鼠标拖动时获取窗口当前位置
                    //设置窗口的位置
                    //窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
                    frame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
            }
		});
		
		
		// let the background to be a label
		ImageIcon bg = new ImageIcon("image/background.jpg");
		JLabel label = new JLabel(bg);
		// let the size of the label to be the size of the background pic
		label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		// add the pic to the second layer of frame
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel) frame.getContentPane();
		jp.setOpaque(false);
		
		
		frame.setBounds(100, 100, 450, 300);
		int windowWidth = frame.getWidth();                    //获得窗口宽
        int windowHeight = frame.getHeight();                  //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
        Dimension screenSize = kit.getScreenSize();            //获取屏幕的尺寸
        int screenWidth = screenSize.width;                    //获取屏幕的宽
        int screenHeight = screenSize.height;                  //获取屏幕的高
        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(125, 186, 66, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setLabelFor(lblNewLabel);
		

		textField = new JTextField();
		textField.setBorder(BorderFactory.createLoweredBevelBorder());		// 凹效果
		//textField.setBorder(BorderFactory.createRaisedBevelBorder());     // 凸效果
		textField.setBounds(218, 186, 80, 20);
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(125, 216, 83, 20);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBorder(BorderFactory.createRaisedBevelBorder());     // 凸效果
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(82, 256, 93, 23);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		
		btnRegister = new JButton("Register");
		btnRegister.setBorder(BorderFactory.createRaisedBevelBorder());     // 凸效果
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
		
		btnRegister.setBounds(241, 256, 109, 23);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(lblPassword);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(BorderFactory.createLoweredBevelBorder());		// 凹效果
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(218, 216, 80, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("<html><u>CSH</u><html>");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(372, 275, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblJinxin = new JLabel("");
		lblJinxin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblJinxin.setIcon(new ImageIcon(Login.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		lblJinxin.setBackground(Color.DARK_GRAY);
		lblJinxin.setBounds(435, 0, 15, 15);
		frame.getContentPane().add(lblJinxin);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, textField, lblPassword, btnNewButton, btnRegister}));
		frame.setVisible(true);
	}
}
