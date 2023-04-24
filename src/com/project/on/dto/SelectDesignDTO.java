package com.project.on.dto;

import java.util.Map;

public class SelectDesignDTO {
	private int[] stdDTO;
	
	private Map< String, String[] > optMap;
	
	//기본생성자
	//public SelectedDesignDTO() {}
	
	//매개변수 생성자
	public SelectDesignDTO(int[] stdDTO, Map< String, String[] > optMap) {
		this.stdDTO = stdDTO;
		this.optMap = optMap;
	}
	
	@Override
	public String toString() {
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

	public Map<String, String[]> getOptMap() {
		return optMap;
	}

	public void setOptMap(Map<String, String[]> optMap) {
		this.optMap = optMap;
	}
	
}