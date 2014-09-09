package nju.compass;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import database.Select;
import database.Update;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Panel_Notification {
	private JPanel contentPane;
	private JTable table;
	private Object[] columnNames;
	private Object[][] rowData;
	private GetNotificationData dataSource;
	int row = 0; 
	int column = 0; 
	public void run() {
		contentPane = new JPanel();
//		{
//			public void paintComponent(Graphics g){
//				  try{
//				    g.drawImage(ImageIO.read(new    File("image/image_2.jpg")),0
//				                            ,0,this.getWidth(),this.getHeight(),this);
//				   }catch(IOException e){}
//				  }};
		contentPane.setBorder(new TitledBorder("   "));
		contentPane.setBounds(-4, 24, 1106, 660);
		//contentPane.setBorder(new EmptyBorder(1,1,1,1));
		//contentPane.setBounds(0, 44, 1100, 680);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		
		dataSource = new GetNotificationData(contentPane);
		dataSource.run(1);
		//dataSource.run();
		
		columnNames = new Object []{"Number", "Read", "Title", "Time", "Content"};
		rowData = dataSource.getrowData();
		table = new JTable(rowData, columnNames){ 
			@Override
			public boolean isCellEditable( int row, int column ) { 
				return false; 
			}
		};
		
		int [] width = {100 , 100, 200, 170, 530};
		table.setColumnModel(getColumn(table, width));
		
		// listen to the double click
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {// ����������
					if (e.getClickCount() == 2) {
						int row = table.getSelectedRow();
						int rownumber = dataSource.getnumber();
						//�޸ı��Ϊ�Ѷ�
						ArrayList<String> result = new ArrayList<String>();
						Select.SelectRow("noti_" + User.username, result, rownumber - row - 1);
						String number = result.get(3).trim();
						String profit = result.get(4).trim();
						String[] new_elements = {"1"};
						String[] property1 = {"mark"};
						String[] type1 = {"bit"};
						String[] old_elements = {number, profit};
						String[] property2 = {"number", "profit"};
						String[] type2 = {"int", "double"};
						String[] restraints = {"=", "="};
						String table = "noti_" + User.username;
						Update.UpdateElement(new_elements, property1, type1, old_elements, property2, type2, restraints, table);
						new Mail(rowData[row], dataSource, rownumber - row - 1, result.get(4), result.get(6));
						rowData[row][1] = "read";
					}
				}
			}
		});
		
		// ���ñ������
				table.setPreferredScrollableViewportSize(new Dimension(1100, 680));//���ñ��Ĵ�С 
				table.setRowHeight (30);//����ÿ�еĸ߶�Ϊ30
				table.setRowMargin (1);//�����������е�Ԫ��ľ���
				table.setCellSelectionEnabled(false);
				table.setRowSelectionAllowed (true);//���ÿɷ�ѡ��.Ĭ��Ϊfalse  
					
				// ��������
				table.getTableHeader().setFont(new Font("΢���ź�", Font.BOLD, 19));   // ��ͷ
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
					if (Panel_Notification.this.row == row ) {
						this.setBackground(new Color(0x5c, 0xac, 0xee));
					} else {
						if (row % 2 == 0) 
							this.setBackground(new Color(0x33, 0x33, 0x33));
						else
							this.setBackground(new Color(0x40, 0x40, 0x40));
					}
					
					// ��������
					this.setFont(new Font("΢���ź�", Font.BOLD, 17)); 
					
					// ����ÿһ�е���ɫ
					switch (column % 3) {
					case 0:
						this.setForeground(new Color(0x6c, 0xc6, 0x44));
						break;
					case 1:
						this.setForeground(new Color(0xbd, 0x2c, 0x00));
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
