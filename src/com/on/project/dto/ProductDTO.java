package com.on.project.dto;

import java.util.ArrayList;

public class ProductDTO {

	private String name; // 제품명
	private ArrayList<OptionDTO> optionList = new ArrayList<>(); // 제품의 옵션 리스트

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<OptionDTO> getOptionList() {
		return optionList;
	}
	
	@Override
	public String toString() {
		
		int i = 0;
		for(OptionDTO o : optionList) {
			System.out.print(o.getName() + " : ");
			
			for(StyleDTO s : o.getStyleList()) {
				System.out.print(s.getName());
			}
			
			i++;
			
			if(i % 3 == 0) {
				System.out.println();
			}
		}
				
		return "";
		
//		return "ProductDTO [name=" + name + ", optionList=" + optionList + "]";
	}
	

}