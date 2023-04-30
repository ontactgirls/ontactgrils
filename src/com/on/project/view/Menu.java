package com.on.project.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.on.product.database.ProductDB;
import com.on.product.dto.OptionDTO;
import com.on.product.dto.ProductDTO;
import com.on.product.dto.StyleDTO;
import com.on.project.controller.MenuManager;

public class Menu {
	Scanner sc = new Scanner(System.in);
	MenuManager mm = new MenuManager();
	ProductDB db = new ProductDB();
	
	String errMsg = "없는 메뉴 입니다.";
	
	public void mainMenu() {
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
		
		mm.setProductData(db.getProductList().get(click-1));
		
		designSelectMenu();
		
		System.out.println("clientMenu 종료");

	} // clientMenu()
	
	
	private void designSelectMenu() {
		
		int click = 0;
		ArrayList<ProductDTO> productList = mm.randomDesignProductList();
		
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
				
				orderPageMenu(productList.get(click-1));
				productList = null;
				break;
			case 4 : 
				customOptionMenu(null);

		}
		

	} // designSelectMenu()
	
	private void orderPageMenu(ProductDTO product) {
		System.out.println("아래 디자인으로 (" + product.getName() + ") 제품을 주문하시겠습니까?");
		System.out.print("\t");
		mm.printDesign(product.getOptionList());
		
		int seq = 0;
		int click = 0;
		while(true) {
			click = 0;
			System.out.println("\t" + ++seq + ". 주문하기");
			System.out.println("\t" + ++seq + ". 디자인 수정 하기");
			System.out.println("\t" + ++seq + ". 프로그램 종료 하기");
			
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
				customOptionMenu(product);
				break;
			case 3:
				return;
		}
	} // orderPageMenu()
	
	
//	private void inputOrde
	
	
	private void customOptionMenu(ProductDTO product) {
		if(product == null) {
			product = mm.getProductStructure();
//			System.out.println(product);
			
			System.out.println(product.getName() + " 제품 커스텀 하기");
			
			for(int i = 0; i < product.getOptionList().size(); i++) {
				customStyleMenu(product, i);
			}
//			System.out.println(product);
			
		} else {
			while(true) {
				System.out.println(product.getName() + " 제품의 디자인 정보");
				System.out.print("\t");
				mm.printDesign(product.getOptionList());
				
				int click = 0;
				while(true) {
					click = -1;
					System.out.println("옵션 리스트\n(수정을 종료하려면 0번을 입력하세요)");
					int seq = 0;
					for(OptionDTO o : mm.getProductData().getOptionList()) {
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

				customStyleMenu(product, click-1);
				
				System.out.println("수정되었습니다.");
				
			} // while
			
		}
		
		orderPageMenu(product);

	}
	
	private void customStyleMenu(ProductDTO product, int optionId) {
		
		OptionDTO optionData = mm.getProductData().getOptionList().get(optionId);
		
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

		mm.modifyStyle(product, optionId, click-1);
	}
}