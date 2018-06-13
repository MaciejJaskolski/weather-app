package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ShowParsedDataWindow extends JFrame{
	
	private JPanel contentPane;
	
	private WeatherAppTextField input;
	private Logo logo;
	
	private DataTable pogodaDzisiaj;
	private DataTable pogodaJutro;
	private DataTable pogodaPojutrze;
	
	private Image weatherImg;
	
	private final int tableWidth = 150;
	private final int tableHeight = 200;
	
	public ShowParsedDataWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Properties.WINDOW_WIDTH, Properties.WINDOW_HEIGHT);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		DataParser dataParser = new DataParser("Praha");
		//DataParser dataParser2 = new DataParser("Wroclaw");
		//DataParser dataParser3 = new DataParser("Wroclaw");
		
		weatherImg = dataParser.getIcon(0);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pogodaDzisiaj = new DataTable(0, dataParser);
		pogodaJutro = new DataTable(1, dataParser);
		pogodaPojutrze = new DataTable(2, dataParser);
		
		logo = new Logo(this.getWidth(), this.getHeight());
		logo.setPreferredSize(new Dimension(10, 70));
		
		input = new WeatherAppTextField("Podaj nazwe miasta: ");
		
		contentPane.add(pogodaDzisiaj, BorderLayout.WEST);
		contentPane.add(input);
		contentPane.add(pogodaJutro, BorderLayout.CENTER);
		contentPane.add(pogodaPojutrze, BorderLayout.EAST);
		contentPane.add(logo, BorderLayout.PAGE_START);

		weatherImg = dataParser.getIcon(0);
		
		
		this.pack();
	}
	
	protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawImage(weatherImg, 30, 450, 50, 50, null); // see javadoc for more info on the parameters            
    }
}
