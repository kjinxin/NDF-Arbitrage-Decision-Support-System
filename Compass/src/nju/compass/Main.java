package nju.compass;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	JFrame frame;
	JPanel panelCenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.WHITE);
		frame.getContentPane().add(panelTop, BorderLayout.NORTH);

		Component verticalStrut = Box.createVerticalStrut(20);
		panelTop.add(verticalStrut);

		JButton btnFile = new JButton("File");
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelTop.add(btnFile);

		JButton btnProfit = new JButton("Profit");
		btnProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelCenter.getLayout()).show(panelCenter,
						"Profit");
			}
		});
		panelTop.add(btnProfit);

		JButton btnNdf = new JButton("NDF");
		btnNdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelCenter.getLayout()).show(panelCenter, "NDF");
			}
		});
		panelTop.add(btnNdf);

		JButton btnDf = new JButton("DF");
		btnDf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelCenter.getLayout()).show(panelCenter, "DF");
			}
		});
		panelTop.add(btnDf);

		JButton btnInterestRate = new JButton("Interest Rate");
		btnInterestRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelCenter.getLayout()).show(panelCenter,
						"Interest");
			}
		});
		panelTop.add(btnInterestRate);

		JButton btnMessages = new JButton("Messages");
		btnMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelCenter.getLayout()).show(panelCenter, "Msg");
			}
		});
		panelTop.add(btnMessages);

		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) panelCenter.getLayout())
						.show(panelCenter, "Help");
			}
		});
		panelTop.add(btnHelp);

		panelCenter = new JPanel();
		frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new CardLayout(0, 0));

		JPanel panelProfit = new JPanel();
		panelCenter.add(panelProfit, "Profit");

		JLabel lblProfit = new JLabel("Profit");
		panelProfit.add(lblProfit);

		JPanel panelNDF = new JPanel();
		panelCenter.add(panelNDF, "NDF");

		JLabel lblNewLabel = new JLabel("NDF");
		panelNDF.add(lblNewLabel);

		JPanel panelDF = new JPanel();
		panelCenter.add(panelDF, "DF");

		JPanel panelInterest = new JPanel();
		panelCenter.add(panelInterest, "Interest");

		JPanel panelMsg = new JPanel();
		panelCenter.add(panelMsg, "Msg");

		JPanel panelHelp = new JPanel();
		panelCenter.add(panelHelp, "Help");
	}
}
