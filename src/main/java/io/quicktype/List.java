// List.java

package io.quicktype;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class List {
    private long dt;
    private MainClass main;
    private WeatherElement[] weather;
    private Clouds clouds;
    private Wind wind;
    private Snow snow;
    private Sys sys;
    private String dtTxt;

    @JsonProperty("dt")
    public long getDt() { return dt; }
    @JsonProperty("dt")
    public void setDt(long value) { this.dt = value; }

    @JsonProperty("main")
    public MainClass getMain() { return main; }
    @JsonProperty("main")
    public void setMain(MainClass value) { this.main = value; }

    @JsonProperty("weather")
    public WeatherElement[] getWeather() { return weather; }
    @JsonProperty("weather")
    public void setWeather(WeatherElement[] value) { this.weather = value; }

    @JsonProperty("clouds")
    public Clouds getClouds() { return clouds; }
    @JsonProperty("clouds")
    public void setClouds(Clouds value) { this.clouds = value; }

    @JsonProperty("wind")
    public Wind getWind() { return wind; }
    @JsonProperty("wind")
    public void setWind(Wind value) { this.wind = value; }

    @JsonProperty("snow")
    public Snow getSnow() { return snow; }
    @JsonProperty("snow")
    public void setSnow(Snow value) { this.snow = value; }

    @JsonProperty("sys")
    public Sys getSys() { return sys; }
    @JsonProperty("sys")
    public void setSys(Sys value) { this.sys = value; }

    @JsonProperty("dt_txt")
    public String getDtTxt() { return dtTxt; }
    @JsonProperty("dt_txt")
    public void setDtTxt(String value) { this.dtTxt = value; }
}
