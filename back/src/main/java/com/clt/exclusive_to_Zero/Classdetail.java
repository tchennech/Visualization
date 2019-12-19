package com.clt.exclusive_to_Zero;

import java.util.Map;

public class Classdetail {
    private int male;
    private int famale;
    private Map<String ,Integer> location;
    private Map<String ,Integer> name;
    private Map<String ,Integer> brith_year;

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFamale() {
        return famale;
    }

    public void setFamale(int famale) {
        this.famale = famale;
    }

    public Map<String, Integer> getLocation() {
        return location;
    }

    public void setLocation(Map<String, Integer> location) {
        this.location = location;
    }

    public Map<String, Integer> getName() {
        return name;
    }

    public void setName(Map<String, Integer> name) {
        this.name = name;
    }

    public Map<String, Integer> getBrith_year() {
        return brith_year;
    }

    public void setBrith_year(Map<String, Integer> brith_year) {
        this.brith_year = brith_year;
    }
}
