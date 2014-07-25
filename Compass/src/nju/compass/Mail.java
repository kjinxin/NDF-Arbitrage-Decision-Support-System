package nju.compass;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mail extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mail frame = new Mail();
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
	public Mail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheme = new JLabel("Theme:");
		lblTheme.setBounds(21, 21, 54, 15);
		contentPane.add(lblTheme);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(78, 19, 185, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(21, 48, 54, 15);
		contentPane.add(lblTime);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(78, 46, 185, 18);
		contentPane.add(textField_1);
		
		JLabel lblContent = new JLabel("Content:");
		lblContent.setBounds(21, 73, 54, 15);
		contentPane.add(lblContent);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(78, 74, 293, 120);
		contentPane.add(textArea);
		
		JButton btnDiagram = new JButton("Diagram");
		btnDiagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDiagram.setBounds(21, 218, 93, 23);
		contentPane.add(btnDiagram);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setBounds(168, 218, 93, 23);
		contentPane.add(btnOrder);
		
		JButton btnIgnore = new JButton("Ignore");
		btnIgnore.setBounds(310, 218, 93, 23);
		contentPane.add(btnIgnore);
	}
}
