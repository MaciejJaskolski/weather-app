// Weather.java

package io.quicktype;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Weather {
    private String cod;
    private double message;
    private long cnt;
    private List[] list;
    private City city;

    @JsonProperty("cod")
    public String getCod() { return cod; }
    @JsonProperty("cod")
    public void setCod(String value) { this.cod = value; }

    @JsonProperty("message")
    public double getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(double value) { this.message = value; }

    @JsonProperty("cnt")
    public long getCnt() { return cnt; }
    @JsonProperty("cnt")
    public void setCnt(long value) { this.cnt = value; }

    @JsonProperty("list")
    public List[] getList() { return list; }
    @JsonProperty("list")
    public void setList(List[] value) { this.list = value; }

    @JsonProperty("city")
    public City getCity() { return city; }
    @JsonProperty("city")
    public void setCity(City value) { this.city = value; }
}
