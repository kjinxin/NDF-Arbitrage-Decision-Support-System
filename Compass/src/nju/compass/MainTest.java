package nju.compass;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainTest extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	
	int screenWidth, screenHeight;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTest frame = new MainTest();
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
	public MainTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setTitle("MainPage");
		
		//创建菜单栏
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		//创建菜单
   		JMenu []jm = {new JMenu("文件"), new JMenu("外汇市场行情"), new JMenu("交易市场"), new JMenu("交易记录"), 
   				new JMenu("通知"), new JMenu("帮助"), new JMenu("账户")};
   		for(int i = 0; i < jm.length; i ++)
   		{
   			jm[i].setFont(new Font("黑体", Font.BOLD, 15));
   			jmb.add(jm[i]);
   		}
   		
   		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		screenWidth = screenSize.width; // 获取屏幕的宽
		screenHeight = screenSize.height; // 获取屏幕的高
		
		//主panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();	//左边栏
		panel_1 = new JPanel();	//右边主界面
		
		panel.setBounds(0, 0, screenWidth/6, screenHeight);
		panel.setLayout(null);
		
		panel_1.setBounds(screenWidth/6, 0, screenWidth/6*5, screenHeight);
		panel_1.setLayout(null);
		
		jm[0].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Refresh_Main(1);
			}
		});
		
		jm[6].addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Refresh_Main(6);
			}
		});
	}
	
	//根据菜单栏选项更新主页面
	public void Refresh_Main(int index)		//根据传递参数的不同主界面显示不同的东西
	{
		contentPane.removeAll();
		panel.removeAll();
		panel_1.removeAll();
		switch(index)
		{
			case 1: Panel_1(); break;
			case 2:break;
			case 3:break;
			case 4:break;
			case 5:break;
			case 6: Panel_6(); break;
			default:break;
		}
		panel.repaint();
		panel_1.repaint();
		contentPane.add(panel);
		contentPane.add(panel_1);
		contentPane.repaint();
	}
	
	//File所对应的主页面
	public void Panel_1()
	{
		JButton btnShezhi = new JButton("设置");
		btnShezhi.setBounds(52, 81, 116, 29);
		panel.add(btnShezhi);
		
		JButton btnZhuxiao = new JButton("注销");
		btnZhuxiao.setBounds(52, 120, 116, 29);
		panel.add(btnZhuxiao);
		
		JButton btnTuichu = new JButton("退出");
		btnTuichu.setBounds(52, 160, 116, 29);
		panel.add(btnTuichu);
		
		new Setting(panel_1);
	}
	
	//Account对应的页面
	public void Panel_6()
	{
		JButton btnShezhi = new JButton("充值");
		btnShezhi.setBounds(52, 90, 116, 29);
		panel.add(btnShezhi);
		
		JButton btnZhuxiao = new JButton("查询");
		btnZhuxiao.setBounds(52, 180, 116, 29);
		panel.add(btnZhuxiao);
		
		new Recharge(panel_1);
		
		btnShezhi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.remove(panel_1);
				panel_1.removeAll();
				new Recharge(panel_1);
				panel_1.repaint();
				contentPane.add(panel_1);
				contentPane.repaint();
			}
		});
		
		btnZhuxiao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.remove(panel_1);
				panel_1.removeAll();
				new Query(panel_1);
				panel_1.repaint();
				contentPane.add(panel_1);
				contentPane.repaint();
			}
		});
	}
	
}
