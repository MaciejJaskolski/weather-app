package app;

import java.awt.Dimension;

import javax.swing.JPanel;

public class AdditionalInfo extends JPanel {
	public AdditionalInfo(int w, int h) {
		setPreferredSize(new Dimension((int)(0.8*w), (int)(0.1*h)));
		setBackground(Properties.WHITE);
	}
}
