package nju.compass;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Recharge {

	/**
	 * Create the panel.
	 */
	public Recharge(JPanel panel_1) {
		
		JLabel lblName = new JLabel("±ÒÖÖ:");
		lblName.setBounds(54, 31, 64, 33);
		panel_1.add(lblName);
		
		JComboBox kind = new JComboBox(new Object[]{"RMB", "Dollar"});
		kind.setBounds(116, 31, 90, 33);
		panel_1.add(kind);
		
		JLabel lblNewLabel = new JLabel("½ð¶î:");
		lblNewLabel.setBounds(53, 100, 65, 33);
		panel_1.add(lblNewLabel);
		
		JTextField textField_1;
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 100, 90, 33);
		panel_1.add(textField_1);
	}

}
