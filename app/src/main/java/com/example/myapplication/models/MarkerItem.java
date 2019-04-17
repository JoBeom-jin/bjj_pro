package com.example.myapplication.models;

import io.realm.RealmObject;

public class MarkerItem extends RealmObject {
    double lat;
    double lon;
    String title;
    String add;
    String phone_num;

    public MarkerItem(){

    }


    public MarkerItem(double lat, double lon, String title, String add, String phone_num) {
        this.lat = lat;
        this.lon = lon;
        this.title = title;
        this.add = add;
        this.phone_num = phone_num;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;

    }


    public String  getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }


    public String  getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;

    }


    public String  getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;

    }

}

