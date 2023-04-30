package com.on.product.database;

import java.util.ArrayList;

import com.on.product.dto.OptionDTO;
import com.on.product.dto.ProductDTO;
import com.on.product.dto.StyleDTO;


public class ProductDB {
	
	private ArrayList<ProductDTO> productList;

	public ProductDB() { // 기본생성자 시작
		
		ProductDTO product;
		OptionDTO option;
		StyleDTO style;
		productList = new ArrayList<>();
		
		// [제품] 0 : 셔츠
		productList.add(new ProductDTO());
		product = productList.get(productList.size()-1); // new ProductDTO()의 인스턴스 주소값
		product.setName("셔츠"); // ProductDTO()의 필드변수에 값을 할당한다.
		
			// [옵션] 0 : 카라   1 : 소매  2: 주머니
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("카라"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일] 0 : 숏카라  1 : 롱카라  2 : 하프카라
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("숏카라"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(2000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("롱카라");
				style.setPrice(1500);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("하프카라");
				style.setPrice(1000);
				
			// [옵션] 0 : 카라   1 : 소매  2: 주머니
			product.getOptionList().add(new OptionDTO());
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("주머니"); // OptionDTO 의 필드에 값을 할당한다.
				// [옵션의 스타일] 0 : 숏카라  1 : 롱카라  2 : 하프카라
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("왼쪽"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(1000);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("오른쪽");
				style.setPrice(500);
				
		// [제품] 1 : 바지
		productList.add(new ProductDTO());
		product = productList.get(productList.size()-1); // new ProductDTO()의 인스턴스 주소값
		product.setName("바지"); // ProductDTO()의 필드변수에 값을 할당한다.
		
			// [옵션] 0 : 넓이
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("넓이"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일] 0 : 넓게  1 : 좁게
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("보통"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(1500);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("슬림");
				style.setPrice(2000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("와이드");
				style.setPrice(2500);
			// [옵션] 1 : 밑단
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("길이"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일] 0 : 넓게  1 : 좁게
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("반바지"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(3000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("긴바지");
				style.setPrice(4000);
				
		// [제품] 2 : 티셔츠
		productList.add(new ProductDTO());
		product = productList.get(productList.size()-1); // new ProductDTO()의 인스턴스 주소값
		product.setName("티셔츠"); // ProductDTO()의 필드변수에 값을 할당한다.
		
			// [옵션] 0 : 넓이
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("원단두께"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일] 0 : 넓게  1 : 좁게
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("얇음"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(1500);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("두꺼움");
				style.setPrice(2000);

			// [옵션] 1 : 기장
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("기장"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일] 0 : 넓게  1 : 좁게
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("짧게"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(2000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("보통");
				style.setPrice(3000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("길게");
				style.setPrice(4000);
		
				

		// 사용자에게 입력받아서 특정한 값에 접근하다고 가정하고 테스트
		int productID = 1;
		int titleID = 0;
		int designID = 0;
		
//		System.out.println("productList.get(productID)" + productList.get(productID));
//		System.out.println(productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID).getName());
//		System.out.println(productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID).getPrice());
		
		
//		// 사용자에게 입력받아서 특정한 값을 추가한다고 가정하고 테스트
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

	} // 기본생성자 끝

	
	
	
	@Override
	public String toString() {
		
		for(ProductDTO p : productList) {
			System.out.println("제품 : " + p.getName());
			
			for(OptionDTO o : p.getOptionList()) {
				System.out.println("  ㄴ옵션 : " + o.getName());
				
					for(StyleDTO s : o.getStyleList()) {
						System.out.println("    ㄴ스타일 : " + s.getName());
						System.out.println("    ㄴ스타일가격 : " + s.getPrice());
					}
			}
		}

		return "";
	}




	// getter / setter
	public ArrayList<ProductDTO> getProductList() {
		return productList;
	}
}