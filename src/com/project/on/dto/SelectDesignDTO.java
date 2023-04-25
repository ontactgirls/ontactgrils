package com.project.on.dto;

import java.util.Map;

import com.project.on.productOptDB.ProductOptDB;

public class SelectDesignDTO {
	private int[] stdDTO;
	private ProductOptDB pdOptDB;
	
	//기본생성자
	//public SelectedDesignDTO() {}
	
	//매개변수 생성자
	public SelectDesignDTO(int[] stdDTO, ProductOptDB pdOptDB) {
		System.out.println("optMap : " + pdOptDB.toString());
		System.out.println("optMap : " + pdOptDB.getClass());
		this.stdDTO = stdDTO;
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
			System.out.print(optMap.get(key)[stdDTO[i]] + "\t");
		}
		
		return "";
	}

	//getter setter
	
	public int[] getStdDTO() {
		return stdDTO;
	}

	public void setStdDTO(int[] stdDTO) {
		this.stdDTO = stdDTO;
	}

	public ProductOptDB getPdOptDB() {
		return pdOptDB;
	}

	public void setPdOptDB(ProductOptDB pdOptDB) {
		this.pdOptDB = pdOptDB;
	}

}