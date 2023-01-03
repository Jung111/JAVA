package com.poseidon.util;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;
//T, K, V, E 
@Component
public class MapRemove {
	public Map<?, ?> remove(Map<?, ?> map){
		ArrayList<Object> al = new ArrayList<Object>(map.keySet());
		for (Object key : al) {
			if(map.get(key).equals("")) {
				map.remove(key);
			}
		}
		return map;
	}
}
