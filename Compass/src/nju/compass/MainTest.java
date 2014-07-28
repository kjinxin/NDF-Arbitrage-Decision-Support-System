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
		
		//�����˵���
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		//�����˵�
   		JMenu []jm = {new JMenu("�ļ�"), new JMenu("����г�����"), new JMenu("�����г�"), new JMenu("���׼�¼"), 
   				new JMenu("֪ͨ"), new JMenu("����"), new JMenu("�˻�")};
   		for(int i = 0; i < jm.length; i ++)
   		{
   			jm[i].setFont(new Font("����", Font.BOLD, 15));
   			jmb.add(jm[i]);
   		}
   		
   		Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
		Dimension screenSize = kit.getScreenSize(); // ��ȡ��Ļ�ĳߴ�
		screenWidth = screenSize.width; // ��ȡ��Ļ�Ŀ�
		screenHeight = screenSize.height; // ��ȡ��Ļ�ĸ�
		
		//��panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();	//�����
		panel_1 = new JPanel();	//�ұ�������
		
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
	
	//���ݲ˵���ѡ�������ҳ��
	public void Refresh_Main(int index)		//���ݴ��ݲ����Ĳ�ͬ��������ʾ��ͬ�Ķ���
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
	
	//File����Ӧ����ҳ��
	public void Panel_1()
	{
		JButton btnShezhi = new JButton("����");
		btnShezhi.setBounds(52, 81, 116, 29);
		panel.add(btnShezhi);
		
		JButton btnZhuxiao = new JButton("ע��");
		btnZhuxiao.setBounds(52, 120, 116, 29);
		panel.add(btnZhuxiao);
		
		JButton btnTuichu = new JButton("�˳�");
		btnTuichu.setBounds(52, 160, 116, 29);
		panel.add(btnTuichu);
		
		new Setting(panel_1);
	}
	
	//Account��Ӧ��ҳ��
	public void Panel_6()
	{
		JButton btnShezhi = new JButton("��ֵ");
		btnShezhi.setBounds(52, 90, 116, 29);
		panel.add(btnShezhi);
		
		JButton btnZhuxiao = new JButton("��ѯ");
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
