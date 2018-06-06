package app;

import java.io.File;

import java.nio.*;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import io.quicktype.Converter;
import io.quicktype.Weather;

import java.nio.file.Files;
import org.apache.commons.io.FileUtils;

public class DataTable extends JPanel{
	
	private JTable tabela;
	private DataParser dataParser;
		
	public DataTable() {
		
		dataParser = new DataParser("wroclaw");
		
		Object rowData[][] = { { dataParser.getCityName(), dataParser.getTemperature(), null},
		        		{ null, null, null} };
		Object columnNames[] = { "Dzisiaj", "Jutro", "Pojutrze"};
		
		TableModel model = new DefaultTableModel(rowData, columnNames);
		JTable tabela = new JTable(model);
		add(tabela);
		add(new JScrollPane(tabela));
	}
}
