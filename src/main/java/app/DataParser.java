package app;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import org.apache.commons.io.FileUtils;

import io.quicktype.Converter;
import io.quicktype.Weather;

public class DataParser {
	
	private URL url;
	private String filePath = "res/forecast.txt";
	private File weatherFile;
	private Weather weather;
	//URL url = new URL("http://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b6907d289e10d714a6e88b30761fae22");
	//File file = new File("res/forecast.txt");
	//FileUtils.copyURLToFile(url, file);
	//String json = FileUtils.readFileToString(file);
	
	//Weather data  = Converter.fromJsonString(json);
	
	public DataParser(String cityname) {
		try {
			url = new URL("http://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b6907d289e10d714a6e88b30761fae22");
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
			weather = Converter.fromJsonString(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCityName() {
		return weather.getCity().getName();
	}
	
	public String getTemperature() {
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		
		return df.format(weather.getList()[0].getMain().getTemp() - 273);
	}
	
}
