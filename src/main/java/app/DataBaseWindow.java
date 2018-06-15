package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Delayed;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class DataBaseWindow extends JFrame implements ActionListener {
	
	private WeatherAppButton btnUsunWszystko;
	//private WeatherAppButton btnDodajDoBazy;
	private WeatherAppButton btnZnajdzMiastoWBazie;
	private WeatherAppButton btnzaladujDB;
	//private WeatherAppButton btnZnajdzDateWBazie;
	
	private WeatherAppTextField txtPodajMiasto;
	//private WeatherAppTextField txtPodajDate;
	
	private JTable databaseRecords = new JTable();
	TableModel model;
	
	public DataBaseWindow() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		this.setPreferredSize(new Dimension(1100, 400));
		this.setMaximumSize(new Dimension(1100, 600));
		
		btnUsunWszystko = new WeatherAppButton("Usun wszystkie dane");
		//btnDodajDoBazy = new WeatherAppButton("Dodaj do bazy");
		btnZnajdzMiastoWBazie = new WeatherAppButton("Znajdz miasto w bazie");
		btnzaladujDB = new WeatherAppButton("Pobierz dane z db");
		//btnZnajdzDateWBazie = new WeatherAppButton("Znajdz date w bazie");
		
		txtPodajMiasto = new WeatherAppTextField("Podaj miasto");
		txtPodajMiasto.setPreferredSize(new Dimension(200, 50));
		//txtPodajDate = new WeatherAppTextField("data");
		//txtPodajDate.setPreferredSize(new Dimension(200, 50));

		JPanel opcje = new JPanel();
		opcje.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//opcje.add(btnDodajDoBazy);
		opcje.add(txtPodajMiasto);
		opcje.add(btnZnajdzMiastoWBazie);
		opcje.add(btnzaladujDB);
		//opcje.add(txtPodajDate);
		//opcje.add(btnZnajdzDateWBazie);
		opcje.add(btnUsunWszystko);
		
		btnUsunWszystko.addActionListener(this);
		btnZnajdzMiastoWBazie.addActionListener(this);
		btnzaladujDB.addActionListener(this);
		
		CreateDBtable(0);
		add(databaseRecords, BorderLayout.CENTER);
		add(new JScrollPane(databaseRecords));
		databaseRecords.setPreferredScrollableViewportSize(databaseRecords.getPreferredSize());
		databaseRecords.setFillsViewportHeight(true);
		add(opcje, BorderLayout.SOUTH);
		this.pack();
	}
	
	private void CreateDBtable(int opt) {
		Object[] kolumny= {
				"Id", "Miasto", "Min temperatura", "Max temperatura", "Cisnienie"
		};
		
		switch(opt) {
		case 0: {
			Object[][] wiersze= getDane();
			
			model = new DefaultTableModel(wiersze, kolumny);
			//databaseRecords = new JTable(model);
			databaseRecords.setModel(model);
			//databaseRecords.setModel(model);
		
			JTableHeader header = databaseRecords.getTableHeader();
			header.setBackground(Properties.DARK_YELLOW);
			
			header.setPreferredSize(new Dimension(1100/kolumny.length, 30));
			databaseRecords.setPreferredSize(new Dimension(1100, 500));
		}
		break;
		case 1: {
			Object[][] wiersze= getDaneByCityName();
			
			model = new DefaultTableModel(wiersze, kolumny);
			//databaseRecords = new JTable(model);
			//databaseRecords.setModel(model);
			databaseRecords.setModel(model);
		
			JTableHeader header = databaseRecords.getTableHeader();
			header.setBackground(Properties.DARK_YELLOW);
			
			header.setPreferredSize(new Dimension(1100/kolumny.length, 30));
			databaseRecords.setPreferredSize(new Dimension(1100, 500));
			}
		break;
		}
	}
	
	private String[][] getDane() {
		ArrayList<String> dane = new ArrayList();
	
		dane = DbConnector.getInstance().getRecords();
		String[][] wiersze = new String[dane.size()/5][5];
		
		for(int i=0;i<dane.size()/5;i++) {
			for(int j =0;j<5;j++) {
				wiersze[i][j] = dane.get(5*i + j);
			}
		}
		
		return wiersze;
	}
	
	private String[][] getDaneByCityName() {
		ArrayList<String> dane = new ArrayList();
		
		dane = DbConnector.getInstance().getDataByCityName(txtPodajMiasto.getText());
		String[][] wiersze = new String[dane.size()/5][5];
		
		for(int i=0;i<dane.size()/5;i++) {
			for(int j =0;j<5;j++) {
				wiersze[i][j] = dane.get(5*i + j);
			}
		}
		
		return wiersze;
	}
	
	
	private void usunDane() {
		DbConnector.getInstance().usunDane();
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnUsunWszystko) {
			usunDane();
			Dialog usuwanieOstrzezenie = new Dialog("Usunieto wszsytkie dane", "Usuwanie danych");
			CreateDBtable(0);
		}
		else if (e.getSource() == btnZnajdzMiastoWBazie) {
			//getDaneByCityName();
			CreateDBtable(1);
		}
		else if(e.getSource() == btnzaladujDB) {
			CreateDBtable(0);
		}
	}
}
