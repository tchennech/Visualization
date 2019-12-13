package com.clt.domain;

public class Grade {
    private String id;

    private String bfStudentid;

    private String graName;

    private String claName;

    private String bfSex;

    private String bfName;

    private String mesTestid;

    private String examNumber;

    private String examNumname;

    private String mesSubId;

    private String mesSubName;

    private String examTerm;

    private String examType;

    private String examSdate;

    private String mesScore;

    private String mesZScore;

    private String mesTScore;

    private String mesDengdi;

    private String examKindName;

    public Grade(String id, String bfStudentid, String graName, String claName, String bfSex, String bfName, String mesTestid, String examNumber, String examNumname, String mesSubId, String mesSubName, String examTerm, String examType, String examSdate, String mesScore, String mesZScore, String mesTScore, String mesDengdi, String examKindName) {
        this.id = id;
        this.bfStudentid = bfStudentid;
        this.graName = graName;
        this.claName = claName;
        this.bfSex = bfSex;
        this.bfName = bfName;
        this.mesTestid = mesTestid;
        this.examNumber = examNumber;
        this.examNumname = examNumname;
        this.mesSubId = mesSubId;
        this.mesSubName = mesSubName;
        this.examTerm = examTerm;
        this.examType = examType;
        this.examSdate = examSdate;
        this.mesScore = mesScore;
        this.mesZScore = mesZScore;
        this.mesTScore = mesTScore;
        this.mesDengdi = mesDengdi;
        this.examKindName = examKindName;
    }

    public Grade() {
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

    public String getExamKindName() {
        return examKindName;
    }

    public void setExamKindName(String examKindName) {
        this.examKindName = examKindName == null ? null : examKindName.trim();
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id='" + id + '\'' +
                ", bfStudentid='" + bfStudentid + '\'' +
                ", graName='" + graName + '\'' +
                ", claName='" + claName + '\'' +
                ", bfSex='" + bfSex + '\'' +
                ", bfName='" + bfName + '\'' +
                ", mesTestid='" + mesTestid + '\'' +
                ", examNumber='" + examNumber + '\'' +
                ", examNumname='" + examNumname + '\'' +
                ", mesSubId='" + mesSubId + '\'' +
                ", mesSubName='" + mesSubName + '\'' +
                ", examTerm='" + examTerm + '\'' +
                ", examType='" + examType + '\'' +
                ", examSdate='" + examSdate + '\'' +
                ", mesScore='" + mesScore + '\'' +
                ", mesZScore='" + mesZScore + '\'' +
                ", mesTScore='" + mesTScore + '\'' +
                ", mesDengdi='" + mesDengdi + '\'' +
                ", examKindName='" + examKindName + '\'' +
                '}';
    }
}