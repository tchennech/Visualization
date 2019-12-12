package com.clt.util;

import com.clt.dao.LocationMapper;
import com.clt.domain.Location;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadPlaceMap {
    public static ReadPlaceMap readPlaceMap = new ReadPlaceMap();
    private Map<String, String> pm;
    private Map<String, Integer> nameToIndex;
    private boolean flag = true;
    private ReadPlaceMap() {
        try{
            nameToIndex = new HashMap<>();
            nameToIndex.put("宁波", 0);
            nameToIndex.put("温州", 1);
            nameToIndex.put("台州", 2);
            nameToIndex.put("辽宁", 3);
            nameToIndex.put("安徽", 4);
            nameToIndex.put("福建", 5);
            nameToIndex.put("河南", 6);
            nameToIndex.put("湖北", 7);
            nameToIndex.put("四川", 8);
            nameToIndex.put("陕西", 9);
            nameToIndex.put("江苏", 10);
            nameToIndex.put("山东", 11);
            nameToIndex.put("吉林", 12);
            nameToIndex.put("黑龙江", 13);
            nameToIndex.put("甘肃", 14);
            nameToIndex.put("浙江", 15);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ReadPlaceMap getReadPlaceMap() {
        return readPlaceMap;
    }

    public Map<String, Integer> getNameToIndex() {
        return nameToIndex;
    }

    public Map<String, String> getPm() {
        return pm;
    }

    public void setPm(List<Location> all) {
        pm = new HashMap<>();
        for(Location single: all) {
            pm.put(single.getOname(), single.getName());
        }
        flag = false;
    }

    public boolean isFlag() {
        return flag;
    }
}
