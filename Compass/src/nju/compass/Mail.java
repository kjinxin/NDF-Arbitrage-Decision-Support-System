package nju.compass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import database.Delete;
import database.Select;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Mail extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private JTextField textField_2;
	
	/**
	 * Create the frame.
	 */
	public Mail(final Object [] dataSource, final GetNotificationData data, final int rowNum, final String profit, final String duration) {
		
		int begin = ((String) dataSource[4]).indexOf("操作说明： ", 0);                  
		int end = ((String) dataSource[4]).indexOf("收益率", begin);                  
		final String content = ((String) dataSource[4]).substring(begin+6, end);
		Image icon = Toolkit.getDefaultToolkit().getImage("image/image_2.jpg");   
		setIconImage(icon);
		setBounds(100, 100, 427, 284);
		// 设置居中显示
		int windowWidth = getWidth();                    //获得窗口宽
        int windowHeight = getHeight();                  //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();             //定义工具包
        Dimension screenSize = kit.getScreenSize();            //获取屏幕的尺寸
        int screenWidth = screenSize.width;                    //获取屏幕的宽
        int screenHeight = screenSize.height;                  //获取屏幕的高
        setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
        
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				  try{
				    g.drawImage(ImageIO.read(new    File("image/pic_7.jpg")),0
				                            ,0,this.getWidth(),this.getHeight(),this);
				   }catch(IOException e){}
				  }};
		contentPane.setBorder(new TitledBorder(""));
		contentPane.setBackground(Color.black);
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheme = new JLabel("Theme:");
		lblTheme.setBounds(20, 20, 60, 25);
		lblTheme.setFont(new Font("微软雅黑", Font.BOLD, 12));
		contentPane.add(lblTheme);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(80, 20, 180, 25);
		textField.setBackground(new Color(0x99, 0x99, 0x99));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblTime.setBounds(20, 50, 60, 25);
		contentPane.add(lblTime);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(80, 50, 180, 25);
		textField_1.setBackground(new Color(0x99, 0x99, 0x99));
		contentPane.add(textField_1);
		
		JLabel lblContent = new JLabel("Content:");
		lblContent.setFont(new Font("微软雅黑", Font.BOLD, 12));
		lblContent.setBounds(20, 80, 80, 25);
		contentPane.add(lblContent);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(80, 80, 310, 130);
		textArea.setBackground(new Color(0x99, 0x99, 0x99));
		contentPane.add(textArea);
		
		JLabel label = new JLabel("金额");
		label.setBounds(58, 210, 40, 20);
		label.setFont(new Font("微软雅黑", Font.BOLD, 11));
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(55, 230, 54, 25);
		textField_2.setBackground(new Color(0x99, 0x99, 0x99));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		

		final JComboBox<String> comboBox = new JComboBox<String>(new String[]{"￥", "$"});
		comboBox.setBounds(4, 230, 50, 25);
		contentPane.add(comboBox);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d = Integer.parseInt(textField_2.getText());
				String Name = User.username;
				String[] elements = {Name};
				String[] property = {"name"};
				String table = "account";
				String[] type = {"char"};
				String[] restraints = {"="};
				ArrayList<String> selection = new ArrayList<String>();
				Select.SelectElement(elements, property, table, type, restraints, selection);
				if(comboBox.getSelectedIndex() == 0)
				{
					double RMB = Double.parseDouble(selection.get(1));
					if(RMB < d)
						JOptionPane.showMessageDialog(null, "Insuffient Funds", "Invalid input", JOptionPane.ERROR_MESSAGE);
					else
					{
						new InsertDeal(duration, content, "0", d + "", profit);
						JOptionPane.showMessageDialog(null, "Order successfully", "Message", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else if(comboBox.getSelectedIndex() == 1)
				{
					double dollar = Double.parseDouble(selection.get(2));
					if(dollar < d)
						JOptionPane.showMessageDialog(null, "Insuffient Funds", "Invalid input", JOptionPane.ERROR_MESSAGE);
					else
					{
						new InsertDeal(duration, content, d + "", "0", profit);
						JOptionPane.showMessageDialog(null, "Order successfully", "Message", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnOrder.setBounds(146, 231, 95, 25);
		contentPane.add(btnOrder);
		
		JButton btnIgnore = new JButton("Delete");
		btnIgnore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> result = new ArrayList<String>();
				Select.SelectRow("noti_" + User.username, result, rowNum);
				String number = result.get(3).trim();
				String profit = result.get(4).trim();
				String[] elements = {number, profit};
				String[] property = {"number", "profit"}; 
				String table = "noti_" + User.username;
				String[] type = {"int", "double"}; 
				String[] restraints = {"=", "="};
				Delete.DeleteElement(elements, property, table, type, restraints);
				
				data.run(2);
				dispose();
			}
		});
		btnIgnore.setBounds(287, 231, 95, 25);
		contentPane.add(btnIgnore);
		
		textField.setText((String) dataSource[2]);
		textField_1.setText((String) dataSource[3]);
		textArea.setText((String) dataSource[4]);	
		
		setVisible(true);
	}
	
	public void run() {
		
	}
}