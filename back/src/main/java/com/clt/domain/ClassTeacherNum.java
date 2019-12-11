package com.clt.domain;

import com.clt.common.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassTeacherNum {
    /* 语 数 英 物 化 生 政 史 地 信息 通用 体育 美术 音乐
    * 1 2 3 4 5 6 17 7 8 13 38 9 12 11
    */
    List<String> label;
    List<Integer> tNum;
    public ClassTeacherNum(List<Teacher> tea) {
        int[] countNum = new int[14];
        for(Teacher line : tea) {
            int classId = Integer.parseInt(line.getSubId());
            switch(classId) {
                case 1:
                    countNum[0] += 1;
                    break;
                case 2:
                    countNum[1] += 1;
                    break;
                case 3:
                    countNum[2] += 1;
                    break;
                case 4:
                    countNum[3] += 1;
                    break;
                case 5:
                    countNum[4] += 1;
                    break;
                case 6:
                    countNum[5] += 1;
                    break;
                case 17:
                    countNum[6] += 1;
                    break;
                case 7:
                    countNum[7] += 1;
                    break;
                case 8:
                    countNum[8] += 1;
                    break;
                case 13:
                    countNum[9] += 1;
                    break;
                case 38:
                    countNum[10] += 1;
                    break;
                case 9:
                    countNum[11] += 1;
                    break;
                case 12:
                    countNum[12] += 1;
                    break;
                case 11:
                    countNum[13] += 1;
                    break;
            }
            tNum = Arrays.stream(countNum).boxed().collect(Collectors.toList());;
            label = new ArrayList<>(Arrays.asList(Const.CLASS_NAME));
        }
    }

    public List<Integer> gettNum() {
        return tNum;
    }

    public List<String> getLabel() {
        return label;
    }

    public void settNum(List<Integer> tNum) {
        this.tNum = tNum;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ClassTeacherNum{" +
                "tNum=" + tNum +
                ", label=" + label +
                '}';
    }
}
