package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;

import app.AdditionalInfo;
import app.Properties;
import app.SelectCityName;

import java.awt.Component;
import java.awt.Point;
import javax.swing.JTextField;

public class main_window extends JFrame {

	private JPanel contentPane;
	private Logo logo;
	private static SelectCityName selectCityName;
	private AdditionalInfo additionalInfo;
	private JLabel label;
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_window frame = new main_window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main_window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Properties.WINDOW_WIDTH, Properties.WINDOW_HEIGHT);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		//main window components
		logo = new Logo(this.getWidth(), this.getHeight());
		logo.setPreferredSize(new Dimension(10, 70));
		selectCityName = new SelectCityName(this.getWidth(), this.getHeight(), this);
		additionalInfo = new AdditionalInfo(this.getWidth(), this.getHeight());
		contentPane.setLayout(new BorderLayout(0,0));
		
		contentPane.add(logo, BorderLayout.PAGE_START);

		contentPane.add(selectCityName, BorderLayout.CENTER);
		contentPane.add(additionalInfo, BorderLayout.PAGE_END);
		
	}

}
