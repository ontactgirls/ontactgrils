package com.project.on.productDB;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ProductOptDB_backup {
//	순서가 유지되는 LinkedHashMap 사용함
	protected Map< String, String[] > optMap = new LinkedHashMap<>();
	
	// 자식이 아닌 경우 객체 생성 못하도록 하기 위함.
	protected ProductOptDB_backup() {}
	
	public Map getOptMap() {
		return optMap;
	}
	
	
	// 테스트를 위한 샘플 초이스 디자인 정보
	public int[] getSampleDesign() {
		int optMapSize = optMap.size();
		int[] sampleDesign = new int[optMapSize];
		for(int i = 0; i < optMapSize; i++) { // 옵션 타이틀 개수
			// 랜덤 값은 0부터 시작하기 때문에 -1로 초기화
			int ranNum = -1;
			// key 값 = 옵션 타이틀 (ex : 카라, 주머니, 소매 등) 
			String key = (String) optMap.keySet().toArray()[i];
			
			// 옵션 타이틀의 종류만큼 random() 생성 (ex : 카라 > 굴림, 사각, 육각 등)
			sampleDesign[i] = (int)(java.lang.Math.random()
									* optMap.get(key).length);
			
//			System.out.println("sampleDesign[" + i + "]" + sampleDesign[i]);
//			System.out.println("optMap : " + optMap.get(key).length);
			
		}
		return sampleDesign;
	}
}