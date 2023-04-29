package com.on.project.dto;

public class StyleDTO {
	
	String name;
	int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "(" + name + ", " + price + ")";
//		return "StyleDTO [name=" + name + ", price=" + price + "]";
	}
	
	
}
