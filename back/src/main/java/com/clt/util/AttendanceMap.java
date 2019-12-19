package com.clt.util;

import java.util.HashMap;
import java.util.Map;

public class AttendanceMap {
    private static AttendanceMap attendanceMap = new AttendanceMap();
    private Map<String, String> idToName;
    private Map<String, Integer> outNameToIndex;
    private String[][] eachDetail = {{"100000", "100100", "100200", "100300"},
            {"200000", "200100", "200200"},
            {"300000", "300100", "300200"},
            {"9900100", "9900200", "9900300", "9900400", "9900500"}
    };

    private AttendanceMap() {
        idToName = new HashMap<>();
        idToName.put("100000", "默认信息");
        idToName.put("100100", "早上迟到");
        idToName.put("100200", "晚到学校");
        idToName.put("100300", "晚自修迟到");
        idToName.put("200000", "默认信息");
        idToName.put("200100", "校徽校服");
        idToName.put("200200", "请假离校");
        idToName.put("300000", "默认信息");
        idToName.put("300100", "住宿早晨锻炼");
        idToName.put("300200", "课间操请假");
        idToName.put("9900100", "迟到");
        idToName.put("9900200", "校服");
        idToName.put("9900300", "早退");
        idToName.put("9900400", "离校");
        idToName.put("9900500", "进校");

//        nameToIndex = new HashMap<>();
//        nameToIndex.put("100000", 0);
//        nameToIndex.put("100100", 1);
//        nameToIndex.put("100200", 2);
//        nameToIndex.put("100300", 3);
//        nameToIndex.put("200000", 0);
//        nameToIndex.put("200100", 1);
//        nameToIndex.put("200200", 2);
//        nameToIndex.put("300000", 0);
//        nameToIndex.put("300100", 1);
//        nameToIndex.put("300200", 2);
//        nameToIndex.put("9900100", 0);
//        nameToIndex.put("9900200", 1);
//        nameToIndex.put("9900300", 2);
//        nameToIndex.put("9900400", 3);
//        nameToIndex.put("9900500", 4);

        outNameToIndex = new HashMap<>();
        outNameToIndex.put("迟到_晚到", 0);
        outNameToIndex.put("校徽_早退", 1);
        outNameToIndex.put("操场考勤机", 2);
        outNameToIndex.put("移动考勤机", 3);
    }

    public static AttendanceMap getAttendanceMap() {
        return attendanceMap;
    }

    public Map<String, String> getIdToName() {
        return idToName;
    }

    public Map<String, Integer> getOutNameToIndex() {
        return outNameToIndex;
    }

    public String[][] getEachDetail() {
        return eachDetail;
    }

//    public Map<String, Integer> getNameToIndex() {
//        return nameToIndex;
//    }
}
