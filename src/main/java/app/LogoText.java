package app;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Properties;

public class LogoText extends JLabel{

	LogoText(String text, Font font) {

		setText(text);
		setFont(font);
		setForeground(Properties.DARK_YELLOW);
		setAlignmentX(CENTER_ALIGNMENT);
	}
}
