package com.horizontemovil.municiapp.models;

/**
 * Created by Joel on 0022 22/03/2018.
 */

public class Customer {
    private String name;
    private String service;
    private String contact;
    private String address;
    private double geoLatitude;
    private double geoLongitude;
    private int pictureId;

    public Customer(String name, String service, String contact, String address, double geoLatitude, double geoLongitude, int pictureId) {
        this.name = name;
        this.service = service;
        this.contact = contact;
        this.address = address;
        this.geoLatitude = geoLatitude;
        this.geoLongitude = geoLongitude;
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGeoLatitude() {
        return geoLatitude;
    }

    public void setGeoLatitude(double geoLatitude) {
        this.geoLatitude = geoLatitude;
    }

    public double getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoLongitude(double geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
