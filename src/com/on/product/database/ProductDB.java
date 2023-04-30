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
		
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("카라"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]
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
				
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("소매"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("1버튼 굴림"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(2000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("2버튼 굴림");
				style.setPrice(2500);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("1버튼 육각");
				style.setPrice(2500);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("2버튼 육각");
				style.setPrice(3000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("독일식");
				style.setPrice(3000);
				
			// [옵션]
			product.getOptionList().add(new OptionDTO());
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("주머니 위치"); // OptionDTO 의 필드에 값을 할당한다.
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("왼쪽"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(1000);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("오른쪽");
				style.setPrice(500);
				
			// [옵션]
			product.getOptionList().add(new OptionDTO());
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("주머니 종류"); // OptionDTO 의 필드에 값을 할당한다.
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("굴림주머니"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(1500);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("사각주머니");
				style.setPrice(1000);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("육각주머니");
				style.setPrice(2000);
				
			// [옵션]
			product.getOptionList().add(new OptionDTO());
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("요크"); // OptionDTO 의 필드에 값을 할당한다.
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("일반요크"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(500);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("맞주름");
				style.setPrice(1000);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("양쪽주름");
				style.setPrice(1500);
				
		// [제품] 1 : 바지
		productList.add(new ProductDTO());
		product = productList.get(productList.size()-1); // new ProductDTO()의 인스턴스 주소값
		product.setName("바지"); // ProductDTO()의 필드변수에 값을 할당한다.
		
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("너비"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]
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
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("길이"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("반바지"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(3000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("긴바지");
				style.setPrice(4000);
				
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("벨트비조"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("일반"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(1500);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("더블");
				style.setPrice(2000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("벨트고리없음");
				style.setPrice(0);
				
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("밑단"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("일반"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(2000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("롤업");
				style.setPrice(5000);
				
				
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("앞주머니"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("일반주머니"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(3000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("사선주머니");
				style.setPrice(5000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("굴림주머니");
				style.setPrice(8000);
				
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("바지주름"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("노턱"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(1000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("1턱");
				style.setPrice(2000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("2턱");
				style.setPrice(3000);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("다트");
				style.setPrice(5000);
				
				
		// [제품] 2 : 티셔츠
		productList.add(new ProductDTO());
		product = productList.get(productList.size()-1); // new ProductDTO()의 인스턴스 주소값
		product.setName("티셔츠"); // ProductDTO()의 필드변수에 값을 할당한다.
		
			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("원단두께"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("얇음"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(1500);
				
				option.getStyleList().add(new StyleDTO());
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("두꺼움");
				style.setPrice(2000);

			// [옵션]
			product.getOptionList().add(new OptionDTO()); 
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("기장"); // OptionDTO 의 필드에 값을 할당한다.
			
				// [옵션의 스타일]
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
				
			product.getOptionList().add(new OptionDTO());
			option = product.getOptionList().get(product.getOptionList().size()-1); // new OptionDTO()의 인스턴스 주소값
			option.setName("원단"); // OptionDTO 의 필드에 값을 할당한다.
				// [옵션의 스타일]
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1); // new StyleDTO()의 인스턴스 주소값
				style.setName("실크"); // StyleDTO 의 필드에 값을 할당한다.
				style.setPrice(25000);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("뱀부");
				style.setPrice(30000);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("레이온");
				style.setPrice(10000);
				
				option.getStyleList().add(new StyleDTO()); 
				style = option.getStyleList().get(option.getStyleList().size()-1);
				style.setName("린넨");
				style.setPrice(8000);
		
				

//		사용자에게 입력받아서 특정한 값에 접근하다고 가정하고 테스트
//		int productID = 1;
//		int titleID = 0;
//		int designID = 0;
		
//		System.out.println("productList.get(productID)" + productList.get(productID));
//		System.out.println(productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID).getName());
//		System.out.println(productList.get(productID).getTitleList().get(titleID).getDesignList().get(designID).getPrice());
		
		
//		사용자에게 입력받아서 특정한 값을 추가한다고 가정하고 테스트
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
		System.out.println("\t------------------------------------------------");
		for(ProductDTO p : productList) {
			System.out.println("\t제품 : " + p.getName());
			
			for(OptionDTO o : p.getOptionList()) {
				System.out.println("\t  ㄴ " + o.getName());
				System.out.print("\t      ㄴ ");
				
				for(StyleDTO s : o.getStyleList()) {
					System.out.print(s.getName() + " : " + s.getPrice() + "원\t");
				}
				System.out.println();
			}
			System.out.println("\t------------------------------------------------");
		}

		return "";
	}


	// getter / setter
	public ArrayList<ProductDTO> getProductList() {
		return productList;
	}
}