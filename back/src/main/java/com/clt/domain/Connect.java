package com.clt.domain;

public class Connect {
    private String bfStudentid;

    private String graName;

    private String claName;

    private String bfSex;

    private String bfName;

    public Connect(String bfStudentid, String graName, String claName, String bfSex, String bfName) {
        this.bfStudentid = bfStudentid;
        this.graName = graName;
        this.claName = claName;
        this.bfSex = bfSex;
        this.bfName = bfName;
    }

    public Connect() {
        super();
    }

    public String getBfStudentid() {
        return bfStudentid;
    }

    public void setBfStudentid(String bfStudentid) {
        this.bfStudentid = bfStudentid == null ? null : bfStudentid.trim();
    }

    public String getGraName() {
        return graName;
    }

    public void setGraName(String graName) {
        this.graName = graName == null ? null : graName.trim();
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName == null ? null : claName.trim();
    }

    public String getBfSex() {
        return bfSex;
    }

    public void setBfSex(String bfSex) {
        this.bfSex = bfSex == null ? null : bfSex.trim();
    }

    public String getBfName() {
        return bfName;
    }

    public void setBfName(String bfName) {
        this.bfName = bfName == null ? null : bfName.trim();
    }
}