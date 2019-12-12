package com.clt.util;

import com.clt.dao.LocationMapper;
import com.clt.domain.Location;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;
import java.util.Map;

public class ReadPlaceMap {
    public static ReadPlaceMap readPlaceMap = new ReadPlaceMap();
    private Map<String, String> pm;
    @Resource
    private LocationMapper locationMapper;
    private ReadPlaceMap() {

        try {
            List<Location> all = locationMapper.selectAll();
            for(Location single: all) {
                pm.put(single.getOname(), single.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ReadPlaceMap getReadPlaceMap() {
        return readPlaceMap;
    }

    public Map<String, String> getPm() {
        return pm;
    }
}
