// Description.java

package io.quicktype;

import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Description {
    BROKEN_CLOUDS, CLEAR_SKY, FEW_CLOUDS, LIGHT_SNOW, SCATTERED_CLOUDS;

    @JsonValue
    public String toValue() {
        switch (this) {
        case BROKEN_CLOUDS: return "broken clouds";
        case CLEAR_SKY: return "clear sky";
        case FEW_CLOUDS: return "few clouds";
        case LIGHT_SNOW: return "light snow";
        case SCATTERED_CLOUDS: return "scattered clouds";
        }
        return null;
    }

    @JsonCreator
    public static Description forValue(String value) throws IOException {
        if (value.equals("broken clouds")) return BROKEN_CLOUDS;
        if (value.equals("clear sky")) return CLEAR_SKY;
        if (value.equals("few clouds")) return FEW_CLOUDS;
        if (value.equals("light snow")) return LIGHT_SNOW;
        if (value.equals("scattered clouds")) return SCATTERED_CLOUDS;
        throw new IOException("Cannot deserialize Description");
    }
}