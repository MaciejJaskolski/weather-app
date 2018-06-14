package app;

import java.awt.Dimension;
import java.awt.EventQueue;

public class main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//main_window frame = new main_window();
					ShowParsedDataWindow frame = new ShowParsedDataWindow();
					frame.setVisible(true);
					frame.setResizable(false);
					DbConnector.getInstance().getRecords();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
