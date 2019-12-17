package com.clt.domain;

import java.util.List;

public class AttendanceInfo {
    String name;
    int value;
    List<AttendanceInfo> children;

    public AttendanceInfo(String name, int value, List<AttendanceInfo> children) {
        this.name = name;
        this.value = value;
        this.children = children;
    }

    public AttendanceInfo(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<AttendanceInfo> getChildren() {
        return children;
    }

    public void setChildren(List<AttendanceInfo> children) {
        this.children = children;
    }
}
