package com.on.project.dto;

import java.util.ArrayList;

public class OptionTitleDTO {
	
	private String name; //타이틀명
	private ArrayList<OptionDesignDTO> designList = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<OptionDesignDTO> getDesignList() {
		return designList;
	}
	public void setDesignList(ArrayList<OptionDesignDTO> designList) {
		this.designList = designList;
	}
}
