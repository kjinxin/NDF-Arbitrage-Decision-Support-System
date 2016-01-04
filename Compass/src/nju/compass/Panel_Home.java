package nju.compass;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Panel_Home extends java.util.TimerTask {
	int row = 0;
	int column = 0;
	private JTable table;
	private JPanel contentPane;
	private GetNews news;
	private Object[] columnNames = {"Time", "Source", "Title"};
	private Object[][] rowData;
	private String [] linkData;
	public Panel_Home() {
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder("   "));
		contentPane.setBounds(-4, 24, 1106, 660);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		news = new GetNews(8);
		Timer timer = new Timer();
		timer.schedule(news, 0, 5 * 60 * 1000);
		rowData = news.getrowData();
		
		
		linkData = news.getlinkData();
		table = new JTable (rowData, columnNames){ 
			@Override
			public boolean isCellEditable( int row, int column ) { 
				return false; 
			} 
		};
		
		// ���ñ����
		int [] width = {200 , 300, 600};
		table.setColumnModel(getColumn(table, width));
		
		// listen to the double click
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {// ����������
					if (e.getClickCount() == 2) {
						int row = table.getSelectedRow();
							webBrowser browser = new webBrowser(linkData[row]);
							Thread myThread = new Thread(browser);
							myThread.start();
								//JOptionPane.showMessageDialog(null, "You select row " + (row + 1));
						}
					}
				}
			}); 
		
		
		// ���ñ������
		table.setPreferredScrollableViewportSize(new Dimension(1100, 680));//���ñ��Ĵ�С 
		table.setRowHeight (30);//����ÿ�еĸ߶�Ϊ30
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
		table.setBackground(Color.black);
		
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
			if (Panel_Home.this.row == row ) {
				this.setBackground(Style.focus);
			} else {
				if (row % 2 == 0) 
					this.setBackground(Style.darkGrey);
				else
					this.setBackground(Style.lightGrey);
			}
			// ��������
			this.setFont(new Font("΢���ź�", Font.BOLD, 17)); 
			
			// ����ÿһ�е���ɫ
			switch (column % 3) {
			case 0:
				this.setForeground(Style.green);
				break;
			case 1:
				this.setForeground(Style.red);
				break;
			case 2:
				this.setForeground(Style.white);
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
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		contentPane.repaint();
	}
}
