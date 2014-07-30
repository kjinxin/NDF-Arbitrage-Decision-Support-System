package nju.compass;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;


public class Home extends JFrame {

	private JPanel panel;
	private JPanel panel_1; 
	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*JFrame.setDefaultLookAndFeelDecorated(true);
	      try {
	        UIManager.setLookAndFeel(new SubstanceMistAquaLookAndFeel()) ;
	      } catch (Exception e) {
	        System.out.println("Substance Raven Graphite failed to initialize");
	      }*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
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
		
		// 菜单栏
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(200, 200, 200, 200));
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Refresh_Main(1);
				//JOptionPane.showMessageDialog(null, "Success!");
			}
		});
		mnHome.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnHome);
		
		JMenu mnForwarded = new JMenu("Forwarded");
		mnForwarded.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Refresh_Main(2);
			}
		});
		mnForwarded.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnForwarded);
		
		
		JMenu mnBusiness = new JMenu("Business");
		mnBusiness.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Refresh_Main(3);
			}
		});
		mnBusiness.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnBusiness);
		
		JMenu mnNotification = new JMenu("Notification");
		mnNotification.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Refresh_Main(4);
			}
		});
		mnNotification.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnNotification);
		
		JMenu mnMyAccount = new JMenu("My Account");
		mnMyAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Refresh_Main(5);
			}
		});
		mnMyAccount.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnMyAccount.setBackground(new Color(240, 240, 240));
		menuBar.add(mnMyAccount);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Refresh_Main(6);
			}
		});
		mnHelp.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnHelp);
		//getContentPane().setLayout(null);
		
		//主panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1,1,1,1));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		
		// panel left 
		panel = new JPanel();
		panel.setBounds(0, 0, 217, 819);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		// panel right 
		panel_1 = new JPanel();
		panel_1.setBounds(217, 0, 1386, 819);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		Refresh_Main(1);
	}
	
	//根据菜单栏选项更新主页面
	public void Refresh_Main(int index)		//根据传递参数的不同主界面显示不同的东西
	{
		contentPane.removeAll();
		panel.removeAll();
		panel_1.removeAll();
		switch(index)
		{
			case 1:	Panel_Home(); break;
			case 2: Panel_Forwarded();  break;
			case 3: Panel_Business(); break;
			case 4: Panel_Notification(); break;
			case 5:break;
			case 6:break;
			default:break;
		}
		panel.repaint();
		panel_1.repaint();
		contentPane.add(panel);
		contentPane.add(panel_1);
		contentPane.repaint();
	}
	public void Panel_Home() {
		// set the background picture of the home page
		JLabel label_back = new JLabel();
		ImageIcon bg = new ImageIcon("image/pic_1.jpg");
		label_back.setIcon(bg);
		label_back.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
		contentPane.add(label_back, new Integer(Integer.MIN_VALUE));
		
	}
	
	public void Panel_Forwarded() {
		// the layer to show of forwarded
		// button of Cfxs
		JButton btnNdf = new JButton("NDF");
		btnNdf.setBounds(50, 290, 80, 40);
		btnNdf.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(btnNdf);
		new DrawNDF(panel_1);
		btnNdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		// button of Cfx
		JButton btnCfx = new JButton("CFX");
		btnCfx.setBounds(50, 20, 80, 40);
		btnCfx.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(btnCfx);
		btnCfx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
			
		// button of Cfxf
		JButton btnCfxf = new JButton("CFXF");
		btnCfxf.setBounds(50, 110, 80, 40);
		btnCfxf.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(btnCfxf);
		btnCfxf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		// button of Cfxs
		JButton btnCfxs = new JButton("CFXS");
		btnCfxs.setBounds(50, 200, 80, 40);
		btnCfxs.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(btnCfxs);
		btnCfxs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
	}
	
	
	public void Panel_Business(){
		final Object[] columnNames = {"number", "下单时间", "结算时间", "操作说明", "美元账户", "人名币账户", "收益率"};
		Object[][] rowData = {{"1", "2014/7/1", "2014/8/1", "DNF+NDF", "100", "200", "5%"},
				{"2", "2013/7/1", "2014/8/1", "NDF+存款", "10000", "100000", "10%"}};
		table = new JTable (rowData, columnNames);
		table.setOpaque(false);
		table.setPreferredScrollableViewportSize(new Dimension(1100, 680));//设置表格的大小 
		table.setRowHeight (30);//设置每行的高度为20 
		table.setRowMargin (2);//设置相邻两行单元格的距离 
		table.setRowSelectionAllowed (true);//设置可否被选择.默认为false  
		table.setSelectionForeground (Color.red);//设置所选择行的前景色 
		table.setGridColor (Color.black);//设置网格线的颜色 
//		table.selectAll ();//选择所有行 
		table.setShowGrid (false);//是否显示网格线 
		table.setBackground (Color.lightGray); 
		contentPane.setLayout(new GridLayout (0, 1));
		contentPane.setPreferredSize (new Dimension (1100, 680)); 
		contentPane.setBackground (Color.black); 
		JScrollPane pane1 = new JScrollPane (table);//JTable最好加在JScrollPane上
		contentPane.add(pane1);
		setContentPane(contentPane);
	}
	

	public void Panel_Notification(){
		final Object[] columnNames = {"number", "unread", "title", "time", "内容"};
		Object[][] rowData = {{"1", "read",  "有重大套利机会！", "2014/8/1", "nice!"},
							  {"2", "unread",  "NDF+存款", "2014/9/1", "So nice!"}};
		table = new JTable (rowData, columnNames);
		table.setOpaque(false);
		table.setPreferredScrollableViewportSize(new Dimension(1100, 680));//设置表格的大小 
		table.setRowHeight (30);//设置每行的高度为20 
		table.setRowMargin (2);//设置相邻两行单元格的距离 
		table.setRowSelectionAllowed (true);//设置可否被选择.默认为false  
		table.setSelectionForeground (Color.red);//设置所选择行的前景色 
		table.setGridColor (Color.black);//设置网格线的颜色 
//		table.selectAll ();//选择所有行 
//		table.setShowGrid (true);//是否显示网格线
		table.setShowHorizontalLines (false);//是否显示水平的网格线 
		table.setShowVerticalLines (false);//是否显示垂直的网格线
		table.setBackground (Color.lightGray); 
		contentPane.setLayout(new GridLayout (0, 1));
		contentPane.setPreferredSize (new Dimension (1100, 680)); 
		contentPane.setBackground (Color.black); 
		JScrollPane pane1 = new JScrollPane (table);//JTable最好加在JScrollPane上
		contentPane.add(pane1);
		setContentPane(contentPane);
	}
}
