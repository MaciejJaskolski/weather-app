package app;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import io.quicktype.Clouds;
import io.quicktype.Converter;
import io.quicktype.Weather;

public class DataParser {
	
	private URL url;
	private String filePath = "res/forecast.txt";
	private File weatherFile;
	private Weather weather;
	private Image weatherImg;
	//URL url = new URL("http://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b6907d289e10d714a6e88b30761fae22");
	//File file = new File("res/forecast.txt");
	//FileUtils.copyURLToFile(url, file);
	//String json = FileUtils.readFileToString(file);
	
	//Weather data  = Converter.fromJsonString(json);
	
	public DataParser(String cityname) {
		try {
			String apikey = "86a55b4022f4f3f2b3e9f93a9db6ba15";
			String u = "http://api.openweathermap.org/data/2.5/forecast?q=" + cityname +"&mode=json&appid=" + apikey;
			url = new URL(u);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File weatherFile = new File(filePath);
		try {
			FileUtils.copyURLToFile(url, weatherFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String json = FileUtils.readFileToString(weatherFile);
			System.out.println("zzz");
			weather = Converter.fromJsonString(json);
			System.out.println("aaa");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCityName() {
		return weather.getCity().getName();
	}
	
	public String getTemperature(int day) {
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		//System.out.print("day: " + day);	
		return df.format(weather.getList()[day*8].getMain().getTemp() - 273);
	}
	
	public String getMinTemperature(int day) {
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		return df.format(weather.getList()[day*8].getMain().getTempMin() - 273); 
	}
	
	public String getMaxTemperature(int day) {
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		return df.format(weather.getList()[day*8].getMain().getTempMax() - 273); 
	}
	
	public double getPressure(int day) {
		return weather.getList()[day*8].getMain().getPressure();
	}
	
	public Image getIcon(int day) {
		Image image;
		String iconName = weather.getList()[day*8].getWeather()[0].getIcon();
		URL imageUrl;
		File imageFile = new File("res/" + iconName + ".png");
		try {
			imageUrl = new URL("http://openweathermap.org/img/w/" + iconName + ".png");
			try {
				FileUtils.copyURLToFile(imageUrl, imageFile);
				try {
					image = ImageIO.read(imageFile);
					
					//return downloaded picture
					return image;
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
