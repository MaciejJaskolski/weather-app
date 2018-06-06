package app;

import java.awt.Color;
import java.awt.Font;

public class Properties {
	//window properties
	public static final int WINDOW_WIDTH = 16* 50;
	public static final int WINDOW_HEIGHT = 9* 50;
	
	//used colors
	public static final Color ORANGE = new Color(255, 124, 38); 
	public static final Color ORANGE_ALPHA = new Color(255, 124, 38, 90);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color DARK_YELLOW = new Color(255, 215, 38);
	public static final Color LIGHT_GREY = new Color(96, 93, 91);
	
	//used fonts
	public static final Font fontBig = new Font("Helvetica", Font.ITALIC ,32);
	public static final Font fontMedium = new Font("Helvetica", Font.PLAIN , 24);
	public static final Font fontSmall = new Font("Helvetica", Font.PLAIN , 16);
	public static final Font fontError = new Font("Helvetica", Font.PLAIN , 16);
}
