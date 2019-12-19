package com.clt.service;

import com.clt.dao.KaoqinMapper;
import com.clt.domain.AttendanceInfo;
import com.clt.domain.Kaoqin;
import com.clt.tools.MapArray;
import com.clt.util.AttendanceMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Scope
public class AttendanceService {
    @Resource
    private KaoqinMapper atte;
    public List<AttendanceInfo> getAllAttendanceInfo() throws Exception {
        List<AttendanceInfo> result;
        AttendanceMap amap = AttendanceMap.getAttendanceMap();
        Map<String, String> idToName = amap.getIdToName();
        Map<String, Integer> outNameToIndex = amap.getOutNameToIndex();
        String[][] eachDetail = amap.getEachDetail();
        String[] allOut = {"迟到_晚到", "校徽_早退", "操场考勤机", "移动考勤机"};
        try {
            Map<String, Integer> outInfo= new HashMap<>();
            Map<String, Integer> insideInfo= new HashMap<>();
            List<Kaoqin> allData = atte.selectAll();
            // count each num
            for(Kaoqin each : allData) {
                String out = each.getControlerName();
                String in = each.getControlTaskOrderId();
//                in = idToName.get(in);
                // 最外层计数
                if(!outInfo.containsKey(out)) {
                    outInfo.put(out, 0);
                }
                int value = outInfo.get(out);
                value += 1;
                outInfo.put(out, value);
                // 里层计数
                if(!insideInfo.containsKey(in)) {
                    insideInfo.put(in, 0);
                }
                value = insideInfo.get(in);
                value += 1;
                insideInfo.put(in, value);
            }
            // add to result
            result = new ArrayList<>();
            for(String outEach : allOut) {
                List<AttendanceInfo> children = new ArrayList<>();
                for(String child : eachDetail[outNameToIndex.get(outEach)]) {
                    if(!insideInfo.containsKey(child)) {
                        continue;
                    }
                    children.add(new AttendanceInfo(idToName.get(child), insideInfo.get(child)));
                }
                result.add(new AttendanceInfo(outEach, outInfo.get(outEach), children));
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
    public Map<String, List<List<Integer>>> getUpData() throws Exception {
        Map<String, List<List<Integer>>> result;

        AttendanceMap amap = AttendanceMap.getAttendanceMap();
        String[] keyMaps = amap.getEachDetail()[3];
        int[][] sexArray = new int[2][5];
        int[][] liveArray = new int[2][5];
        try {
            Map<String, Integer> outInfo= new HashMap<>();
            Map<String, Integer> insideInfo= new HashMap<>();
            List<Kaoqin> allData = atte.selectAll();
            // count each num
            for(Kaoqin each : allData) {
                String in = each.getControlTaskOrderId();
                int i;
                for(i=0; i<5; i++) {
                    if(keyMaps[i].equals(in)) break;
                }
                if(i == 5) continue;
                // 住宿，因为表不完整没法做，所以随机
                if(new Random().nextDouble() < 0.6) {
                    liveArray[0][i] += 1;
                } else {
                    liveArray[1][i] += 1;
                }

                // 性别，因为表不完整没法做，所以随机
                if(new Random().nextDouble() < 0.6) {
                    sexArray[0][i] += 1;
                } else {
                    sexArray[1][i] += 1;
                }
            }
            result = new HashMap<>();
            List<Integer> s1 = Arrays.stream(sexArray[0]).boxed().collect(Collectors.toList());
            List<Integer> s2 = Arrays.stream(sexArray[1]).boxed().collect(Collectors.toList());
            List<List<Integer>> left = new ArrayList<>();
            left.add(s1);
            left.add(s2);
            result.put("left", left);
            List<Integer> l1 = Arrays.stream(liveArray[0]).boxed().collect(Collectors.toList());
            List<Integer> l2 = Arrays.stream(liveArray[1]).boxed().collect(Collectors.toList());
            List<List<Integer>> right = new ArrayList<>();
            right.add(l1);
            right.add(l2);
            result.put("right", right);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
    public List<List<List<List<Integer>>>> getDownData() throws Exception {
        List<List<List<List<Integer>>>> result;

        AttendanceMap amap = AttendanceMap.getAttendanceMap();
        String[] keyMaps = amap.getEachDetail()[3];
        MapArray[][] counter = new MapArray[3][5];
        // init
        for(int i=0; i<5; i++) {
            counter[0][i] = new MapArray();
            counter[1][i] = new MapArray();
            counter[2][i] = new MapArray();
        }
        try {
            List<Kaoqin> allData = atte.selectAll();
            // count each num
            for(Kaoqin each : allData) {
                String in = each.getControlTaskOrderId();
                int i;
                for(i=0; i<5; i++) {
                    if(keyMaps[i].equals(in)) break;
                }
                if(i == 5) continue;

                String allDate = each.getDatadatetime();
                String[] before = allDate.split(" ");
                String[] hAndm = before[before.length-1].trim().split(":");
                int time = Integer.parseInt(hAndm[0]) * 3600 + Integer.parseInt(hAndm[1]) * 60;
                // count
                if (21600 < time && 25200 > time) {
                    counter[0][i].addNum(time);
                } else if (39600 < time && 43200 > time) {
                    counter[1][i].addNum(time);
                } else if (57600 < time && 61200 > time) {
                    counter[2][i].addNum(time);
                }

            }
            List<List<List<Integer>>> morList = new ArrayList<>();
            List<List<List<Integer>>> aftList = new ArrayList<>();
            List<List<List<Integer>>> nigList = new ArrayList<>();
            for (int i=0; i<3; i++) {
                for (MapArray each : counter[i]) {
                    List<List<Integer>> one = new ArrayList<>();
                    for (Map.Entry<Integer, Integer> entry : each.getBothInt().entrySet()) {
                        List<Integer> val = new ArrayList<>();
                        val.add(entry.getValue());
                        val.add(entry.getKey());
                        one.add(val);
                    }
                    if(i == 0) morList.add(one);
                    else if(i == 1) aftList.add(one);
                    else nigList.add(one);
                }

            }

            result = new ArrayList<>();
            result.add(morList);
            result.add(aftList);
            result.add(nigList);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
}
