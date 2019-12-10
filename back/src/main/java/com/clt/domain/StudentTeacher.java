package com.clt.domain;

public class StudentTeacher {
    private String id;

    private String bfStudentid;

    private String bfName;

    private String bfSex;

    private String bfNation;

    private String bfBorndate;

    private String claName;

    private String bfNativeplace;

    private String bfResidencetype;

    private String bfPolicy;

    private String claId;

    private String claTerm;

    private String bfZhusu;

    private String bfLeaveschool;

    private String bfQinshihao;

    private String graName;

    private String subId;

    private String subName;

    private String basId;

    private String basName;

    public StudentTeacher(String id, String bfStudentid, String bfName, String bfSex, String bfNation, String bfBorndate, String claName, String bfNativeplace, String bfResidencetype, String bfPolicy, String claId, String claTerm, String bfZhusu, String bfLeaveschool, String bfQinshihao, String graName, String subId, String subName, String basId, String basName) {
        this.id = id;
        this.bfStudentid = bfStudentid;
        this.bfName = bfName;
        this.bfSex = bfSex;
        this.bfNation = bfNation;
        this.bfBorndate = bfBorndate;
        this.claName = claName;
        this.bfNativeplace = bfNativeplace;
        this.bfResidencetype = bfResidencetype;
        this.bfPolicy = bfPolicy;
        this.claId = claId;
        this.claTerm = claTerm;
        this.bfZhusu = bfZhusu;
        this.bfLeaveschool = bfLeaveschool;
        this.bfQinshihao = bfQinshihao;
        this.graName = graName;
        this.subId = subId;
        this.subName = subName;
        this.basId = basId;
        this.basName = basName;
    }

    public StudentTeacher() {
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

    public String getBfName() {
        return bfName;
    }

    public void setBfName(String bfName) {
        this.bfName = bfName == null ? null : bfName.trim();
    }

    public String getBfSex() {
        return bfSex;
    }

    public void setBfSex(String bfSex) {
        this.bfSex = bfSex == null ? null : bfSex.trim();
    }

    public String getBfNation() {
        return bfNation;
    }

    public void setBfNation(String bfNation) {
        this.bfNation = bfNation == null ? null : bfNation.trim();
    }

    public String getBfBorndate() {
        return bfBorndate;
    }

    public void setBfBorndate(String bfBorndate) {
        this.bfBorndate = bfBorndate == null ? null : bfBorndate.trim();
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName == null ? null : claName.trim();
    }

    public String getBfNativeplace() {
        return bfNativeplace;
    }

    public void setBfNativeplace(String bfNativeplace) {
        this.bfNativeplace = bfNativeplace == null ? null : bfNativeplace.trim();
    }

    public String getBfResidencetype() {
        return bfResidencetype;
    }

    public void setBfResidencetype(String bfResidencetype) {
        this.bfResidencetype = bfResidencetype == null ? null : bfResidencetype.trim();
    }

    public String getBfPolicy() {
        return bfPolicy;
    }

    public void setBfPolicy(String bfPolicy) {
        this.bfPolicy = bfPolicy == null ? null : bfPolicy.trim();
    }

    public String getClaId() {
        return claId;
    }

    public void setClaId(String claId) {
        this.claId = claId == null ? null : claId.trim();
    }

    public String getClaTerm() {
        return claTerm;
    }

    public void setClaTerm(String claTerm) {
        this.claTerm = claTerm == null ? null : claTerm.trim();
    }

    public String getBfZhusu() {
        return bfZhusu;
    }

    public void setBfZhusu(String bfZhusu) {
        this.bfZhusu = bfZhusu == null ? null : bfZhusu.trim();
    }

    public String getBfLeaveschool() {
        return bfLeaveschool;
    }

    public void setBfLeaveschool(String bfLeaveschool) {
        this.bfLeaveschool = bfLeaveschool == null ? null : bfLeaveschool.trim();
    }

    public String getBfQinshihao() {
        return bfQinshihao;
    }

    public void setBfQinshihao(String bfQinshihao) {
        this.bfQinshihao = bfQinshihao == null ? null : bfQinshihao.trim();
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