// MainClass.java

package io.quicktype;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class MainClass {
    private double temp;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private double seaLevel;
    private double grndLevel;
    private long humidity;
    private double tempKf;

    @JsonProperty("temp")
    public double getTemp() { return temp; }
    @JsonProperty("temp")
    public void setTemp(double value) { this.temp = value; }

    @JsonProperty("temp_min")
    public double getTempMin() { return tempMin; }
    @JsonProperty("temp_min")
    public void setTempMin(double value) { this.tempMin = value; }

    @JsonProperty("temp_max")
    public double getTempMax() { return tempMax; }
    @JsonProperty("temp_max")
    public void setTempMax(double value) { this.tempMax = value; }

    @JsonProperty("pressure")
    public double getPressure() { return pressure; }
    @JsonProperty("pressure")
    public void setPressure(double value) { this.pressure = value; }

    @JsonProperty("sea_level")
    public double getSeaLevel() { return seaLevel; }
    @JsonProperty("sea_level")
    public void setSeaLevel(double value) { this.seaLevel = value; }

    @JsonProperty("grnd_level")
    public double getGrndLevel() { return grndLevel; }
    @JsonProperty("grnd_level")
    public void setGrndLevel(double value) { this.grndLevel = value; }

    @JsonProperty("humidity")
    public long getHumidity() { return humidity; }
    @JsonProperty("humidity")
    public void setHumidity(long value) { this.humidity = value; }

    @JsonProperty("temp_kf")
    public double getTempKf() { return tempKf; }
    @JsonProperty("temp_kf")
    public void setTempKf(double value) { this.tempKf = value; }
}
