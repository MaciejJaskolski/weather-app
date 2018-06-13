package io.quicktype;

//Rain.java

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Rain {
 private Double the3H;

 @JsonProperty("3h")
 public Double getThe3H() { return the3H; }
 @JsonProperty("3h")
 public void setThe3H(Double value) { this.the3H = value; }
}