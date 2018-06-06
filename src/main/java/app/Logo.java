package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javafx.scene.layout.Border;
import app.LogoText;
import app.Properties;

public class Logo extends JPanel{
	//private int preferredLogoHeight = 150;
	//private int minLogoHeight = 100;
	//private int maxLogoHeight = 200;

	private BufferedImage image;
	
	private JLabel lblLogo;
	private LogoText logoText;
	
	public Logo(int w, int h) {
		
		logoText = new LogoText("Weather app", Properties.fontBig);
		try {
			image = ImageIO.read(new File("res/sun.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setSize(new Dimension(w, 70));
		this.setBackground(Properties.ORANGE);
		this.add(logoText);		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 50, 0, 64, 64, null); // see javadoc for more info on the parameters            
    }
}
