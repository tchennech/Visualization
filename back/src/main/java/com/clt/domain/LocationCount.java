package com.clt.domain;

public class LocationCount {
    String location;
    int num;

    public LocationCount(String location, int num) {
        this.location = location;
        this.num = num;
    }

    public String getLocation() {
        return location;
    }

    public int getNum() {
        return num;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
