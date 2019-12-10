package com.clt.domain;

public class Kaoqin {
    private String kaoqingId;

    private String qjTerm;

    private String datadatetime;

    private String controllerid;

    private String controlerName;

    private String controlTaskOrderId;

    private String bfStudentid;

    private String bfName;

    private String claName;

    private String bfClassid;

    public Kaoqin(String kaoqingId, String qjTerm, String datadatetime, String controllerid, String controlerName, String controlTaskOrderId, String bfStudentid, String bfName, String claName, String bfClassid) {
        this.kaoqingId = kaoqingId;
        this.qjTerm = qjTerm;
        this.datadatetime = datadatetime;
        this.controllerid = controllerid;
        this.controlerName = controlerName;
        this.controlTaskOrderId = controlTaskOrderId;
        this.bfStudentid = bfStudentid;
        this.bfName = bfName;
        this.claName = claName;
        this.bfClassid = bfClassid;
    }

    public Kaoqin() {
        super();
    }

    public String getKaoqingId() {
        return kaoqingId;
    }

    public void setKaoqingId(String kaoqingId) {
        this.kaoqingId = kaoqingId == null ? null : kaoqingId.trim();
    }

    public String getQjTerm() {
        return qjTerm;
    }

    public void setQjTerm(String qjTerm) {
        this.qjTerm = qjTerm == null ? null : qjTerm.trim();
    }

    public String getDatadatetime() {
        return datadatetime;
    }

    public void setDatadatetime(String datadatetime) {
        this.datadatetime = datadatetime == null ? null : datadatetime.trim();
    }

    public String getControllerid() {
        return controllerid;
    }

    public void setControllerid(String controllerid) {
        this.controllerid = controllerid == null ? null : controllerid.trim();
    }

    public String getControlerName() {
        return controlerName;
    }

    public void setControlerName(String controlerName) {
        this.controlerName = controlerName == null ? null : controlerName.trim();
    }

    public String getControlTaskOrderId() {
        return controlTaskOrderId;
    }

    public void setControlTaskOrderId(String controlTaskOrderId) {
        this.controlTaskOrderId = controlTaskOrderId == null ? null : controlTaskOrderId.trim();
    }

    public String getBfStudentid() {
        return bfStudentid;
    }

    public void setBfStudentid(String bfStudentid) {
        this.bfStudentid = bfStudentid == null ? null : bfStudentid.trim();
    }

    public String getBfName() {
        return bfName;
    }

    public void setBfName(String bfName) {
        this.bfName = bfName == null ? null : bfName.trim();
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName == null ? null : claName.trim();
    }

    public String getBfClassid() {
        return bfClassid;
    }

    public void setBfClassid(String bfClassid) {
        this.bfClassid = bfClassid == null ? null : bfClassid.trim();
    }
}