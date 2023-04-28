package com.on.project.dto;

import java.util.ArrayList;

public class ProductDTO {

	private String name; // 제품명
	private ArrayList<OptionTitleDTO> titleList; // 타이틀 리스트
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<OptionTitleDTO> getTitleList() {
		return titleList;
	}
	public void setTitleList(ArrayList<OptionTitleDTO> titleList) {
		this.titleList = titleList;
	}
}