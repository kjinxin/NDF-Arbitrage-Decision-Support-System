package nju.compass;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Panel_Forwarded {
	
	private JPanel contentPane;
    private JPanel panel;
    private JPanel panel_1;
    private Chart chart;
	public Panel_Forwarded() {
		
		//getLayeredPane().add(lblNewLabel, new Integer(Integer.MIN_VALUE));
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				  try{
				    g.drawImage(ImageIO.read(new    File("image/pic_7.jpg")),0
				                            ,0,this.getWidth(),this.getHeight(),this);
				   }catch(IOException e){}
				  }};
		contentPane.setBorder(new TitledBorder("   "));
		contentPane.setBounds(0, 26, 1099, 652);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		
		chart = new Chart();
		panel = chart.getdfSWPanel();
		TitledBorder tp = new TitledBorder("   ");
		panel.setBorder(tp);
		panel.setOpaque(false);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(20, 17, 270, 600);
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder("   "));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("NDF \u5E02\u573A\u884C\u60C5\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		label.setBounds(35, 90, 150, 30);
		contentPane.add(label);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1W", "1M", "2M", "3M", "6M", "9M", "1Y", "2Y", "3Y", "4Y", "5Y"}));
		comboBox.setFont(new Font("Arial", Font.BOLD, 15));
		comboBox.setBounds(165, 90, 70, 30);
		contentPane.add(comboBox);
		
		JButton btnConfirm = new JButton("confirm");
		btnConfirm.setFont(new Font("Arial", Font.BOLD, 15));
		btnConfirm.setBounds(93, 145, 94, 25);
		contentPane.add(btnConfirm);
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String item = (String) comboBox.getSelectedItem();
				contentPane.remove(panel);
				if (item == "1W")
					panel = chart.getndf1WPanel();
				else
					if (item == "1M")
						panel = chart.getndf1MPanel();
					else
						if (item == "2M")
							panel = chart.getndf2MPanel();
						else
							if (item == "3M")
								panel = chart.getndf3MPanel();
							else
								if (item == "6M")
									panel = chart.getndf6MPanel();
								else
									if (item == "9M")
										panel = chart.getndf9MPanel();
									else
										if (item == "1Y")
											panel = chart.getndf1YPanel();
										else
											if (item == "2Y")
												panel = chart.getndf2YPanel();
											else
												if (item == "3Y")
													panel = chart.getndf3YPanel();
												else
													if (item == "4Y")
														panel = chart.getndf4YPanel();
													else
														if (item == "5Y")
															panel = chart.getndf5YPanel();
				
				contentPane.add(panel);
				contentPane.repaint();
			}
		});
		
		JLabel lblDf = new JLabel("DF\u8FDC\u671F\u5916\u6C47\u62A5\u4EF7\uFF1A");
		lblDf.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 15));
		lblDf.setBounds(35, 270, 150, 30);
		contentPane.add(lblDf);
		
		final JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"SW", "1M", "3M", "6M", "9M", "1Y"}));
		comboBox_1.setFont(new Font("Arial", Font.BOLD, 15));
		comboBox_1.setBounds(165, 270, 70, 30);
		contentPane.add(comboBox_1);
		
		JButton btnConfirm_1 = new JButton("confirm");
		btnConfirm_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnConfirm_1.setBounds(93, 335, 94, 25);
		contentPane.add(btnConfirm_1);
		btnConfirm_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String item = (String) comboBox_1.getSelectedItem();
				contentPane.remove(panel);
				if (item == "SW")
					panel = chart.getdfSWPanel();
				else
					if (item == "1M")
						panel = chart.getdf1MPanel();
					else
						if (item == "3M")
							panel = chart.getdf3MPanel();
						else
							if (item == "6M")
								panel = chart.getdf6MPanel();
							else
								if (item == "9M")
									panel = chart.getdf9MPanel();
								else
									if (item == "1Y")
										panel = chart.getdf1YPanel();
				contentPane.add(panel);
				contentPane.repaint();
			}
		});
		
		JButton btnRmbdollarontime = new JButton("RMB-Dollar-Ontime");
		btnRmbdollarontime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panel);
				panel = chart.getDollarRMBPanel();
				contentPane.add(panel);
				contentPane.repaint();
			}
		});
		btnRmbdollarontime.setFont(new Font("Arial", Font.BOLD, 15));
		btnRmbdollarontime.setBounds(54, 465, 180, 34);
		contentPane.add(btnRmbdollarontime);
		contentPane.repaint();
	}
	
	// the layer to show of forwarded
	// button of Cfxs
	public JPanel getPanel() {
    	return contentPane;
    }
}