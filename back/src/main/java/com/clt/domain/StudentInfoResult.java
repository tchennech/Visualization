package com.clt.domain;

import java.util.List;

public class StudentInfoResult {
    private List<ChartDataNV> place;
    private List<ChartDataNV> sex;
    private List<ChartDataNV> policy;

    public StudentInfoResult(List<ChartDataNV> place, List<ChartDataNV> sex, List<ChartDataNV> policy) {
        this.place = place;
        this.sex = sex;
        this.policy = policy;
    }
}
