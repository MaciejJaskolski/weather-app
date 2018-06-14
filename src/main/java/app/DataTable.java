package app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import java.nio.*;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import io.quicktype.Converter;
import io.quicktype.Weather;

import java.nio.file.Files;
import org.apache.commons.io.FileUtils;


public class DataTable extends JPanel{
	
	private JTable tabela;
	//private DataParser dataParser;
	Image weatherImg;

	public DataTable(int day, DataParser dataParser) {
		
		//dataParser = new DataParser("Wroclaw");
		
		//weatherImg = dataParser.getIcon(day);
		
		System.out.println("Pogoda: dzien: " + day + "temp. : " + dataParser.getTemperature(day));
		
		//Object rowData[][] = { { dataParser.getCityName(), dataParser.getTemperature(0), dataParser.getTemperature(1)},
		//        		{ dataParser.getTemperature(2), dataParser.getTemperature(3), dataParser.getTemperature(4)} };
		Object rowData[][] = FillWithData(day, dataParser);
		Object columnNames[] = { ConvertDayIntToString(day) };
		
		TableModel model = new DefaultTableModel(rowData, columnNames);
		tabela = new JTable(model);
		tabela.setShowGrid(false);
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Properties.DARK_YELLOW), 
				BorderFactory.createEmptyBorder(0, 0, 0, 0));
		JTableHeader header = tabela.getTableHeader();
		header.setBackground(Properties.DARK_YELLOW);
		header.setBorder(border);

		header.setPreferredSize(new Dimension(150, 20));
		
		//tabela.setMaximumSize(new Dimension(150, 100));
		tabela.setPreferredSize(new Dimension(150, 100));
		
		Border panelBorder = BorderFactory.createEmptyBorder(0, 37, 75*day, 100);
		this.setBorder(panelBorder);
		
		add(tabela);
		
		add(new JScrollPane(tabela));
		tabela.setPreferredScrollableViewportSize(tabela.getPreferredSize());
		tabela.setFillsViewportHeight(true);
	}
	
	public Object[][] FillWithData(int day, DataParser dataParser) {
		Object[][] arr= {  { "Aktualna temp: " + dataParser.getTemperature(day) },
				{ "Min. temp.: " + dataParser.getMinTemperature(day) }, 
				{ "Max temp.: " + dataParser.getMaxTemperature(day) }, 
				{ "Ciśnienie: " + dataParser.getPressure(day) }
			 };
		return arr;
	}
	
	public void Update(int day, DataParser dataParser) {
		Object columnNames[] = { ConvertDayIntToString(day) };
		TableModel model = new DefaultTableModel(FillWithData(day, dataParser), columnNames);
		//tabela = new JTable(model);
		tabela.setModel(model);
	}
	
	private String ConvertDayIntToString(int day) {
		switch(day) {
		case 0:
			return "Dzisiaj";
		case 1:
			return "Jutro";
		case 2:
			return "Pojutrze";
		default:
			return "BLAD KONWERSJI DNIA (int) na string";
		}
	}
	
	/*@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(weatherImg, 250, 100, 50, 50, null); // see javadoc for more info on the parameters            
    }*/
}
