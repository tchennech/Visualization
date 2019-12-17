package com.clt.service;

import com.clt.dao.KaoqinMapper;
import com.clt.domain.AttendanceInfo;
import com.clt.domain.Kaoqin;
import com.clt.util.AttendanceMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
