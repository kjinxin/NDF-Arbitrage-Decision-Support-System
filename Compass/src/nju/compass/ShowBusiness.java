package nju.compass;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import database.Select;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class ShowBusiness extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JTextField textField_2;
	private JComboBox<String> comboBox;

	/**
	 * Create the frame.
	 */
	public ShowBusiness(final String content, final Object [] dataSource, String addcontent) {
		Image icon = Toolkit.getDefaultToolkit().getImage("image/icon.png");   
		setIconImage(icon);
		setBounds(100, 100, 420, 348);
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
		contentPane.setBorder(new TitledBorder("  "));
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("PRODUCT INFORMATION"));
		panel.setBounds(36, 3, 346, 271);
		panel.setOpaque(false);
		panel.setLayout(null);
		contentPane.add(panel);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(10, 28, 326, 233);
		textArea.setBackground(new Color(0x99, 0x99, 0x99));
		panel.add(textArea);
		
		JLabel label = new JLabel("Amount");
		label.setBounds(128, 265, 60, 25);
		label.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 286, 80, 30);
		textField_2.setBackground(new Color(0x99, 0x99, 0x99));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		comboBox = new JComboBox<String>(new String[]{"￥", "$"});
		comboBox.setBounds(60, 286, 60, 30);
		contentPane.add(comboBox);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double d = Double.parseDouble(textField_2.getText());
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
						new InsertDeal((String)dataSource[2], content, "0", d + "", (String)dataSource[3]);
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
						new InsertDeal((String)dataSource[2], content, d + "", "0", (String)dataSource[3]);
						JOptionPane.showMessageDialog(null, "Order successfully", "Message", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnOrder.setBounds(225, 286, 100, 30);
		contentPane.add(btnOrder);
		textArea.setText("Code： " + dataSource[0] + "\nPrincipal： " + dataSource[1] + "\nArbitrage Instructions： " 
				+ content + "\nYield Rate： " + dataSource[3] + " ‰\nNote： " + addcontent + "\nRisk Assessment：No risk");	
		
		setVisible(true);
		
	}

}
