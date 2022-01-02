package com.jet.framework.utilities;

import java.util.List;
import java.util.Map;

import com.jet.framework.POJO.Payload;

public class TestDataBuilder {

	Payload p;
	
	public Payload AddPayload(List<Map<String, String>> list) {
		Map<String, String> dataMap = list.get(0);
		p=new Payload();
		p.setId(1);
		p.setUserId(Integer.parseInt(dataMap.get("UserId")));
		p.setTitle(dataMap.get("Title"));
		p.setBody(dataMap.get("Body"));
		
		return p;
	}
}
