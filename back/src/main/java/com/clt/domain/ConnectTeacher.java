package com.clt.domain;

public class ConnectTeacher {
    private String id;

    private String bfStudentid;

    private String graName;

    private String claName;

    private String claTerm;

    private String subId;

    private String subName;

    private String basId;

    private String basName;

    public ConnectTeacher(String id, String bfStudentid, String graName, String claName, String claTerm, String subId, String subName, String basId, String basName) {
        this.id = id;
        this.bfStudentid = bfStudentid;
        this.graName = graName;
        this.claName = claName;
        this.claTerm = claTerm;
        this.subId = subId;
        this.subName = subName;
        this.basId = basId;
        this.basName = basName;
    }

    public ConnectTeacher() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getClaTerm() {
        return claTerm;
    }

    public void setClaTerm(String claTerm) {
        this.claTerm = claTerm == null ? null : claTerm.trim();
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId == null ? null : subId.trim();
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public String getBasId() {
        return basId;
    }

    public void setBasId(String basId) {
        this.basId = basId == null ? null : basId.trim();
    }

    public String getBasName() {
        return basName;
    }

    public void setBasName(String basName) {
        this.basName = basName == null ? null : basName.trim();
    }
}