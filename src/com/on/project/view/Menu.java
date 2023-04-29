package com.on.project.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.on.project.controller.MenuManager;
import com.on.project.database.ProductDB;
import com.on.project.dto.OptionDTO;
import com.on.project.dto.ProductDTO;
import com.on.project.dto.StyleDTO;

public class Menu {
	Scanner sc = new Scanner(System.in);
	ProductDB db = new ProductDB();
	MenuManager mm = new MenuManager();
	Menu m;
	ProductDTO productData;
	String errMsg = "없는 메뉴 입니다.";
	
	public void mainMenu(Menu m) {
		this.m = m;
		String[] texts = 
			{
					"1. 관리자",
					"2. 고객-맞춤제작"
			};
		int click = 0;
		
		while(true) {
			for(String text : texts) {
				System.out.println(text);
			}

			System.out.print("메뉴를 선택하세요 : ");
			click = sc.nextInt();
			
			// 메뉴의 입력이 정상 범주다.
			if (click > 0 && click <= texts.length) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		
		
		switch(click) {
			case 1:
				adminMenu();
				break;
			case 2: 
				clientMenu();
				break;			
		}
	} // mainMenu()
	
	private void adminMenu() {
		System.out.println("까꿍");
	} // adminMenu()
	
	private void clientMenu() {

		// 존재하는 모든 제품을 사용자에게 메뉴로 보여준다.

		int click = 0;
		int seq = 0;

		while(true) {

			for(ProductDTO p : db.getProductList()) {
				System.out.println(++seq + ". " + p.getName());
			}
			
			System.out.print("원하시는 제품을 선택해주세요 : ");
			click = sc.nextInt();
			
			// 메뉴 입력이 정상 범위이다.
			if (click > 0 && click <= db.getProductList().size()) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		
		productData = db.getProductList().get(click-1);

		m.designSelectMenu(productData);

	} // clientMenu()
	
	
	private void designSelectMenu(ProductDTO productData) {
		
		int click = 0;
		ArrayList<ProductDTO> productList = mm.randomDesignProductList(productData);
		
		while(true) {
			int seq = 0;
			for(ProductDTO p : productList) {
				
				System.out.println("\t" + ++seq + ". 추천디자인 선택하기");
				System.out.print("\t\t");
				mm.printDesign(p.getOptionList());
			}
			System.out.println("\t" + ++seq + ". ALL 커스텀 선택하기");

			System.out.print("\n------------- 메뉴를 선택해주세요 : ");
			click = sc.nextInt();
			
			if (click > 0 && click <= seq) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}

		switch(click) {
			case 1 :
			case 2 :
			case 3 :
				
				m.orderPageMenu(productList.get(click-1));
				productList = null;
				break;
			case 4 : 
				m.customPageMenu(null);

		}
		

	} // designSelectMenu()
	
	private void orderPageMenu(ProductDTO product) {
		System.out.println("아래 디자인으로 주문하시겠습니까?");
		System.out.print("\t");
		mm.printDesign(product.getOptionList());
		
		int seq = 0;
		int click = 0;
		while(true) {
			click = 0;
			System.out.println("\t" + ++seq + ". 주문하기");
			System.out.println("\t" + ++seq + ". 디자인 수정 하기");
			
			System.out.print("메뉴를 선택해주세요 : ");
			click = sc.nextInt();
			
			if(click > 0 && click <= seq) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		
		switch(click) {
			case 1:
				System.out.println("주문해주셔서 감사합니다.");
				break;
			case 2:
				m.customPageMenu(product);
			
		}
	} // orderPageMenu()
	
	private void customPageMenu(ProductDTO product) {
		if(product == null) {
			product = mm.getProductStructure(productData);
//			System.out.println(product);
			
			System.out.println(product.getName() + " 제품 커스텀 하기");
			
			for(int i = 0; i < product.getOptionList().size(); i++) {
				customOptionStyle(product, i);
			}
//			System.out.println(product);
			m.orderPageMenu(product);
		} else {
			while(true) {
				System.out.println(product.getName() + " 제품의 디자인 정보");
				System.out.print("\t");
				mm.printDesign(product.getOptionList());
				
				int click = 0;
				while(true) {
					click = -1;
					System.out.println("옵션 리스트(수정을 종료하려면 0번을 입력하세요)");
					int seq = 0;
					for(OptionDTO o : productData.getOptionList()) {
						System.out.println("\t" + ++seq + ". " + o.getName());
					}

					System.out.print("수정할 옵션을 선택하세요 : ");
					click = sc.nextInt();
					
					if(click >= 0 && click <= seq) {
						break;
					} else {
						System.out.println(errMsg);
					}
				}
				if(click == 0) {
					break;
				}
				
				m.customOptionStyle(product, click-1);
				
				System.out.println("수정되었습니다.");
				
			} // while
			
			orderPageMenu(product);
		}
	}
	
	private void customOptionStyle(ProductDTO product, int index) {
		OptionDTO optionData = productData.getOptionList().get(index);
		int click = 0;
		while(true) {
			click = 0;
			System.out.println(optionData.getName() + " 옵션의 스타일 리스트");
			int seq = 0;
			for(StyleDTO s : optionData.getStyleList()) {
				System.out.println("\t" + ++seq + ". " + s.getName());
			}
			System.out.print("스타일을 선택하세요 : ");
			click = sc.nextInt();
			
			if(click > 0 && click <= seq) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		String styleName = optionData.getStyleList().get(click-1).getName();
		int stylePrice = optionData.getStyleList().get(click-1).getPrice();
		product.getOptionList().get(index).getStyleList().get(0).setName(styleName);
		product.getOptionList().get(index).getStyleList().get(0).setPrice(stylePrice);

	}
}