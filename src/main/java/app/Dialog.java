package app;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialog extends JFrame {
	public Dialog(String text, String opt) {
		JOptionPane.showMessageDialog(this,
			    text,
			    opt,
			    JOptionPane.WARNING_MESSAGE);
	}
	
	public void Show() {
		this.setVisible(true);
	}
}
