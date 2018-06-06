package app;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class WeatherAppTextField extends JTextField{
	
	private String placeholder;;
	
	public WeatherAppTextField (String startText) {
		this.addFocusListener(active);
		placeholder = startText;
		this.setText(startText);
		this.setFont(Properties.fontSmall);
		Border border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Properties.ORANGE_ALPHA), 
							BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		this.setBorder(border);
	}
	
	FocusListener active = new FocusListener() {
		public void focusGained(FocusEvent e) {
			e.getComponent().setForeground(Properties.BLACK);
			//ResetText();
		}
		
		public void focusLost(FocusEvent e) {
			e.getComponent().setForeground(Properties.LIGHT_GREY);
			if(ReturnCurrentText() == "")
				ReturnToPlaceholder();
			//else 
			//	ReturnCurrentText();
		}
	};
	
	private void ResetText() {
		this.setText("");
	}
	
	public String ReturnCurrentText() {
		return this.getText();
	}
	
	private void ReturnToPlaceholder() {
		this.setText(placeholder);
	}
}
