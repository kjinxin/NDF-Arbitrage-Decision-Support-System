package nju.compass;

import java.awt.*;
import java.util.Timer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;


public class Home extends JFrame {
	private JPanel contentPane;
	
	private Panel_Home panelhome;
	private Panel_File panelfile;
	private Panel_Forwarded panelforwarded;
	private Panel_Business panelbusiness;
	private Panel_Deal paneldeal;
	private Panel_Notification panelnotification;

	int screenWidth = 1100;
	int screenHeight = 680;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 System.setProperty( "Quaqua.tabLayoutPolicy","wrap");
		  try
		  {
		      UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");    
		  }
		  catch(Exception e)
		  {
		        
		  }
		  JFrame.setDefaultLookAndFeelDecorated(true); 
		  JDialog.setDefaultLookAndFeelDecorated(true);
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		Image icon = Toolkit.getDefaultToolkit().getImage("image/icon.png");   
		setIconImage(icon);
		setResizable(false);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 680);
		int windowWidth = getWidth();                    //获得窗口宽
        int windowHeight = getHeight();                  //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
        Dimension screenSize = kit.getScreenSize();            //获取屏幕的尺寸
        int screenWidth = screenSize.width;                    //获取屏幕的宽
        int screenHeight = screenSize.height;                  //获取屏幕的高
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
        
		setTitle("NDF 套利决策支持系统");
		//主panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.setBounds(0, 0, 1100, 680);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 菜单栏
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(200, 200, 200, 200));
		setJMenuBar(menuBar);
		
		// MyAccount
		final JFrame frame = this;
		JMenu mnFile = new JMenu("MyAccount");
		mnFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelfile = new Panel_File(frame);
				contentPane = panelfile.getPanel();
				setContentPane(contentPane);
				contentPane.repaint();
			}
		});
		mnFile.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnFile);
		
		// Forwarded
		panelforwarded = new Panel_Forwarded();
		JMenu mnForwarded = new JMenu("Forwarded");
		mnForwarded.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane = panelforwarded.getPanel();
				setContentPane(contentPane);
				contentPane.repaint();
			}
		});
		mnForwarded.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnForwarded);
		
		// Business
		panelbusiness = new Panel_Business();
		contentPane = panelbusiness.getPanel();
		setContentPane(contentPane);
		contentPane.repaint();
		JMenu mnBusiness = new JMenu("Business");
		mnBusiness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane = panelbusiness.getPanel();
				setContentPane(contentPane);
				contentPane.repaint();
			}
		});
		mnBusiness.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnBusiness);
		
		// Notification
		JMenu mnNotification = new JMenu("Notification");
		mnNotification.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelnotification = new Panel_Notification();
				panelnotification.run();
				contentPane = panelnotification.getPanel();
				setContentPane(contentPane);
				contentPane.repaint();
			}
		});
		mnNotification.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnNotification);
		
		// Deal 
		JMenu mnDeal = new JMenu("Deal");
		mnDeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paneldeal = new Panel_Deal();
				contentPane = paneldeal.getPanel();
				setContentPane(contentPane);
				contentPane.repaint();
			}
		});
		menuBar.add(mnDeal);
		mnDeal.setFont(new Font("Arial", Font.PLAIN, 15));
		
		// News
		panelhome = new Panel_Home();
		Timer timer = new Timer();
		timer.schedule(panelhome, 0, 5000);
		JMenu mnHome = new JMenu("News");
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane = panelhome.getPanel();
				setContentPane(contentPane);
				contentPane.repaint();
			}
		});
		mnHome.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnHome);
		
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Panel_Help();
			}
		});
		mnHelp.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnHelp);
		setVisible(true);
	}
	
	public void Panel_Help() {
		Runtime rn = Runtime.getRuntime();  
        try {  
            rn.exec("\"C:/Program Files/Windows Media Player/wmplayer.exe\"F:/1.mp4");  
        } catch (Exception e) {  
            System.out.println("Error exec!");  
        }
	}
}
