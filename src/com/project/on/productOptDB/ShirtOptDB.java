package com.project.on.productOptDB;

import java.util.ArrayList;

public class ShirtOptDB extends ProductOptDB {
	//생성자
	public ShirtOptDB() {
		optMap.put("카라", new String[] {"롱", "숏", "하프"});
		ArrayList<String> sarr = new ArrayList<>();
//		sarr.add("롱");
//		sarr.add("숏");
//		sarr.add("하프");
//		optMap.put("카라", sarr);

		optMap.put("소매", new String[] {"굴림"});
		optMap.put("주머니", new String[] {"왼쪽", "dddd"});
		optMap.put("앞단", new String[] {"테스트1,d,d,d,d,d"});
		optMap.put("뒷판", new String[] {"홍길동"});
		optMap.put("기장", new String[] {"유관순"});
	}
}