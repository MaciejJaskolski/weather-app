package app;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.WeatherAppButton;
import app.WeatherAppTextField;

public class SelectCityName extends JPanel implements ActionListener{
	
	private WeatherAppTextField txtCityInput;
	private WeatherAppButton findCity;
	private LogoText cityInputHelper;
	private LogoText errorInput;

	public SelectCityName(int w, int h, JFrame window) {
		
		window.getContentPane().setLayout(
			    new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS)
				);
		
		//creating new object for this panel
		cityInputHelper = new LogoText("Enter city name: ", Properties.fontSmall);
		errorInput = new LogoText("Bad input", Properties.fontError);
		txtCityInput = new WeatherAppTextField("ex. Wroclaw");	
		findCity = new WeatherAppButton("Check weather");
			
		//label
		cityInputHelper.setPreferredSize(new Dimension(555, 30));
		
		//input textfield
		txtCityInput.setPreferredSize(new Dimension(350, 50));
			
		//button
		findCity.setPreferredSize(new Dimension(200, 30));
		findCity.LinkWithTextField(txtCityInput);
		//findCity.addActionListener(this);
		findCity.AddActionListener(this);
		findCity.requestFocusInWindow();
		
		//additional panel for input and button
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.add(Box.createHorizontalGlue());
		panel.add(txtCityInput, BorderLayout.CENTER);
		panel.add(Box.createRigidArea(new Dimension(5, 0)));
		panel.add(findCity, BorderLayout.CENTER);
		panel.setBackground(Properties.WHITE);
		
		//select city name panel
		setBackground(Properties.WHITE);	
		
		errorInput.setVisible(false);
			
		//adding objects to panel
		add(cityInputHelper);
		add(errorInput);
		add(panel);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(!txtCityInput.getText().isEmpty() )
			System.out.println(txtCityInput.ReturnCurrentText());
		else  {
			System.out.println("Bad args");
			errorInput.setVisible(true);
		}
	}
	
	public String getCityName() {
		return txtCityInput.ReturnCurrentText();
	}
}
