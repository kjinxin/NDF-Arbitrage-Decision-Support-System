package nju.compass;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Panel_Deal {
	private JPanel contentPane;
	private JTable table;
	private Object[] columnNames;
	private Object[][] rowData;
	private GetDealData dataSource;
	int row = 0; 
	int column = 0; 
	public Panel_Deal () {
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
			  try{
			    g.drawImage(ImageIO.read(new    File("image/pic_test2.jpg")),0
			                            ,0,this.getWidth(),this.getHeight(),this);
			   }catch(IOException e){}
			  }};
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.setBounds(0, 44, 1100, 680);
		//contentPane.setBorder(new TitledBorder("   "));
		//contentPane.setBounds(8, 40, 1100, 660);
		contentPane.setLayout(null);
		
		dataSource = new GetDealData();
		columnNames = new Object[] {"Number", "Order Time", "settlement Time", "Arbitrage instructions", "Amount������", "Amount��$��", "Yield Rate(��)"};
		rowData = dataSource.getrowData();
		table = new JTable (rowData, columnNames){ 
			@Override
			public boolean isCellEditable( int row, int column ) { 
				return false; 
			} 
		}; 
		
		// ���ñ����
		int [] width = {80, 140, 140, 320, 100, 100, 120};
		table.setColumnModel(getColumn(table, width));
		// double click to respond
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {// ����������
					if (e.getClickCount() == 2) {
						int row = table.getSelectedRow();
						System.out.println(row);
						JOptionPane.showMessageDialog(null, "You select row " + (row + 1));
					}
				}
			}
		});

		// ���ñ������
				table.setPreferredScrollableViewportSize(new Dimension(1100, 680));//���ñ��Ĵ�С 
				table.setRowHeight (30);//����ÿ�еĸ߶�Ϊ30
				table.setRowMargin (0);//�����������е�Ԫ��ľ���
				table.setCellSelectionEnabled(false);
				table.setRowSelectionAllowed (true);//���ÿɷ�ѡ��.Ĭ��Ϊfalse  
					
				// ��������
				table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 19));   // ��ͷ
				table.getTableHeader().setBackground(Color.black);
				table.getTableHeader().setForeground(Color.black);
				table.getTableHeader().setResizingAllowed(false);
				table.getTableHeader().setReorderingAllowed(false);

				// ����table��ͷ����
			    DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
			    thr.setHorizontalAlignment(JLabel.CENTER);
			    table.getTableHeader().setDefaultRenderer(thr);
			    
			    // ����table���ݾ���
			    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			    tcr.setHorizontalAlignment(JLabel.CENTER);
			    table.setDefaultRenderer(Object.class, tcr);
				
				// ���ñ�����ǰ��ɫ�Լ�������
			    table.setShowGrid(false);
				table.setBackground(Style.darkGrey);
				
				// �������ƶ�����, �Լ���������Ⱦ��
				CellRendererAndMouseListener rendererAndListener = new CellRendererAndMouseListener();
				table.addMouseMotionListener((MouseMotionListener) rendererAndListener);
				table.setDefaultRenderer(Object.class, rendererAndListener);
				
				//��ӱ��JScrollPane
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.getViewport().setOpaque(false);
				scrollPane.setViewportView(table); 
				scrollPane.setOpaque(false);
				scrollPane.setColumnHeaderView(table.getTableHeader());
				contentPane.setLayout(new GridLayout (0, 1));
				contentPane.add(scrollPane);	
				contentPane.setOpaque(false);
			}
			public JPanel getPanel() {
				return contentPane;
			}
			
			public static TableColumnModel getColumn(JTable table, int[] width) {  
			    TableColumnModel columns = table.getColumnModel();  
			    for (int i = 0; i < width.length; i++) {  
			        javax.swing.table.TableColumn column = columns.getColumn(i);  
			        column.setPreferredWidth(width[i]);  
			    }  
			    return columns;  
			}
			
			public class CellRendererAndMouseListener extends JLabel implements TableCellRenderer, MouseMotionListener {
				 
				public CellRendererAndMouseListener() {
					setOpaque(true);
				}
				
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
					if (Panel_Deal.this.row == row ) {
						this.setBackground(Style.focus);
					} else {
						if (row % 2 == 0) 
							this.setBackground(Style.darkGrey);
						else
							this.setBackground(Style.lightGrey);
					}
					
					// ��������
					this.setFont(new Font("Arial", Font.BOLD, 17)); 
					
					// ����ÿһ�е���ɫ
					switch (column % 3) {
					case 0:
						this.setForeground(Style.red);
						break;
					case 1:
						this.setForeground(Style.green);
						break;
					case 2:
						this.setForeground(Color.white);
						break;
					}
				    this.setText((value == null) ? "" : value.toString());
				    this.setHorizontalAlignment(SwingConstants.CENTER);
					return this;
				}
				public void mouseMoved(MouseEvent e) {
					JTable table = (JTable) e.getSource();
					row = table.rowAtPoint(e.getPoint());
					column = table.columnAtPoint(e.getPoint());
					table.repaint();
				}
		 
				public void mouseDragged(MouseEvent e) {
					
				}
			}
}
