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
	static Point origin = new Point();  //ȫ�ֵ�λ�ñ��������ڱ�ʾ����ڴ����ϵ�λ��
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
            public void mousePressed(MouseEvent e) {  //���£�mousePressed ���ǵ����������걻����û��̧��
                    origin.x = e.getX();  //����갴�µ�ʱ���ô��ڵ�ǰ��λ��
                    origin.y = e.getY();
            }
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {  //�϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
              
                    Point p = frame.getLocation();  //������϶�ʱ��ȡ���ڵ�ǰλ��
                    //���ô��ڵ�λ��
                    //���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
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
		int windowWidth = frame.getWidth();                    //��ô��ڿ�
        int windowHeight = frame.getHeight();                  //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();             //���幤�߰�
        Dimension screenSize = kit.getScreenSize();            //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                    //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                  //��ȡ��Ļ�ĸ�
        frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(125, 186, 66, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setLabelFor(lblNewLabel);
		

		textField = new JTextField();
		textField.setBorder(BorderFactory.createLoweredBevelBorder());		// ��Ч��
		//textField.setBorder(BorderFactory.createRaisedBevelBorder());     // ͹Ч��
		textField.setBounds(218, 186, 80, 20);
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(125, 216, 83, 20);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBorder(BorderFactory.createRaisedBevelBorder());     // ͹Ч��
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(82, 256, 93, 23);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		
		btnRegister = new JButton("Register");
		btnRegister.setBorder(BorderFactory.createRaisedBevelBorder());     // ͹Ч��
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
		passwordField.setBorder(BorderFactory.createLoweredBevelBorder());		// ��Ч��
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
