package com.on.project.dto;

import com.on.product.dto.ProductDTO;

public class OrderDTO {
	private String name; // 고객 이름
	private String phone; // 핸드폰 번호
	private String address; // 배송받을 주소
	private ProductDTO product; // 고객이 주문한 제품 정보
	private int sum; // 주문한 제품 가격
	
	// 매개변수 생성자
	public OrderDTO(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	

}
