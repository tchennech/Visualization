package com.clt.domain;

public class Grade2 {
    private String id;

    private String mesTestid;

    private String examNumber;

    private String examNumname;

    private String mesSubId;

    private String mesSubName;

    private String examTerm;

    private String examType;

    private String examSdate;

    private String mesStudentid;

    private String mesScore;

    private String mesZScore;

    private String mesTScore;

    private String mesDengdi;

    private String chengjiId;

    public Grade2(String id, String mesTestid, String examNumber, String examNumname, String mesSubId, String mesSubName, String examTerm, String examType, String examSdate, String mesStudentid, String mesScore, String mesZScore, String mesTScore, String mesDengdi, String chengjiId) {
        this.id = id;
        this.mesTestid = mesTestid;
        this.examNumber = examNumber;
        this.examNumname = examNumname;
        this.mesSubId = mesSubId;
        this.mesSubName = mesSubName;
        this.examTerm = examTerm;
        this.examType = examType;
        this.examSdate = examSdate;
        this.mesStudentid = mesStudentid;
        this.mesScore = mesScore;
        this.mesZScore = mesZScore;
        this.mesTScore = mesTScore;
        this.mesDengdi = mesDengdi;
        this.chengjiId = chengjiId;
    }

    public Grade2() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMesTestid() {
        return mesTestid;
    }

    public void setMesTestid(String mesTestid) {
        this.mesTestid = mesTestid == null ? null : mesTestid.trim();
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber == null ? null : examNumber.trim();
    }

    public String getExamNumname() {
        return examNumname;
    }

    public void setExamNumname(String examNumname) {
        this.examNumname = examNumname == null ? null : examNumname.trim();
    }

    public String getMesSubId() {
        return mesSubId;
    }

    public void setMesSubId(String mesSubId) {
        this.mesSubId = mesSubId == null ? null : mesSubId.trim();
    }

    public String getMesSubName() {
        return mesSubName;
    }

    public void setMesSubName(String mesSubName) {
        this.mesSubName = mesSubName == null ? null : mesSubName.trim();
    }

    public String getExamTerm() {
        return examTerm;
    }

    public void setExamTerm(String examTerm) {
        this.examTerm = examTerm == null ? null : examTerm.trim();
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType == null ? null : examType.trim();
    }

    public String getExamSdate() {
        return examSdate;
    }

    public void setExamSdate(String examSdate) {
        this.examSdate = examSdate == null ? null : examSdate.trim();
    }

    public String getMesStudentid() {
        return mesStudentid;
    }

    public void setMesStudentid(String mesStudentid) {
        this.mesStudentid = mesStudentid == null ? null : mesStudentid.trim();
    }

    public String getMesScore() {
        return mesScore;
    }

    public void setMesScore(String mesScore) {
        this.mesScore = mesScore == null ? null : mesScore.trim();
    }

    public String getMesZScore() {
        return mesZScore;
    }

    public void setMesZScore(String mesZScore) {
        this.mesZScore = mesZScore == null ? null : mesZScore.trim();
    }

    public String getMesTScore() {
        return mesTScore;
    }

    public void setMesTScore(String mesTScore) {
        this.mesTScore = mesTScore == null ? null : mesTScore.trim();
    }

    public String getMesDengdi() {
        return mesDengdi;
    }

    public void setMesDengdi(String mesDengdi) {
        this.mesDengdi = mesDengdi == null ? null : mesDengdi.trim();
    }

    public String getChengjiId() {
        return chengjiId;
    }

    public void setChengjiId(String chengjiId) {
        this.chengjiId = chengjiId == null ? null : chengjiId.trim();
    }
}