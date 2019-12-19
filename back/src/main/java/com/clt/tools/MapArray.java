package com.clt.tools;

import java.util.HashMap;
import java.util.Map;

public class MapArray {
    private Map<Integer, Integer> bothInt;
    public MapArray() {
        bothInt = new HashMap<>();
    }

    public Map<Integer, Integer> getBothInt() {
        return bothInt;
    }

    public void addNum(int key) {
        if(bothInt.containsKey(key)) {
            this.bothInt.put(key, this.bothInt.get(key) + 1);
        } else {
            bothInt.put(key, 1);
        }
    }
}
