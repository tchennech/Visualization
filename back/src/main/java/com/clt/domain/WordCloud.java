package com.clt.domain;

public class WordCloud {
    private String id;

    private String 内容;

    public WordCloud(String id, String 内容) {
        this.id = id;
        this.内容 = 内容;
    }

    public WordCloud() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String get内容() {
        return 内容;
    }

    public void set内容(String 内容) {
        this.内容 = 内容 == null ? null : 内容.trim();
    }
}