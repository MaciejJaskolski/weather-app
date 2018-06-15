package app;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class WeatherChart extends JPanel implements ChartChangeListener {

	private XYDataset dataset;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	private DataParser dataParser;
	
	
    public WeatherChart(DataParser dataParser) {
    	this.dataParser = dataParser;
        initUI(dataParser);
    }
    
    public void Update(DataParser dataParser) {
    	this.dataParser = dataParser;
    	chart.setTitle("Temperatura w " + dataParser.getCityName());
    }

    private void initUI(DataParser dataParser) {

        dataset = createDataset(dataParser);
        chart = createChart(dataset);
        chart.addChangeListener(this);
        //chart.setTitle("Temperatura w " + dataParser.getCityName());
        if(chartPanel == null)
        	chartPanel = new ChartPanel(chart);
        else 
        	chartPanel.setChart(chart);
        //chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 25, 15));
        //chartPanel.setBackground(Color.white);
        //this.setPreferredSize(new Dimension(800, 600));
        add(chartPanel);
    }

    private XYDataset createDataset(DataParser dataParser) {

    	Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        int intervalOffset = 3;
        int curH = calendar.get(calendar.HOUR_OF_DAY);
    	
    	TimeSeriesCollection dataset = new TimeSeriesCollection();
    	TimeSeries time = new TimeSeries("Temperatura");
    	
    	for(int i =0;i<8;i++) {
    		time.add(new Hour(curH + intervalOffset * i, new Day(date)), 
    				dataParser.getCurTemperatureInterval(i));
    	}
    	dataset.addSeries(time);
    	
    	return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Pogoda dzisiaj", 
                "Godzina", 
                "Temperatura (oC)", 
                dataset             
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
      
        chart.setTitle(new TextTitle("Temperatura w " + dataParser.getCityName(),
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;

    }

	public void chartChanged(ChartChangeEvent e) {
		System.out.println("I AM HERE");
		//dataset = createDataset(dataParser);
		//chart = createChart(dataset);
		initUI(dataParser);
	}
    
}