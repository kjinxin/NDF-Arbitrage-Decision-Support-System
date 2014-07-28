package nju.compass;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Setting {

	/**
	 * Create the panel.
	 */
	public Setting(JPanel panel_1) {
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Arial", Font.PLAIN, 18));		
		lblName.setBounds(54, 31, 64, 33);
		panel_1.add(lblName);
		
		JTextField textField;
		textField = new JTextField();
		textField.setBounds(116, 31, 90, 33);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 100, 65, 33);
		panel_1.add(lblNewLabel);
		
		JTextField textField_1;
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 100, 90, 33);
		panel_1.add(textField_1);
	}

}
