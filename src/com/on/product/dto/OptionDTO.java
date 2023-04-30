package com.on.product.dto;

import java.util.ArrayList;

public class OptionDTO {
	
	private String name; //옵션 이름
	private ArrayList<StyleDTO> styleList = new ArrayList<>(); // 옵션의 스타일 리스트
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<StyleDTO> getStyleList() {
		return styleList;
	}
	@Override
	public String toString() {
		return "(" + name + styleList + ")";
//		return "OptionDTO [name=" + name + ", styleList=" + styleList + "]";
	}
	
	
}
