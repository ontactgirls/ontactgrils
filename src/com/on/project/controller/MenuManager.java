package com.on.project.controller;

import java.util.ArrayList;

import com.on.product.dto.OptionDTO;
import com.on.product.dto.ProductDTO;
import com.on.product.dto.StyleDTO;

public class MenuManager {
	
	ProductDTO productData;
	
	public ArrayList<ProductDTO> randomDesignProductList() {
		System.out.println(productData.getName());

		int createNum = 3; // 추천디자인 생성 개수
		int optionListSize = productData.getOptionList().size();
		
		// 생성된 추천 디자인을 담을 리스트
		ArrayList<ProductDTO> randomDesignProductList = new ArrayList<>();
		// 추천 디자인을 담기 위한 틀 생성
		while(true) {
			ProductDTO productStructure = getProductStructure();
			randomDesignProductList.add(productStructure);
			
			if(randomDesignProductList.size() == createNum) {
				break;
			}
		}
		
//		for(ProductDTO p : randomDesignProductList) {
//			System.out.println(p);
//		}

		int equalNum = 0; //중복값 개수
		// 랜덤값을 생성해서 추천디자인을 만든다.
		for(int i = 0; i < createNum; i++) { // 생성할 추천디자인의 개수 만큼 for i
			
			// 추천 디자인을 생성한다
			for(int j = 0; j < optionListSize; j++) { // 옵션의 개수 만큼 for j
				// 랜덤 값은 0부터 시작하 때문에 식별성을 위해서 -1로 초기화 했음
				int randomNum = -1;

				// 옵션의 스타일 종류만큼 random() 생성
				// (ex : 카라 옵션의 스타일 종류는 > 숏카라, 롱카라)
				// (ex : 주머니 옵션의 스타일 종류는 > 왼쪽, 오른쪽, 없음)
				OptionDTO option = productData.getOptionList().get(j);
				randomNum = (int)(java.lang.Math.random()
									* option.getStyleList().size());
				
				StyleDTO style = option.getStyleList().get(randomNum);
				StyleDTO randomStyle = randomDesignProductList.get(i)
										.getOptionList().get(j)
										.getStyleList().get(0);
				randomStyle.setName(style.getName());
				randomStyle.setPrice(style.getPrice());
				
//				스타일이 null에서 랜덤 값으로 할당 됨
//				productName = 셔츠
//					[optionName = 카라 [styleName = null, stylePrice = 0],
//					optionName = 주머니 [styleName = null, stylePrice = 0]]
//
//				productName = 셔츠
//					[optionName = 카라[styleName = 하프카라, stylePrice = 1000],
//					optionName = 주머니[styleName = 왼쪽, stylePrice = 1000]]
			} // for j 추천 디자인 생성 부분
//			
//			// 생성된 추천 디자인을 중복체크 한다
			for(int j = 0; j < i; j++) { // 현재 디자인 i 와 앞에 생성된 디자인들 j를 비교함.
				equalNum = 0;
				
				ProductDTO rp = randomDesignProductList.get(i); 
				ProductDTO rpPrev = randomDesignProductList.get(j);

				for(int k = 0; k < optionListSize; k++) { // 옵션 개수 만큼 for k
					StyleDTO rs = rp.getOptionList().get(k).getStyleList().get(0);
					StyleDTO rsPrev = rpPrev.getOptionList().get(k).getStyleList().get(0);
					
					// 옵션의 스타일 값이 같으면 equalNum을 1 증가시킨다.
					if(rs.getName().equals(rsPrev.getName())) {
						equalNum++;
					}
				} //for k
				
//				System.out.println("equalNum : " + equalNum);
				// 제품의 옵션 개수와 중복된 옵션 개수가 같다는건 생성된 디자인이 동일하다는 뜻이다.
				if(equalNum == optionListSize) {
					i--; // 추천 디자인을 다시 생성해야 하기 때문에 i--
					
//					System.out.println("중복입니다");
//					System.out.println("rp : " + rp);
//					System.out.println("rpPrev : " + rpPrev);
					
//					중복일 경우 데이터 예시
//					rp : (셔츠[(카라[(롱카라, 1500)]), (주머니[(오른쪽, 500)])])
//					rpPrev : (셔츠[(카라[(롱카라, 1500)]), (주머니[(오른쪽, 500)])])
				}
			} // for j 중복체크 부분
		} //for i

//		for(ProductDTO p : randomDesignProductList) {
//			System.out.println(p);
//		}

		return randomDesignProductList;
	} // randomDesignProductList() 부분
	
	
	
	public ProductDTO getProductStructure() {
		
//		style의 값은 제외하고 아래의 구조로 틀만 만들어진다.
//		style의 값은 랜덤, 또는 사용자가 선택한 값으로 할당되고 수정될 값이다.
//		productName = 셔츠
//				[optionName = 카라
//					[styleName = null, stylePrice = 0],
//				optionName = 주머니
//					[styleName = null, stylePrice = 0]]
		
		ProductDTO p = new ProductDTO();
		p.setName(productData.getName());
		
		// 옵션의 개수 (ex : 카라, 주머니, 소매) 만큼 반복
		for(int i = 0; i < productData.getOptionList().size(); i++) {
			String optionName = productData.getOptionList().get(i).getName();
			p.getOptionList().add(new OptionDTO());
			p.getOptionList().get(i).setName(optionName);
			p.getOptionList().get(i).getStyleList().add(new StyleDTO());
		}
		return p;
	} // getProductStructure() 부분
	
	public void printDesign(ArrayList<OptionDTO> optionList) {
		int i = 0;
		for(OptionDTO o : optionList) {
			System.out.print(o.getName() + " : ");
			
			for(StyleDTO s : o.getStyleList()) {
				System.out.print(s.getName() + "\t");
			}
			i++;
			
			if(i % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public void modifyStyle(ProductDTO product, int optionId, int styleId) {
		OptionDTO optionData = productData.getOptionList().get(optionId);
		OptionDTO option = product.getOptionList().get(optionId);
		
		String styleName = optionData.getStyleList().get(styleId).getName();
		int stylePrice = optionData.getStyleList().get(styleId).getPrice();

		option.getStyleList().get(0).setName(styleName);
		option.getStyleList().get(0).setPrice(stylePrice);

	}


	public ProductDTO getProductData() {
		return productData;
	}

	public void setProductData(ProductDTO productData) {
		this.productData = productData;
	}
	
	
	
} // class
