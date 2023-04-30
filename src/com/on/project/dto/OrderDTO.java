package com.on.project.dto;

import com.on.product.dto.ProductDTO;

public class OrderDTO {
	private String name; // 고객 이름
	private String phone; // 핸드폰 번호
	private String address; // 배송받을 주소
	private ProductDTO product; // 고객이 주문한 제품 정보
	private int sum; // 주문한 제품 가격
	private String orderDate; // 주문일자
	
	// 매개변수 생성자
	public OrderDTO(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	
	
	
	@Override
	public String toString() {
		System.out.println("이름 : " + name + ", 핸드폰 : " + phone + ", 주문일자 : " + orderDate);
		System.out.println("제품명 : " + product.getName() + ", 제품가격 : " + sum);
		System.out.println("배송주소 : " + address); 
		System.out.println("\t[" + product.getName() + " 디자인 정보 ] ");
		System.out.println(product);
		System.out.println("--------------------------------------------------------------");
		return "";
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

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

}
