package nju.compass;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import database.Select;
import database.Update;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Panel_Business {
	private JPanel contentPane;
	private JTable table;

	int row = 0;
	int column = 0;
	public Panel_Business() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1,1,1,1));
		contentPane.setBounds(0, 26, 1100, 680);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		GetData businessData = new GetData();
		
		Timer timer = new Timer();
		timer.schedule(businessData, 0, 5 * 60 * 1000);
		
		final Object[] columnNames = {"Code", "Principal", "Trade deadline", "Yield rate（‰）"};
		final Object[][] rowData = businessData.getrowData();
		final String[] content = businessData.getcontent();
		final String[] addcontent = businessData.getaddcontent();
		table = new JTable (rowData, columnNames){ 
			@Override
			public boolean isCellEditable( int row, int column ) { 
				return false; 
			} 
		}; 
		
		
		// double click to respond
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {// 单击鼠标左键
					if (e.getClickCount() == 2) {
						int row = table.getSelectedRow();
						new ShowBusiness(content[row], rowData[row], addcontent[row]);
					}
				}
			}
		});
		
		
		// 设置表格属性
		table.setPreferredScrollableViewportSize(new Dimension(1100, 680));//设置表格的大小 
		table.setRowHeight (30);//设置每行的高度为30
		table.setRowMargin (1);//设置相邻两行单元格的距离
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed (true);//设置可否被选择.默认为false  
			
		// 设置字体
		table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 19));   // 表头
		table.getTableHeader().setBackground(Color.black);
		table.getTableHeader().setForeground(Color.black);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);

		// 设置table表头居中
	    DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
	    thr.setHorizontalAlignment(JLabel.CENTER);
	    table.getTableHeader().setDefaultRenderer(thr);
	    
	    // 设置table内容居中
	    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	    tcr.setHorizontalAlignment(JLabel.CENTER);
	    table.setDefaultRenderer(Object.class, tcr);
		
		// 设置背景和前景色以及网格线
	    table.setShowGrid(false);
		table.setBackground(Color.black);
		
		// 添加鼠标移动监听, 以及设置列渲染器
		CellRendererAndMouseListener rendererAndListener = new CellRendererAndMouseListener();
		table.addMouseMotionListener((MouseMotionListener) rendererAndListener);
		table.setDefaultRenderer(Object.class, rendererAndListener);
		
		//添加表格到JScrollPane
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
		
		public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (Panel_Business.this.row == row ) {
				this.setBackground(new Color(0x5c, 0xac, 0xee));
			} else {
				if (row % 2 == 0) 
					this.setBackground(new Color(0x33, 0x33, 0x33));
				else
					this.setBackground(new Color(0x40, 0x40, 0x40));
			}
			// 设置字体
			this.setFont(new Font("微软雅黑", Font.BOLD, 17)); 
			switch (column % 4) {
			case 0:
				this.setForeground(Color.white);
				break;
			case 1:
				this.setForeground(Color.yellow);
				break;
			case 2:
				this.setForeground(Color.blue);
				break;
			case 3: 
				if (value != null)
				if (((String) value).charAt(0) == '-')
					this.setForeground(Color.green);
				else this.setForeground(Color.red);
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
