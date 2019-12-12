package com.clt.service;

import com.clt.domain.LocationCount;
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
	ReadPlaceMap mapp = ReadPlaceMap.getReadPlaceMap();
	public List<LocationCount> getAllStudentFrom() throws Exception {
		int[] values= new int[16];
		Map<String, String> mymap = mapp.getPm();
		try {

		} catch (Exception e) {
			throw new Exception(e);
		}
		List<LocationCount> result = new ArrayList<>();
		for(int val : values) {
			result.add(new LocationCount('', val));
		}
		return result;
	}

}
