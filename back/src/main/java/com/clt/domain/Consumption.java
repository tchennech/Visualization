package com.clt.domain;

public class Consumption {
    private String id;

    private String dealtime;

    private String mondeal;

    private String bfStudentid;

    private String accname;

    private String persex;

    private String year;

    private String month;

    private String day;

    private String hour;

    private String weekday;

    private String startEnd;

    public Consumption(String id, String dealtime, String mondeal, String bfStudentid, String accname, String persex, String year, String month, String day, String hour, String weekday, String startEnd) {
        this.id = id;
        this.dealtime = dealtime;
        this.mondeal = mondeal;
        this.bfStudentid = bfStudentid;
        this.accname = accname;
        this.persex = persex;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.weekday = weekday;
        this.startEnd = startEnd;
    }

    public Consumption() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDealtime() {
        return dealtime;
    }

    public void setDealtime(String dealtime) {
        this.dealtime = dealtime == null ? null : dealtime.trim();
    }

    public String getMondeal() {
        return mondeal;
    }

    public void setMondeal(String mondeal) {
        this.mondeal = mondeal == null ? null : mondeal.trim();
    }

    public String getBfStudentid() {
        return bfStudentid;
    }

    public void setBfStudentid(String bfStudentid) {
        this.bfStudentid = bfStudentid == null ? null : bfStudentid.trim();
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname == null ? null : accname.trim();
    }

    public String getPersex() {
        return persex;
    }

    public void setPersex(String persex) {
        this.persex = persex == null ? null : persex.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour == null ? null : hour.trim();
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday == null ? null : weekday.trim();
    }

    public String getStartEnd() {
        return startEnd;
    }

    public void setStartEnd(String startEnd) {
        this.startEnd = startEnd == null ? null : startEnd.trim();
    }
}