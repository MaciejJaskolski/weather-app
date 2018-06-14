package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.GridLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Component;

public class ShowParsedDataWindow extends JFrame implements ActionListener{
	
	private String chosenCity = "Wroclaw";
	
	private JPanel contentPane;
	
	private WeatherAppTextField input;
	private Logo logo;
	
	private Image weatherImg;
	
	private final int tableWidth = 150;
	private final int tableHeight = 200;
	private DataTable dataTable;
	private SelectCityName selectCityName;// = new SelectCityName(this.getWidth(), this.getHeight(), this);
	
	DataParser dataParser;// = new DataParser(chosenCity);
	DataTable dataTable_1;
	DataTable dataTable_2;
	DataTable dataTable_3;
	
	private WeatherAppTextField txtCityInput;
	private WeatherAppButton findCity;
	private LogoText cityInputHelper;
	
	JLabel city;
	
	public ShowParsedDataWindow() {
		setPreferredSize(new Dimension(800, 700));
		
		try {
			dataParser = new DataParser(chosenCity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		selectCityName = new SelectCityName(this.getWidth(), this.getHeight(), this);
		selectCityName.setPreferredSize(new Dimension(0, -100));
		
		cityInputHelper = new LogoText("Enter city name: ", Properties.fontSmall);
		//errorInput = new LogoText("Bad input", Properties.fontError);
		txtCityInput = new WeatherAppTextField("ex. Wroclaw");	
		findCity = new WeatherAppButton("Check weather");
		cityInputHelper.setPreferredSize(new Dimension(555, 30));
		findCity.setPreferredSize(new Dimension(200, 30));
		
		txtCityInput.addActionListener(this);
		
		//input textfield
		txtCityInput.setPreferredSize(new Dimension(250, 50));
		txtCityInput.setMaximumSize(new Dimension(250, 50));
		
		System.out.println("HERE: " + selectCityName.getCityName());
		
		dataTable_1 = new DataTable(0, dataParser);
		//getContentPane().add(dataTable_1, BorderLayout.WEST);
		
		dataTable_2 = new DataTable(1, dataParser);
		//getContentPane().add(dataTable_2, BorderLayout.CENTER);
		
		dataTable_3 = new DataTable(2, dataParser);
		//getContentPane().add(dataTable_3, BorderLayout.EAST);
		
		JPanel inputpanel = new JPanel();
		inputpanel.setMaximumSize(new Dimension(32767, 100));
		inputpanel.setLayout(new FlowLayout(FlowLayout.LEFT));//(inputpanel, new FlowLayout(FlowLayout.LEFT));
		//inputpanel.add(Box.createHorizontalGlue());
		inputpanel.add(txtCityInput, BorderLayout.LINE_START);
		inputpanel.add(findCity, BorderLayout.LINE_START);
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dataParser.UpdateCity(chosenCity);
		dataTable_1.Update(0, dataParser);
		dataTable_2.Update(1, dataParser);
		dataTable_3.Update(2, dataParser);
		city.setText(chosenCity);
		//System.out.println("xxxx"  + dataParser.getCityName());
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if(dataParser.isConnectionEstablished())
				updateData();
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
}
