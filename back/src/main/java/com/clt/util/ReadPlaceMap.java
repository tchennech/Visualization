package com.clt.util;

import java.io.*;
import java.util.Map;

public class ReadPlaceMap {
    public static ReadPlaceMap readPlaceMap = new ReadPlaceMap();
    private Map<String, String> pm;
    private ReadPlaceMap() {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(new File("/home/hadoop/123/16-2016-05-26--2016-05-28.csv-utf8")));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String stemp;
            while((stemp =bufferedReader.readLine()) != null){
                System.out.println(stemp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
