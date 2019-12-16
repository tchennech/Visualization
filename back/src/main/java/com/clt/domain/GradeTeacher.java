package com.clt.domain;

import org.apache.ibatis.annotations.Param;

public class GradeTeacher {
    private String id;

    private String 学期;

    private String 年级;

    private String 班级;

    private String 考试类型;

    private String 学号;

    private String 科目;

    private String 单科分数;

    private String z分数;

    private String t分数;

    private String 等第;

    private String 单科班级排名;

    private String 单科年级排名;

    private String 教师id;

    private String 教师名字;

    public GradeTeacher(String id, String 学期, String 年级, String 班级, String 考试类型, String 学号, String 科目, String 单科分数, String z分数, String t分数, String 等第, String 单科班级排名, String 单科年级排名, String 教师id, String 教师名字) {
        this.id = id;
        this.学期 = 学期;
        this.年级 = 年级;
        this.班级 = 班级;
        this.考试类型 = 考试类型;
        this.学号 = 学号;
        this.科目 = 科目;
        this.单科分数 = 单科分数;
        this.z分数 = z分数;
        this.t分数 = t分数;
        this.等第 = 等第;
        this.单科班级排名 = 单科班级排名;
        this.单科年级排名 = 单科年级排名;
        this.教师id = 教师id;
        this.教师名字 = 教师名字;
    }

    public GradeTeacher() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String get学期() {
        return 学期;
    }

    public void set学期(String 学期) {
        this.学期 = 学期 == null ? null : 学期.trim();
    }

    public String get年级() {
        return 年级;
    }

    public void set年级(String 年级) {
        this.年级 = 年级 == null ? null : 年级.trim();
    }

    public String get班级() {
        return 班级;
    }

    public void set班级(String 班级) {
        this.班级 = 班级 == null ? null : 班级.trim();
    }

    public String get考试类型() {
        return 考试类型;
    }

    public void set考试类型(String 考试类型) {
        this.考试类型 = 考试类型 == null ? null : 考试类型.trim();
    }

    public String get学号() {
        return 学号;
    }

    public void set学号(String 学号) {
        this.学号 = 学号 == null ? null : 学号.trim();
    }

    public String get科目() {
        return 科目;
    }

    public void set科目(String 科目) {
        this.科目 = 科目 == null ? null : 科目.trim();
    }

    public String get单科分数() {
        return 单科分数;
    }

    public void set单科分数(String 单科分数) {
        this.单科分数 = 单科分数 == null ? null : 单科分数.trim();
    }

    public String getZ分数() {
        return z分数;
    }

    public void setZ分数(String z分数) {
        this.z分数 = z分数 == null ? null : z分数.trim();
    }

    public String getT分数() {
        return t分数;
    }

    public void setT分数(String t分数) {
        this.t分数 = t分数 == null ? null : t分数.trim();
    }

    public String get等第() {
        return 等第;
    }

    public void set等第(String 等第) {
        this.等第 = 等第 == null ? null : 等第.trim();
    }

    public String get单科班级排名() {
        return 单科班级排名;
    }

    public void set单科班级排名(String 单科班级排名) {
        this.单科班级排名 = 单科班级排名 == null ? null : 单科班级排名.trim();
    }

    public String get单科年级排名() {
        return 单科年级排名;
    }

    public void set单科年级排名(String 单科年级排名) {
        this.单科年级排名 = 单科年级排名 == null ? null : 单科年级排名.trim();
    }

    public String get教师id() {
        return 教师id;
    }

    public void set教师id(String 教师id) {
        this.教师id = 教师id == null ? null : 教师id.trim();
    }

    public String get教师名字() {
        return 教师名字;
    }

    public void set教师名字(String 教师名字) {
        this.教师名字 = 教师名字 == null ? null : 教师名字.trim();
    }

}