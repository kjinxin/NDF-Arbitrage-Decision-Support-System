package nju.compass;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import database.Select;
import database.Update;

public class Setting {

	private ArrayList<String> selection;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_O;
	private JPasswordField textField_N;
	private JPasswordField textField_C;
	private JComboBox<String> kind;
	private JTextField Profit;
	private JTextField Profit_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox<String> kind_1 = new JComboBox<String>(new String[]{"RMB", "Dollar"});
	private JComboBox<String> RTD = new JComboBox<String>(new String[]{"RMB To Dollar", "Dollar To RMB"});
	/**
	 * Create the panel.
	 */
	public Setting(JPanel panel_1, final JFrame frame) {
		//从数据库中选出当前用户的信息
		String name = User.username;
		String[] elements = {name};
		String[] property = {"name"};
		String table = "member";
		String[] type = {"char"};
		String[] restraints = {"="};
		selection = new ArrayList<String>();
		Select.SelectElement(elements, property, table, type, restraints, selection);
		
		//个人基本信息设置
		JPanel PI = new JPanel();
		PI.setLayout(null);
		PI.setBounds(430, 20, 420, 290);
		PI.setBorder(new TitledBorder("Personal Information"));
		PI.setOpaque(false);
		panel_1.add(PI);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.PLAIN, 18));		
		lblName.setForeground(new Color(0x3, 0x3, 0x3));
		lblName.setBounds(120, 80, 60, 33);
		PI.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));		
		textField.setBounds(190, 80, 100, 33);
		textField.setColumns(10);
		PI.add(textField);
		textField.setText(selection.get(5).trim());
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(120, 140, 60, 33);
		PI.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));		
		textField_1.setColumns(10);
		textField_1.setBounds(190, 140, 100, 33);
		PI.add(textField_1);
		textField_1.setText(selection.get(2).trim());

		JButton btnCon = new JButton("Confirm");
		btnCon.setBounds(260, 230, 80, 25);
		PI.add(btnCon);
		
		btnCon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] new_elements = {textField.getText(), textField_1.getText()};
				String[] property1 = {"nickname", "email"};
				String[] type1 = {"char", "char"};
				String[] old_elements = {User.username};
				String[] property2 = {"name"};
				String[] type2 = {"char"};
				String[] restraints = {"="};
				String table = "member";
				Update.UpdateElement(new_elements, property1, type1, old_elements, property2, type2, restraints, table);
				JOptionPane.showMessageDialog(null, "Set successfully", "Message", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		//密码设置
		JPanel PA = new JPanel();
		PA.setLayout(null);
		PA.setOpaque(false);
		PA.setBounds(430, 310, 420, 324);
		PA.setBorder(new TitledBorder("Password"));
		panel_1.add(PA);
		
		JLabel lblPass = new JLabel("Old password:");
		lblPass.setFont(new Font("Arial", Font.PLAIN, 18));		
		lblPass.setBounds(55, 80, 160, 33);
		PA.add(lblPass);
		
		textField_O = new JPasswordField();
		textField_O.setBounds(220, 80, 100, 33);
		textField_O.setColumns(10);
		PA.add(textField_O);
		
		JLabel lblNewPass = new JLabel("New Password:");
		lblNewPass.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewPass.setBounds(55, 130, 160, 33);
		PA.add(lblNewPass);
		
		textField_N = new JPasswordField();
		textField_N.setColumns(10);
		textField_N.setBounds(220, 130, 100, 33);
		PA.add(textField_N);
		
		JLabel lblConPass = new JLabel("Confirm Password:");
		lblConPass.setFont(new Font("Arial", Font.PLAIN, 18));
		lblConPass.setBounds(55, 180, 160, 33);
		PA.add(lblConPass);
		
		textField_C = new JPasswordField();
		textField_C.setColumns(10);
		textField_C.setBounds(220, 180, 100, 33);
		PA.add(textField_C);
		
		JButton btnCon_1 = new JButton("Confirm");
		btnCon_1.setBounds(260, 270, 80, 25);
		PA.add(btnCon_1);
		
		btnCon_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textField_O.getText().equals("") || textField_N.getText().equals("")
						|| textField_C.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Input cannot be null!", "Input Wrong", JOptionPane.ERROR_MESSAGE);
				else if(!textField_O.getText().equals(selection.get(1).trim()))
					JOptionPane.showMessageDialog(null, "Invalid Password", "Invalid Permission", JOptionPane.ERROR_MESSAGE);
				else if(!textField_N.getText().equals(textField_C.getText()))
					JOptionPane.showMessageDialog(null, "Password is not accordance!", "Password Wrong", JOptionPane.ERROR_MESSAGE);
				else
				{
					//进行修改并重新登录
					String[] new_elements = {textField_N.getText()};
					String[] property1 = {"password"};
					String[] type1 = {"char"};
					String[] old_elements = {User.username};
					String[] property2 = {"name"};
					String[] type2 = {"char"};
					String[] restraints = {"="};
					String table = "member";
					Update.UpdateElement(new_elements, property1, type1, old_elements, property2, type2, restraints, table);
					JOptionPane.showMessageDialog(null, "Set successfully! Please Log in again", "Message", JOptionPane.PLAIN_MESSAGE);
					new Login();
					frame.dispose();
				}
			}
		});
		
		//提醒偏好设置
		JPanel FS = new JPanel();
		FS.setLayout(null);
		FS.setOpaque(false);
		FS.setBounds(10, 20, 420, 210);
		FS.setBorder(new TitledBorder("Preference"));
		panel_1.add(FS);
		
		JLabel lblNDF = new JLabel("NDF Time Limit:");
		lblNDF.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNDF.setBounds(50, 50, 150, 33);
		FS.add(lblNDF);
		
		kind = new JComboBox<String>();
		kind.addItem("");
		kind.addItem("1W");
		kind.addItem("1M");
		kind.addItem("3M");
		kind.addItem("6M");
		kind.addItem("9M");
		kind.addItem("1Y");
		kind.setBounds(250, 50, 60, 33);
		FS.add(kind);
		switch(selection.get(3).trim())
		{
			case "": kind.setSelectedIndex(0); break;
			case "1W": kind.setSelectedIndex(1); break;
			case "1M": kind.setSelectedIndex(2); break;
			case "3M": kind.setSelectedIndex(3); break;
			case "6M": kind.setSelectedIndex(4); break;
			case "9M": kind.setSelectedIndex(5); break;
			case "1Y": kind.setSelectedIndex(6); break;
			default: kind.setSelectedIndex(0); break;
		}
		
		JLabel lblP = new JLabel("Expected Profit Rate:");
		lblP.setFont(new Font("Arial", Font.PLAIN, 18));
		lblP.setBounds(50, 90, 200, 33);
		FS.add(lblP);
		
		Profit = new JTextField();
		Profit.setColumns(10);
		Profit.setBounds(250, 90, 60, 33);
		FS.add(Profit);
		Profit.setText(selection.get(4));
		
		JLabel suffix = new JLabel("‰");
		suffix.setFont(new Font("Arial", Font.PLAIN, 18));
		suffix.setBounds(310, 90, 30, 30);
		FS.add(suffix);
		
		JLabel lblP_1 = new JLabel("Loan rate:");
		lblP_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblP_1.setBounds(50, 130, 200, 33);
		FS.add(lblP_1);
		
		Profit_1 = new JTextField();
		Profit_1.setColumns(10);
		Profit_1.setBounds(250, 130, 60, 33);
		FS.add(Profit_1);
		Profit_1.setText(selection.get(4));
		
		JLabel suffix_1 = new JLabel("‰");
		suffix_1.setFont(new Font("Arial", Font.PLAIN, 18));
		suffix_1.setBounds(310, 130, 30, 30);
		FS.add(suffix_1);
		
		JButton btnCon_2 = new JButton("Confirm");
		btnCon_2.setBounds(300, 170, 80, 25);
		FS.add(btnCon_2);
		
		btnCon_2.addMouseListener(new MouseAdapter() {	//进行充值
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] index = {"", "1W", "1M", "3M", "6M", "9M", "1Y"};
				String[] new_elements = {index[kind.getSelectedIndex()], Double.parseDouble(Profit.getText()) / 1000 + ""};
				String[] property1 = {"time_limit", "rate"};
				String[] type1 = {"char", "double"};
				String[] old_elements = {User.username};
				String[] property2 = {"name"};
				String[] type2 = {"char"};
				String[] restraints = {"="};
				String table = "member";
				Update.UpdateElement(new_elements, property1, type1, old_elements, property2, type2, restraints, table);
				JOptionPane.showMessageDialog(null, "Set successfully", "Message", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JPanel RC = new JPanel();
		RC.setLayout(null);
		RC.setBounds(10, 230, 420, 200);
		RC.setBorder(new TitledBorder("Recharge"));
		panel_1.add(RC);
		
		JLabel lblC = new JLabel("Currency:");
		lblC.setFont(new Font("Arial", Font.PLAIN, 18));
		lblC.setBounds(50, 50, 90, 33);
		RC.add(lblC);
		
		kind_1.setBounds(150, 50, 90, 33);
		RC.add(kind_1);
		
		JLabel lblA = new JLabel("Amount:");
		lblA.setFont(new Font("Arial", Font.PLAIN, 18));
		lblA.setBounds(50, 110, 90, 33);
		RC.add(lblA);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(150, 110, 90, 33);
		RC.add(textField_2);
		
		JButton btnC = new JButton("Confirm");
		btnC.setBounds(300, 160, 80, 25);
		RC.add(btnC);
		
		btnC.addMouseListener(new MouseAdapter() {	//进行充值
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double amount = Double.parseDouble(textField_2.getText());
				if(Math.abs(amount) < 1e-4)
					JOptionPane.showMessageDialog(null, "Input cannot be null", "Invalid input", JOptionPane.ERROR_MESSAGE);
				else
				{
					String Name = User.username;
					String[] elements = {Name};
					String[] property = {"name"};
					String table = "account";
					String[] type = {"char"};
					String[] restraints = {"="};
					ArrayList<String> selection = new ArrayList<String>();
					Select.SelectElement(elements, property, table, type, restraints, selection);
					String[] property1 = new String[1];
					if(kind_1.getSelectedIndex() == 0)	//选择的是RMB充值
					{
						amount = amount + Double.parseDouble(selection.get(1));
						property1[0] = "RMB";
					}
					else if(kind_1.getSelectedIndex() == 1)	//选择的是dollar充值
					{
						amount = amount + Double.parseDouble(selection.get(2));
						property1[0] = "dollar";
					}
					String[] new_elements = {amount + ""};
					String[] type1 = {"double"};
					String[] elements2 = {Name};
					Update.UpdateElement(new_elements, property1, type1, elements2, property, type, restraints, table);
					JOptionPane.showMessageDialog(null, "Recharge successfully", "Message", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		JPanel TF = new JPanel();
		TF.setLayout(null);
		TF.setBounds(10, 430, 420, 204);
		TF.setBorder(new TitledBorder("Transform"));
		panel_1.add(TF);
		
		JLabel lblK = new JLabel("Kind:");
		lblK.setFont(new Font("Arial", Font.PLAIN, 18));
		lblK.setBounds(50, 50, 90, 33);
		TF.add(lblK);
		
		RTD.setBounds(150, 50, 100, 33);
		TF.add(RTD);
		
		JLabel lblA_1 = new JLabel("Amount:");
		lblA_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblA_1.setBounds(50, 110, 90, 33);
		TF.add(lblA_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(150, 110, 90, 33);
		TF.add(textField_3);
		
		JButton btnC_1 = new JButton("Confirm");
		btnC_1.setBounds(300, 160, 80, 25);
		TF.add(btnC_1);
		
		btnC_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textField_3.getText() == "")
					JOptionPane.showMessageDialog(null, "Input cannot be null", "Invalid input", JOptionPane.ERROR_MESSAGE);
				else
				{
					double change = Double.parseDouble(textField_3.getText());
					String Name = User.username;
					String[] elements = {Name};
					String[] property = {"name"};
					String table = "account";
					String[] type = {"char"};
					String[] restraints = {"="};
					ArrayList<String> selection = new ArrayList<String>();
					Select.SelectElement(elements, property, table, type, restraints, selection);
					ListData listData = new ListData();
					listData.run();
					String[] values = listData.getValues();
					double RMB = 0, dollar = 0;
					if(RTD.getSelectedIndex() == 0)		//人民币转美元
					{
						if(Double.parseDouble(selection.get(1)) < change)	//余额不足
							JOptionPane.showMessageDialog(null, "Insuffient Funds", "Invalid input", JOptionPane.ERROR_MESSAGE);
						else
						{
							double RMB_to_dollar = Double.parseDouble(values[0]);
							RMB = Double.parseDouble(selection.get(1)) - change;
							dollar = Double.parseDouble(selection.get(2)) + change * 100 / RMB_to_dollar; 
						}
					}
					else if(RTD.getSelectedIndex() == 1)	//美元转人民币
					{
						if(Double.parseDouble(selection.get(2)) < change)	//余额不足
							JOptionPane.showMessageDialog(null, "Insuffient Funds", "Invalid input", JOptionPane.ERROR_MESSAGE);
						else
						{
							double dollar_to_RMB = Double.parseDouble(values[2]);
							dollar = Double.parseDouble(selection.get(2)) - change;
							RMB = Double.parseDouble(selection.get(1)) + change * dollar_to_RMB / 100;
						}
					}
					String[] new_elements = {RMB + "", dollar + ""};
					String[] property1 = {"RMB", "dollar"};
					String[] type1 = {"double", "double"};
					String[] elements2 = {Name};
					Update.UpdateElement(new_elements, property1, type1, elements2, property, type, restraints, table);
					JOptionPane.showMessageDialog(null, "Transform successfully", "Message", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
