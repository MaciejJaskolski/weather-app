// Snow.java

package io.quicktype;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Snow {
    private Double the3H;

    @JsonProperty("3h")
    public Double getThe3H() { return the3H; }
    @JsonProperty("3h")
    public void setThe3H(Double value) { this.the3H = value; }
}