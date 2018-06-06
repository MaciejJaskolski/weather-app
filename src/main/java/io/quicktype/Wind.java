// Wind.java

package io.quicktype;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Wind {
    private double speed;
    private double deg;

    @JsonProperty("speed")
    public double getSpeed() { return speed; }
    @JsonProperty("speed")
    public void setSpeed(double value) { this.speed = value; }

    @JsonProperty("deg")
    public double getDeg() { return deg; }
    @JsonProperty("deg")
    public void setDeg(double value) { this.deg = value; }
}