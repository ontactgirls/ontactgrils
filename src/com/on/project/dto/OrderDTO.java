package com.on.project.dto;

import com.on.product.dto.ProductDTO;

public class OrderDTO {
	private String name; // 고객 이름
	private String phone; // 핸드폰 번호
	private String address; // 배송받을 주소
	private ProductDTO orderProduct; // 고객이 주문한 제품 정보
	
	// 매개변수 생성자
	public OrderDTO(String name, String phone, String address, ProductDTO orderProduct) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.orderProduct = orderProduct;
	}
	
}
