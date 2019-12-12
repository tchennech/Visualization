package com.clt.domain;

public class Location {
    String oname;
    String name;

    public Location() {
    }

    public Location(String oname, String name) {
        this.oname = oname;
        this.name = name;
    }

    public String getOname() {
        return oname;
    }

    public String getName() {
        return name;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
