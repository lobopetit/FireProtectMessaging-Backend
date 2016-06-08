package com.google.backend;

import javax.xml.stream.Location;

/** The object model for the data we are sending through endpoints */
public class MesureBean {

    private Long id;
    private Location location;
    private float temperature;
    private float humidity;



    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}