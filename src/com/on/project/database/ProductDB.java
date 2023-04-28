package com.on.project.database;

import java.util.ArrayList;

import com.on.project.dto.OptionDesignDTO;
import com.on.project.dto.OptionTitleDTO;
import com.on.project.dto.ProductDTO;

public class ProductDB {
	
	public ProductDB() {
		
		ArrayList<ProductDTO> productList = new ArrayList<>();
		ProductDTO product;
		OptionTitleDTO title;
		OptionDesignDTO design;
		
		productList.add(new ProductDTO()); // [제품] 0 : 셔츠   1 : 바지   2 : 티셔츠
		product = productList.get(productList.size()-1); // new ProductDTO()의 인스턴스 주소값
		product.setName("셔츠"); // ProductDTO()의 필드변수에 값을 할당한다.
		product.setTitleList(new ArrayList<>());
		
			product.getTitleList().add(new OptionTitleDTO()); // [옵션 타이틀] 0 : 카라   1 : 소매  2: 주머니
			title = product.getTitleList().get(product.getTitleList().size()-1); // new TitleDTO()의 인스턴스 주소값
			title.setName("카라"); // TitleDTO()의 필드변수에 값을 할당한다.
			title.setDesignList(new ArrayList<>());
			
			
				title.getDesignList().add(new OptionDesignDTO()); // [옵션 디자인] 0 : 숏카라  1 : 롱카라  2 : 하프카라 
				design = title.getDesignList().get(title.getDesignList().size()-1); // new DesignDTO()의 인스턴스 주소값
				design.setName("숏카라"); // DesignDTO()의 필드변수에 값을 할당한다.
				design.setPrice(2000);
				
				title.getDesignList().add(new OptionDesignDTO());
				design = title.getDesignList().get(title.getDesignList().size()-1);
				design.setName("롱카라");
				design.setPrice(1500);
				
				title.getDesignList().add(new OptionDesignDTO());
				design = title.getDesignList().get(title.getDesignList().size()-1);
				design.setName("하프카라");
				design.setPrice(1000);
				
			product.getTitleList().add(new OptionTitleDTO());
			title = product.getTitleList().get(product.getTitleList().size()-1);
			title.setName("주머니");
			title.setDesignList(new ArrayList<>());
				
				title.getDesignList().add(new OptionDesignDTO());
				design = title.getDesignList().get(title.getDesignList().size()-1);
				design.setName("왼쪽");
				design.setPrice(1000);
				
				title.getDesignList().add(new OptionDesignDTO());
				design = title.getDesignList().get(title.getDesignList().size()-1);
				design.setName("오른쪽");
				design.setPrice(500);
				
		
		productList.add(new ProductDTO());
		product = productList.get(productList.size()-1);
		product.setName("바지");
		product.setTitleList(new ArrayList<>());
		
			product.getTitleList().add(new OptionTitleDTO());
			title = product.getTitleList().get(product.getTitleList().size()-1);
			title.setName("밑단");
			title.setDesignList(new ArrayList<>());
				
				title.getDesignList().add(new OptionDesignDTO());
				design = title.getDesignList().get(title.getDesignList().size()-1);
				design.setName("넓게");
				design.setPrice(1000);
				
				title.getDesignList().add(new OptionDesignDTO());
				design = title.getDesignList().get(title.getDesignList().size()-1);
				design.setName("좁게");
				design.setPrice(1500);
				

		// 사용자에게 입력받아서 특정한 값에 접근하다고 가정
		int productID = 1;
		int titleID = 0;
		int designID = 0;
		
		System.out.println("productList.get(productID)" + productList.get(productID));
		
		System.out.println(productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID).getName());
		System.out.println(productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID).getPrice());
		
		
//		// 사용자에게 입력받아서 특정한 값을 추가한다고 가정
//		
//		productID = 0;
//		titleID = 0;
//		designID = 0;
//		productList.get(productID).getTitleList().get(titleID).getDesignList().add(new OptionDesignDTO());
//		designID = productList.get(productID).getTitleList().get(titleID).getDesignList().size()-1;
//		design = productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID);
//		design.setName("테스트입니다");
//		design.setPrice(10000);
//		
//		productID = 0;
//		titleID = 0;
//		designID = 3;
//		
//		System.out.println(productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID).getName());
//		System.out.println(productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID).getPrice());
	}
}