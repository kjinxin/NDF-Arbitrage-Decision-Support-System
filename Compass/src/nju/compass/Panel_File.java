package nju.compass;

import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import database.Select;

public class Panel_File {
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	public Panel_File(final JFrame frame) {
		contentPane = new JPanel() {
			public void paintComponent(Graphics g){
				  try{
				    g.drawImage(ImageIO.read(new    File("image/pic_9.png")),0
				                            ,0,this.getWidth(),this.getHeight(),this);
				   }catch(IOException e){}
				  }};
		contentPane.setBounds(0, 26, 1099, 652);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		contentPane.setBorder(new TitledBorder("   "));
		panel = new JPanel();
		panel.setBounds(15, 20, 220, 614);
		contentPane.add(panel);
		panel.setOpaque(false);
		//panel.setBackground(new Color(255, 255, 255, 100));
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("   "));
		
		panel_1 = new JPanel();
		panel_1.setBounds(235, 0, 860, 650);
		//panel_1.setOpaque(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		// 用户信息显示
		String RMB, dollar;
		String Name = User.username;
		String[] elements = {Name};
		String[] property = {"name"};
		String table = "account";
		String[] type = {"char"};
		String[] restraints = {"="};
		ArrayList<String> selection = new ArrayList<String>();
		Select.SelectElement(elements, property, table, type, restraints, selection);
		DecimalFormat df = new DecimalFormat("#.00");
		RMB = df.format(Double.parseDouble(selection.get(1)));
		dollar = df.format(Double.parseDouble(selection.get(2)));
		
		String table2 = "member";
		String[] elements2 = {Name};
		ArrayList<String> selection2 = new ArrayList<String>();
		Select.SelectElement(elements2, property, table2, type, restraints, selection2);
		//进行用户账户信息的显示
		if(!selection2.get(5).trim().equals(""))
			Name = selection2.get(5).trim();
		
		JTextArea acc = new JTextArea();
		acc.setFont(new Font("Arial", Font.PLAIN, 18));
		acc.setEditable(false);
		acc.setText("Hi, " + Name + "\r\n\r\nRMB Balance :\n\r" + RMB 
		+ "\r\n\r\nDollar Balance: \n\r" + dollar);
		acc.setBounds(12, 100, 174, 231);
		acc.setBorder(new LineBorder(Color.DARK_GRAY, 4));
		panel.add(acc);
		
		JButton btnZhuxiao = new JButton("Log out");
		btnZhuxiao.setBounds(30, 464, 116, 29);
		panel.add(btnZhuxiao);
		
		JButton btnTuichu = new JButton("Exit");
		btnTuichu.setBounds(30, 531, 116, 29);
		panel.add(btnTuichu);
		
		btnZhuxiao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int temp = JOptionPane.showConfirmDialog(null, "Are you sure to log out?", "Log out", JOptionPane.YES_NO_OPTION);
				if(temp == 0)
				{
					new Login();
					frame.dispose();
				}
			}
		});
		
		btnTuichu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int temp = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Exit", JOptionPane.YES_NO_OPTION);
				if(temp == 0)
					frame.dispose();
			}
		});
		new Setting(panel_1, frame);
	}
	
	public JPanel getPanel() {
		return contentPane;
	}
	
}
