package app;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowParsedDataWindow extends JFrame{
	
	private JPanel contentPane;
	private DataTable tables;
	private Logo logo;
	
	public ShowParsedDataWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Properties.WINDOW_WIDTH, Properties.WINDOW_HEIGHT);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
		logo = new Logo(this.getWidth(), this.getHeight());
		logo.setPreferredSize(new Dimension(10, 70));
		
		tables = new DataTable(); 
		
		contentPane.add(logo, BorderLayout.PAGE_START);
		contentPane.add(tables, BorderLayout.CENTER);
		
	}
}
