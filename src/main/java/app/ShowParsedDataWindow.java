package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.border.EmptyBorder;

public class ShowParsedDataWindow extends JFrame implements ActionListener{
	
	private String chosenCity = "Wroclaw";
	
	private Image weatherImg;
	
	private SelectCityName selectCityName;// = new SelectCityName(this.getWidth(), this.getHeight(), this);
	
	DataParser dataParser;// = new DataParser(chosenCity);
	DataTable dataTable_1;
	DataTable dataTable_2;
	DataTable dataTable_3;
	
	private WeatherAppTextField txtCityInput;
	private WeatherAppButton findCity;
	private WeatherAppButton showDatabase;
	private LogoText cityInputHelper;
	
	JLabel city;
	
	WeatherChart chart;
	
	public ShowParsedDataWindow() {
		setPreferredSize(new Dimension(800, 700));
		
		try {
			dataParser = new DataParser(chosenCity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		selectCityName = new SelectCityName(this.getWidth(), this.getHeight(), this);
		selectCityName.setPreferredSize(new Dimension(0, -100));
		
		cityInputHelper = new LogoText("Enter city name: ", Properties.fontSmall);
		//errorInput = new LogoText("Bad input", Properties.fontError);
		txtCityInput = new WeatherAppTextField("np. Wroclaw");	
		findCity = new WeatherAppButton("Sprawdz pogodę");
		cityInputHelper.setPreferredSize(new Dimension(555, 30));
		findCity.setPreferredSize(new Dimension(200, 30));
		
		showDatabase = new WeatherAppButton("Pokaz baze danych");
		showDatabase.setPreferredSize(new Dimension(200, 30));
		
		txtCityInput.addActionListener(this);
		showDatabase.AddActionListener(this);
		
		//input textfield
		txtCityInput.setPreferredSize(new Dimension(250, 50));
		txtCityInput.setMaximumSize(new Dimension(250, 50));
		
		dataTable_1 = new DataTable(0, dataParser);
		//getContentPane().add(dataTable_1, BorderLayout.WEST);
		
		dataTable_2 = new DataTable(1, dataParser);
		//getContentPane().add(dataTable_2, BorderLayout.CENTER);
		
		dataTable_3 = new DataTable(2, dataParser);
		
		chart = new WeatherChart(dataParser);
		//JPanel chartPanel = new JPanel();
		//chartPanel.setPreferredSize(new Dimension(900, 600));
		chart.setBorder(new EmptyBorder(0, 0, 50, 0));
		//chartPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//chartPanel.add(chart);
		//chart.setPreferredSize(new Dimension(600, 600));
		//getContentPane().add(dataTable_3, BorderLayout.EAST);
		
		JPanel inputpanel = new JPanel();
		inputpanel.setMaximumSize(new Dimension(32767, 100));
		inputpanel.setLayout(new FlowLayout(FlowLayout.LEFT));//(inputpanel, new FlowLayout(FlowLayout.LEFT));
		//inputpanel.add(Box.createHorizontalGlue());
		inputpanel.add(txtCityInput, BorderLayout.LINE_START);
		inputpanel.add(findCity, BorderLayout.LINE_START);
		inputpanel.add(showDatabase, FlowLayout.RIGHT);
		inputpanel.setBackground(Properties.DARK_YELLOW);
		inputpanel.setPreferredSize(new Dimension(0, 70));
		//inputpanel.setPreferredSize(new Dimension(this.getWidth(), 50));
		//inputpanel.setMaximumSize(new Dimension(this.getWidth(), 70));
		
		JPanel panel = new JPanel();
		city = new JLabel();
		city.setText(chosenCity);
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.add(Box.createHorizontalGlue());
		panel.add(dataTable_1, BorderLayout.CENTER);
		//panel.add(Box.createRigidArea(new Dimension(5, 0)));
		panel.add(dataTable_2, BorderLayout.CENTER);
		panel.add(dataTable_3, BorderLayout.CENTER);
		//panel.setBackground(Properties.WHITE);
		
		//getContentPane().add(selectCityName, BorderLayout.NORTH);
		getContentPane().add(city, BorderLayout.EAST);
		getContentPane().add(inputpanel);
		getContentPane().add(panel);
		getContentPane().add(chart, BorderLayout.SOUTH);
		
		JScrollPane scroll = new JScrollPane(chart);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.getContentPane().add(scroll);
		
		this.pack();
	}
	
	protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawImage(weatherImg, 30, 450, 50, 50, null); // see javadoc for more info on the parameters            
    }
	
	private void updateData() {
		//chosenCity = selectCityName.getCityName();
		chosenCity = txtCityInput.getText();
		try {
			dataParser = new DataParser(chosenCity);
			DbConnector.getInstance().insertData(dataParser.getCityName(),
					dataParser.getMinTemperatureDouble(0),
					dataParser.getMaxTemperatureDouble(0),
					dataParser.getPressure(0)
			);
			DbConnector.getInstance().insertData(dataParser.getCityName(),
					dataParser.getMinTemperatureDouble(1),
					dataParser.getMaxTemperatureDouble(1),
					dataParser.getPressure(1)
			);
			DbConnector.getInstance().insertData(dataParser.getCityName(),
					dataParser.getMinTemperatureDouble(2),
					dataParser.getMaxTemperatureDouble(2),
					dataParser.getPressure(2)
			);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataTable_1.Update(0, dataParser);
		dataTable_2.Update(1, dataParser);
		dataTable_3.Update(2, dataParser);
		chart.Update(dataParser);
		//chart.Update(dataParser);
		city.setText(chosenCity);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtCityInput) {
			try {
				if(dataParser.isConnectionEstablished()) {
					updateData();
				}	
				else {
					System.out.println("No internet connection");
					Dialog dialogNoConnection = new Dialog("No internet connection", "OK");
					dialogNoConnection.Show();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == showDatabase) {
			DataBaseWindow dbwindow = new DataBaseWindow();
			dbwindow.setVisible(true);
		}
		
	}
}
