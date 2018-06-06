// MainEnum.java

package io.quicktype;

import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum MainEnum {
    CLEAR, CLOUDS, SNOW;

    @JsonValue
    public String toValue() {
        switch (this) {
        case CLEAR: return "Clear";
        case CLOUDS: return "Clouds";
        case SNOW: return "Snow";
        }
        return null;
    }

    @JsonCreator
    public static MainEnum forValue(String value) throws IOException {
        if (value.equals("Clear")) return CLEAR;
        if (value.equals("Clouds")) return CLOUDS;
        if (value.equals("Snow")) return SNOW;
        throw new IOException("Cannot deserialize MainEnum");
    }
}
