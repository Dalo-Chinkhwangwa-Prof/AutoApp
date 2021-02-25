package com.britishbroadcast.intro2recyclerview.model;

import java.io.Serializable;

public class Car implements Serializable {

    private String manufacturer;
    private String model;
    private int releaseYear;

    public Car(String manufacturer, String model, int releaseYear) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.releaseYear = releaseYear;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
