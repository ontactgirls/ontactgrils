package com.project.on.dto;

import java.util.Map;

import com.project.on.productOptDB.ProductOptDB;

public class SelectDesignDTO {
	private int[] confirmDesign;
	private ProductOptDB pdOptDB;
	
	
	// public SelectDesignDTO() {}
	
	// 매개변수 생성자 : [[ 커스텀하기 ]]를 선택했을 때
	// 커스텀 하기를 누르면 제품 객체 주소 값만 매개변수로 넘어온다.
	// 디자인 정보가 없기 때문에 stdDTO는 null이다.
	public SelectDesignDTO(ProductOptDB pdOptDB) {
//		println으로 찍어보면 null 나옴
//		System.out.println("this.stdDTO : " + this.stdDTO);
		this.pdOptDB = pdOptDB;
	}
	

	
	//매개변수 생성자 : [[ 추천 디자인 ]] 선택했을 때
	public SelectDesignDTO(int[] stdDTO, ProductOptDB pdOptDB) {
		System.out.println("optMap : " + pdOptDB.toString());
		System.out.println("optMap : " + pdOptDB.getClass());
		this.confirmDesign = stdDTO;
		this.pdOptDB = pdOptDB;
	}
	
	@Override
	public String toString() {
		Map< String, String[] > optMap = pdOptDB.getOptMap();
		int optMapSize = optMap.size();
						
		for(int i = 0; i < optMapSize; i++) {
			if(i % 3 == 0) {
				System.out.println();
			}
			String key = (String) optMap.keySet().toArray()[i];
			System.out.print("\t" + key + " : \t");
			System.out.print(optMap.get(key)[confirmDesign[i]] + "\t");
		}
		
		return "";
	}

	//getter setter
	
	public int[] getConfirmDesign() {
		return confirmDesign;
	}

	public void setConfirmDesign(int[] confirmDesign) {
		this.confirmDesign = confirmDesign;
	}

	public ProductOptDB getPdOptDB() {
		return pdOptDB;
	}

	public void setPdOptDB(ProductOptDB pdOptDB) {
		this.pdOptDB = pdOptDB;
	}
}