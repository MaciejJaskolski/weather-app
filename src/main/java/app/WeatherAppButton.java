package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import app.WeatherAppTextField;

public class WeatherAppButton extends JButton{
	
	private String linkedDataString;
	
	public WeatherAppButton(String text) {
		setText(text);
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Properties.ORANGE), 
				BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setBackground(Properties.ORANGE);
		this.setForeground(Properties.DARK_YELLOW);
		this.setFont(Properties.fontSmall);
		this.setFocusPainted(false);	
		setFocusPainted(false);
		this.setBorder(border);
	}
	
	public void Enable() {
		this.setEnabled(true);
	}
	
	public void Disable() {
		this.setEnabled(false);
	}
	
	public void LinkWithTextField(WeatherAppTextField link) {
		this.linkedDataString = link.ReturnCurrentText().toLowerCase();
	}
	
	public void AddActionListener(ActionListener al) {
		this.addActionListener(al);
	}
}
