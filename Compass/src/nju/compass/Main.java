package nju.compass;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main {

	JFrame frame;
	private JLayeredPane layeredPane;

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

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mnFile.add(mntmSettings);

		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mnFile.add(mntmLogOut);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnProfit = new JMenu("Profit");
		menuBar.add(mnProfit);

		JMenu mnNdf = new JMenu("NDF");
		menuBar.add(mnNdf);

		JMenu mnDf = new JMenu("DF");
		menuBar.add(mnDf);

		JMenu mnInterestRate = new JMenu(" Interest Rate");
		menuBar.add(mnInterestRate);

		JMenu mnInfoCenter = new JMenu("Info Center");
		menuBar.add(mnInfoCenter);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, "name_3732245744102");
		layeredPane.setLayout(new CardLayout(0, 0));

		final JPanel panelProfit = new JPanel();
		layeredPane.add(panelProfit, "name_6109504846800");

		JLabel lblProfit = new JLabel("Profit");
		panelProfit.add(lblProfit);

		final JPanel panelNDF = new JPanel();
		layeredPane.add(panelNDF, "name_3817484737611");

		JLabel lblNdf = new JLabel("NDF");
		panelNDF.add(lblNdf);

		final JPanel panelDF = new JPanel();
		layeredPane.add(panelDF, "name_3817461063280");

		JLabel lblDf = new JLabel("DF");
		panelDF.add(lblDf);

		final JPanel panelIR = new JPanel();
		layeredPane.add(panelIR, "name_5947477216954");

		JLabel lblInterestRate = new JLabel("Interest Rate");
		panelIR.add(lblInterestRate);

		final JPanel panelInfo = new JPanel();
		layeredPane.add(panelInfo, "name_5958069219876");

		JLabel lblInfoCenter = new JLabel("Info Center");
		panelInfo.add(lblInfoCenter);

		mnNdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelProfit.setVisible(false);
				panelDF.setVisible(false);
				panelInfo.setVisible(false);
				panelIR.setVisible(false);
				panelNDF.setVisible(true);
			}
		});

		mnDf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelProfit.setVisible(false);
				panelNDF.setVisible(false);
				panelInfo.setVisible(false);
				panelIR.setVisible(false);
				panelDF.setVisible(true);
			}
		});

		mnProfit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelNDF.setVisible(false);
				panelInfo.setVisible(false);
				panelIR.setVisible(false);
				panelDF.setVisible(false);
				panelProfit.setVisible(true);
			}
		});

		mnInterestRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelNDF.setVisible(false);
				panelInfo.setVisible(false);
				panelDF.setVisible(false);
				panelProfit.setVisible(false);
				panelIR.setVisible(true);
			}
		});

		mnInfoCenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelNDF.setVisible(false);
				panelDF.setVisible(false);
				panelProfit.setVisible(false);
				panelIR.setVisible(false);
				panelInfo.setVisible(true);
			}
		});
	}
}
