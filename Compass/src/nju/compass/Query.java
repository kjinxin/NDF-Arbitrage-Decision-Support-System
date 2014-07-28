package nju.compass;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Query {

	/**
	 * Create the panel.
	 */
	public Query(JPanel panel_1) {
		JLabel lblName = new JLabel("±ÒÖÖ:");
		lblName.setBounds(54, 50, 64, 33);
		panel_1.add(lblName);
		
		JComboBox kind = new JComboBox(new Object[]{"RMB", "Dollar"});
		kind.setBounds(116, 50, 90, 33);
		panel_1.add(kind);
		
		JLabel lblNewLabel = new JLabel("Balance:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 100, 80, 50);
		panel_1.add(lblNewLabel);
		
		JTextField textField_1;
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(140, 100, 90, 33);
		panel_1.add(textField_1);
	}

}
