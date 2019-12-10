package com.clt.domain;

public class ExamType {
    private String examKindId;

    private String examKindName;

    public ExamType(String examKindId, String examKindName) {
        this.examKindId = examKindId;
        this.examKindName = examKindName;
    }

    public ExamType() {
        super();
    }

    public String getExamKindId() {
        return examKindId;
    }

    public void setExamKindId(String examKindId) {
        this.examKindId = examKindId == null ? null : examKindId.trim();
    }

    public String getExamKindName() {
        return examKindName;
    }

    public void setExamKindName(String examKindName) {
        this.examKindName = examKindName == null ? null : examKindName.trim();
    }
}