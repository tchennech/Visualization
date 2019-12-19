package com.clt.service;

import com.clt.common.Const;
import com.clt.dao.LocationMapper;
import com.clt.dao.StudentInfoMapper;
import com.clt.domain.ChartDataNV;
import com.clt.domain.ClassStus;
import com.clt.domain.StudentInfo;
import com.clt.domain.StudentInfoResult;
import com.clt.util.ReadPlaceMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@Scope
public class StudentService {
	@Resource
	private StudentInfoMapper sim;
	@Resource
	private LocationMapper locationMapper;
	private ReadPlaceMap mapp = ReadPlaceMap.getReadPlaceMap();
	public StudentInfoResult getAllStudentHomeData() throws Exception {
		int[] values = new int[16];
		int[] sexNum = new int[2];
		int[] policies = new int[5];
		if(mapp.isFlag()) {
			mapp.setPm(locationMapper.selectAll());
		}
		Map<String, String> mymap = mapp.getPm();
		Map<String, Integer> nameToIndex = mapp.getNameToIndex();

		try {
			List<StudentInfo> alls = sim.selectAll();
			for(StudentInfo each : alls) {
				// count native place
				String place = each.getBfNativeplace();
				if(mymap.containsKey(place)) {
					values[nameToIndex.get(mymap.get(place))] += 1;
				}
				// count sex num
				String sex = each.getBfSex();
				if(Const.SEX_MALE.equals(sex)) {
					sexNum[0] += 1;
				} else if (Const.SEX_FEMAL.equals(sex)) {
					sexNum[1] += 1;
				}
				//count policy num
				String policy = each.getBfPolicy();
				if(Const.POL_PARTY.equals(policy)) {
					policies[0] += 1;
				} else if (Const.POL_LEAGUE.equals(policy)) {
					policies[1] += 1;
				} else if (Const.POL_DEMPAR.equals(policy)) {
					policies[2] += 1;
				} else if (Const.POL_PIONEER.equals(policy)) {
					policies[3] += 1;
				} else if (Const.POL_PEOPLE.equals(policy)) {
					policies[4] += 1;
				}
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		// place add result
		List<ChartDataNV> place = new ArrayList<>();
		for(int i=0; i<values.length; i++) {
			place.add(new ChartDataNV(Const.PLACES[i], values[i]));
		}
		//sex add result
		List<ChartDataNV> sex = new ArrayList<>();
		sex.add(new ChartDataNV(Const.SEX_MALE, sexNum[0]));
		sex.add(new ChartDataNV(Const.SEX_FEMAL, sexNum[1]));
		//policy add result
		List<ChartDataNV> policy = new ArrayList<>();
		for(int i=0; i<policies.length; i++) {
			policy.add(new ChartDataNV(Const.POLICY[i], policies[i]));
		}
		return new StudentInfoResult(place, sex, policy);
	}
	public String selectStunamebyid(String id){
		return sim.selectStunamebyid(id);
	}
	public List<StudentInfo> selectStubyClassname(String classname) {
		return sim.selectStubyClassname(classname);

	}
	public List<ClassStus>selectClassStu(){
		return sim.selectClassStu();
	}
}
