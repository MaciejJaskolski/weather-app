// WeatherElement.java

package io.quicktype;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class WeatherElement {
    private long id;
    private MainEnum main;
    private String description;
    private String icon;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("main")
    public MainEnum getMain() { return main; }
    @JsonProperty("main")
    public void setMain(MainEnum value) { this.main = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("icon")
    public String getIcon() { return icon; }
    @JsonProperty("icon")
    public void setIcon(String value) { this.icon = value; }
}
