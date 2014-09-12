package nju.compass;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import java.awt.Color;

import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import java.awt.Font;

import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.*;
import org.jfree.ui.*;

import java.awt.*;
import java.text.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.axis.NumberAxis;

import database.Select;

public class Chart {
	private ChartPanel chartPanel;
	
	private JFreeChart jfreechart;
	public static void main(String[] args) {
		ApplicationFrame frame= new ApplicationFrame("����ͼ");
		frame.pack();
	    RefineryUtilities.centerFrameOnScreen(frame);
	    frame.setBounds(0, 0, 1100, 680);
			
	    Chart chart = new Chart();
	    JPanel contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(1,1,1,1));
	    contentPane.setBounds(0, 0, 1100, 680);
	    contentPane.setLayout(null);
		contentPane.setOpaque(false);
		contentPane.add(chart.chartPanel);
		frame.setContentPane(chart.chartPanel);
		contentPane.repaint();
		RefineryUtilities.centerFrameOnScreen(frame);
	  	frame.setVisible(true);
	 }
	 
	 public ChartPanel getdfSWPanel() {
		 jfreechart = createChart("SW", "forward");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getdf1MPanel() {
		 jfreechart = createChart("1M", "forward");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getdf3MPanel() {
		 jfreechart = createChart("3M", "forward");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getdf6MPanel() {
		 jfreechart = createChart("6M", "forward");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getdf9MPanel() {
		 jfreechart = createChart("9M", "forward");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getdf1YPanel() {
		 jfreechart = createChart("1Y", "forward");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf1WPanel() {
		 jfreechart = createChart("1W", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf1MPanel() {
		 jfreechart = createChart("1M", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf2MPanel() {
		 jfreechart = createChart("2M", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf3MPanel() {
		 jfreechart = createChart("3M", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf6MPanel() {
		 jfreechart = createChart("6M", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf9MPanel() {
		 jfreechart = createChart("9M", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf1YPanel() {
		 jfreechart = createChart("1Y", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf2YPanel() {
		 jfreechart = createChart("2Y", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf3YPanel() {
		 jfreechart = createChart("3Y", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf4YPanel() {
		 jfreechart = createChart("4Y", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getndf5YPanel() {
		 jfreechart = createChart("5Y", "market");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
	 
	 public ChartPanel getDollarRMBPanel() {
		 jfreechart = createChart("5Y", "list");
		 chartPanel = new ChartPanel(jfreechart); 
		 chartPanel.setBorder(new EmptyBorder(1,1,1,1));
		 chartPanel.setBounds(300, 15, 782, 603);
		 chartPanel.setLayout(null);
		 chartPanel.setOpaque(false);
		 return chartPanel;
	 }
    // ����ͼ��������JFreeChart
    public static JFreeChart createChart(String kind, String table) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Graph", "Date",
                "Value", createDataset(kind, table), true, true, true);
        ImageIcon bg = new ImageIcon("image/pic_7.jpg");
        chart.setBackgroundImage(bg.getImage());
        // ������������ľ����Ⱦ(�����������)
        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

        // ����������
        chart.setTitle(new TextTitle("Graph", new Font("Arial", Font.ITALIC, 20)));
        chart.setAntiAlias(true);

        // �����ӱ���
        TextTitle subtitle;
        if(table.equals("forward"))
        {
        	subtitle = new TextTitle("BUY AND SELL RMB FORWARD", new Font("Arial", Font.BOLD, 12));
        	subtitle.setBackgroundPaint(Color.white);
        	chart.addSubtitle(subtitle);
        }
        else if(table.equals("market"))
        {
        	subtitle = new TextTitle("NDF Market", new Font("Arial", Font.BOLD, 12));
        	chart.addSubtitle(subtitle);
        }
        else if(table.equals("list")) {
        	subtitle = new TextTitle("Dollar-RMB Rate", new Font("Arial", Font.BOLD, 12));
        	chart.addSubtitle(subtitle);
        }

        XYPlot plot = (XYPlot) chart.getPlot();
        
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
                .getRenderer();

        // �������񱳾���ɫ
       // plot.setBackgroundPaint(new Color(245, 245, 245));
        // ��������������ɫ
        plot.setDomainGridlinePaint(Color.pink);
        // �������������ɫ
        plot.setRangeGridlinePaint(Color.pink);
        // ����������xy��ľ���
        plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
        plot.setNoDataMessage("NO DATA!");
        // ���������Ƿ���ʾ���ݵ�
        xylineandshaperenderer.setBaseShapesVisible(true);
        // ����������ʾ�������ݵ��ֵ
        XYItemRenderer xyitem = plot.getRenderer();
       // xyitem.setBaseItemLabelsVisible(true);
        xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
        xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
        plot.setRenderer(xyitem);

        // ����X��������ʾ�ĸ�ʽ
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(format);// ����x�����ݵ�λ�ԡ�����·�ʽ��ʾ

        ValueAxis valueAxis = plot.getDomainAxis();
        // ����x�����������
        valueAxis.setTickLabelFont(new Font("Arial", Font.ITALIC, 12));
        // ����X��ı�������
        valueAxis.setLabelFont(new Font("Arial", Font.ITALIC, 12));
        NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
        // ����y���ϵ�����
        numberAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 13));
        // ����y���ϵı�������
        numberAxis.setLabelFont(new Font("Arial", Font.PLAIN, 13));
        // ���õײ�������
        chart.getLegend().setItemFont(new Font("Arial", Font.PLAIN, 12));

        return chart;
    }

    // ��������
    public static TimeSeriesCollection createDataset(String kind, String table) {
    	ArrayList<String> selection = new ArrayList<String>();
    	String[] elements = {kind};
    	String[] property = {"type"};
    	String[] type = {"char"};
    	String[] restraints = {"="};

        // ʱ���������ݼ���
        TimeSeriesCollection lineDataset = new TimeSeriesCollection();

        if(table.equals("forward"))		//��ʱ��������
        {
        	int count = Select.SelectElement(elements, property, table, type, restraints, selection);
        	@SuppressWarnings("deprecation")
			TimeSeries timeSeries1 = new TimeSeries("buy", org.jfree.data.time.Day.class);
        	@SuppressWarnings("deprecation")
			TimeSeries timeSeries2 = new TimeSeries("sale", org.jfree.data.time.Day.class);
        	
        	for(int i = 0; i < selection.size(); i = i + count)
        	{
        		String[] date = selection.get(i + count - 1).split("-");
        		timeSeries1.add(new org.jfree.data.time.Day(Integer.parseInt(date[2]), Integer.parseInt(date[1]), 
        				Integer.parseInt(date[0])), Double.parseDouble(selection.get(i + 1)));
        		timeSeries2.add(new org.jfree.data.time.Day(Integer.parseInt(date[2]), Integer.parseInt(date[1]), 
        				Integer.parseInt(date[0])), Double.parseDouble(selection.get(i + 2)));
        	}
        	
        	lineDataset.addSeries(timeSeries1);
        	lineDataset.addSeries(timeSeries2);
        }
        else if(table.equals("market"))
        {
        	int count = Select.SelectElement(elements, property, table, type, restraints, selection);
        	@SuppressWarnings("deprecation")
			TimeSeries timeSeries = new TimeSeries("NDF price", Day.class);
        	
        	for(int i = 0; i < selection.size(); i = i + count)
        	{
        		String[] date = selection.get(i + count - 1).split("-");
        		timeSeries.add(new Day(Integer.parseInt(date[2]), Integer.parseInt(date[1]), 
        				Integer.parseInt(date[0])), Double.parseDouble(selection.get(i + 1)));
        	}
        	
        	lineDataset.addSeries(timeSeries);
        }
        else if (table.equals("list")) {
        	int count = Select.SelectAll(table, selection);
        	@SuppressWarnings("deprecation")
			TimeSeries timeSeries1 = new TimeSeries("buy", org.jfree.data.time.Day.class);
        	@SuppressWarnings("deprecation")
			TimeSeries timeSeries2 = new TimeSeries("sale", org.jfree.data.time.Day.class);
        	for(int i = 0; i < selection.size(); i = i + count)
        	{
        		String[] date = selection.get(i + count - 1).split("-");
        		timeSeries1.add(new org.jfree.data.time.Day(Integer.parseInt(date[2]), Integer.parseInt(date[1]), 
        				Integer.parseInt(date[0])), Double.parseDouble(selection.get(i + 1)));
        		timeSeries2.add(new org.jfree.data.time.Day(Integer.parseInt(date[2]), Integer.parseInt(date[1]), 
        				Integer.parseInt(date[0])), Double.parseDouble(selection.get(i + 3)));
        	}
        	
        	lineDataset.addSeries(timeSeries1);
        	lineDataset.addSeries(timeSeries2);
        }

        return lineDataset;
    }
}
