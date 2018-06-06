// Sys.java

package io.quicktype;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Sys {
    private Pod pod;

    @JsonProperty("pod")
    public Pod getPod() { return pod; }
    @JsonProperty("pod")
    public void setPod(Pod value) { this.pod = value; }
}