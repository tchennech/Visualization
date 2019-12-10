package com.clt.domain;

public class Teacher {
    private String tId;

    private String term;

    private String claId;

    private String claName;

    private String graName;

    private String subId;

    private String subName;

    private String basId;

    private String basName;

    public Teacher(String tId, String term, String claId, String claName, String graName, String subId, String subName, String basId, String basName) {
        this.tId = tId;
        this.term = term;
        this.claId = claId;
        this.claName = claName;
        this.graName = graName;
        this.subId = subId;
        this.subName = subName;
        this.basId = basId;
        this.basName = basName;
    }

    public Teacher() {
        super();
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId == null ? null : tId.trim();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public String getClaId() {
        return claId;
    }

    public void setClaId(String claId) {
        this.claId = claId == null ? null : claId.trim();
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName == null ? null : claName.trim();
    }

    public String getGraName() {
        return graName;
    }

    public void setGraName(String graName) {
        this.graName = graName == null ? null : graName.trim();
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