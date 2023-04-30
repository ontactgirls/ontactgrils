package com.on.project.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.on.product.dto.OptionDTO;
import com.on.product.dto.ProductDTO;
import com.on.product.dto.StyleDTO;
import com.on.project.controller.MenuManager;
import com.on.project.dto.OrderDTO;

public class Menu {
	Scanner sc = new Scanner(System.in);
	MenuManager mm = new MenuManager();
	String errMsg = "잘못된 입력입니다.";
	
	public void mainMenu() {
		while(true) {
			String[] texts = 
				{
						"1. 관리자메뉴"
				      , "2. 맞춤제작하기"
					  , "3. 프로그램 종료"
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
				case 3:
					return;
			}
		}
	} // mainMenu()
	
	private void adminMenu() {
		String[] texts = 
			{
					"1. 주문 현황 보기"
				  , "2, 전체 제품 정보 보기"
				  ,	"3, 제품 추가"
			      , "4. 옵션 추가"
				  , "5, 스타일 추가"
				  , "6. 제품 삭제"
				  , "7. 옵션 삭제"
				  , "8. 스타일 삭제"

			};
		int click = 0;
		while(true) {

			for(String text : texts) {
				System.out.println(text);
			}
			
			System.out.print("메뉴를 선택하세요 : ");
			click = sc.nextInt();
			
			if(click > 0 && click <= texts.length) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		sc.nextLine();
		
		OptionDTO optionData;
		switch(click) {
			case 1: // 주문현황
				if (mm.getOrderList() == null) {
					System.out.println("주문 목록이 없습니다.");					
				} else {
					System.out.println("--------------------------------------------------------------");
					for(OrderDTO order : mm.getOrderList()) {
						order.toString();
					}
				}
				break;

			case 2: // 전체 제품 보기
				System.out.println(mm.getDB());
				break;
			case 3: // 제품추가
				addProductInput();
				break;
			case 4: // 옵션추가
				addOptionInput(mm.getDB().getProductList().get(clickProduct()));
				break;
			case 5: // 스타일추가
				mm.setProductData(mm.getDB().getProductList().get(clickProduct()));
				optionData = mm.getProductData().getOptionList().get(clickOption()); 
				addStyleInput(optionData);
				break;
			case 6: // 제품삭제
				mm.deleteInDB(clickProduct());
				break;
			case 7: // 옵션삭제
				
				mm.setProductData(mm.getDB().getProductList().get(clickProduct()));
				mm.deleteInDB(mm.getProductData(), clickOption());
				break;
			case 8: // 스타일삭제
				mm.setProductData(mm.getDB().getProductList().get(clickProduct()));
				optionData = mm.getProductData().getOptionList().get(clickOption());
				mm.deleteInDB(optionData, clickStyle(optionData));
				break;
		} // switch
		

	} // adminMenu()
	
	private void addProductInput() {
		while(true) { 
			String name = "";
			while(name.equals("")) {
				System.out.print("제품이름을 입력하세요 : ");
				name = sc.nextLine();
			}
	
			ProductDTO np = mm.addInDB(name);
			if(np == null) {
				System.out.println("중복된 제품입니다.");
			} else {
				addOptionInput(np);
				break;
			}
		}
	}
	private void addOptionInput(ProductDTO p) {
		
		int click = 1;
		while(click == 1) {
			
			click = 0;
			
			while(true) {
				String name = "";
				while(name.equals("")) {
					System.out.print("옵션이름을 입력하세요 : ");
					name = sc.nextLine();
				}
	
				OptionDTO no = mm.addInDB(p, name);
				
				if(no == null) {
					System.out.println("중복된 옵션입니다.");
				} else {
					addStyleInput(no);
					break;
				}
			}

			System.out.print("0. 종료하기 / 1. 옵션 계속 추가 : ");
			click = sc.nextInt();
			sc.nextLine();
		}
	}
	
	private void addStyleInput(OptionDTO o) {

		int click = 1;
		
		while(click == 1) {
			click = 0;
			
			while(true) {
				String name = "";
				int price = 0;
				while(name.equals("")) {
					System.out.print("스타일 이름 : ");
					name = sc.nextLine();
				}
				
				while(price < 1) {
					System.out.print("스타일 가격 : ");
					price = sc.nextInt();
					sc.nextLine();
				}
	
				StyleDTO ns = mm.addInDB(o, name, price);
				
				if(ns == null) {
					System.out.println("중복된 스타일입니다.");
				} else {
					break;
				}
			}
			
			System.out.print("0. 종료하기 / 1. 스타일 계속 추가 : ");
			click = sc.nextInt();
			sc.nextLine();
		}
	}
	
	private void clientMenu() {

		int click = clickProduct();

		mm.setProductData(mm.getDB().getProductList().get(click));
		
		designSelectMenu();

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
		int sum = 0;
		for(OptionDTO o : product.getOptionList()) {
			for(StyleDTO s : o.getStyleList()) {
				sum += s.getPrice();
			}
		}

		int click = 0;
		while(true) {
			click = 0;
			int seq = 0;
			System.out.println("아래 디자인으로 (" + product.getName() + ") 제품을 주문하시겠습니까?");
			System.out.print("\t");
			mm.printDesign(product.getOptionList());
			
			System.out.println("\t제품의 가격은 " + sum + "원 입니다.");
			
			System.out.println("\t" + ++seq + ". 주문하기");
			System.out.println("\t" + ++seq + ". 디자인 수정 하기");
			System.out.println("\t" + ++seq + ". 주문취소");
			
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
				Calendar cal = Calendar.getInstance();
				OrderDTO orderInfo = orderInput();
				orderInfo.setProduct(product);
				orderInfo.setSum(sum);
				orderInfo.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
				mm.addOrderList(orderInfo);
				cal.add(cal.DATE, 7);
				System.out.print("주문하신 제품은 ");
				System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
				System.out.println(" 에 배송될 예정입니다.");
				System.out.println("주문해주셔서 감사합니다.");
				break;
			case 2:
				customOptionMenu(product);
				break;
			case 3:
				return;
		}
	} // orderPageMenu()
	

	private OrderDTO orderInput() {
		LinkedHashMap<String, String> input = new LinkedHashMap<>();

		int click = 0;
		
		while(click != 1) {
			click = 0;
			sc.nextLine(); // 버퍼 비움
			input.put("이름", "");
			input.put("핸드폰 번호", "");
			input.put("배송받을 주소", "");
			
			System.out.println("배송 정보를 입력해주세요.");
			
			for(String key : input.keySet()) {
				while(input.get(key).equals("")) {
					System.out.print(key + " : ");
					input.put(key, sc.nextLine());
				}
			}
			
			System.out.println("입력하신 정보를 확인해주세요.");
			for(String key : input.keySet()) {
				System.out.println(key + " : " + input.get(key));
			}
			
			while(click < 1 || click > 2) {
				System.out.println("1. 주문하기 / 2. 배송정보 수정하기");
				System.out.print("메뉴를 선택하세요 : ");
				click = sc.nextInt();
			}
		}
		
		return new OrderDTO( input.get("이름")
				  	       , input.get("핸드폰 번호")
						   , input.get("배송받을 주소")
						   );

	}
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
			int click = 1;
			while(click == 1) {
				System.out.println(product.getName() + " 제품의 디자인 정보");
				System.out.print("\t");
				mm.printDesign(product.getOptionList());
				
				System.out.println("옵션 리스트");
				customStyleMenu(product, clickOption());
				System.out.println("수정되었습니다.");
				
				System.out.print("0. 수정 종료 / 1. 수정 계속 : ");
				click = sc.nextInt();
				sc.nextLine();
			}
		}
		
		orderPageMenu(product);

	}
	
	private void customStyleMenu(ProductDTO product, int optionId) {
		
		OptionDTO optionData = mm.getProductData().getOptionList().get(optionId);
		System.out.println(optionData.getName() + " 옵션의 스타일 리스트");
		mm.modifyStyle(product, optionId, clickStyle(optionData));
	}
	
	private int clickProduct() {
		int click = 0;
		while(true) {
			click = 0;
			int seq = 0;
			for(ProductDTO p : mm.getDB().getProductList()) {
				System.out.println(++seq + ". " + p.getName());
			}
			
			System.out.print("제품을 선택해주세요 : ");
			click = sc.nextInt();
			sc.nextLine();
			
			// 메뉴 입력이 정상 범위이다.
			if (click > 0 && click <= mm.getDB().getProductList().size()) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		return click-1;
	}
	
	private int clickOption() {
		int click = 0;
		while(true) {
			click = 0;
			int seq = 0;
			for(OptionDTO o : mm.getProductData().getOptionList()) {
				System.out.println("\t" + ++seq + ". " + o.getName());
			}
	
			System.out.print("옵션을 선택하세요 : ");
			click = sc.nextInt();
			sc.nextLine();
			
			if(click > 0 && click <= seq) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		return click-1;
	}
	
	
	private int clickStyle(OptionDTO optionData) {
		int click = 0;
		while(true) {
			click = 0;
			int seq = 0;
			for(StyleDTO s : optionData.getStyleList()) {
				System.out.println("\t" + ++seq + ". " + s.getName());
			}
			System.out.print("스타일을 선택하세요 : ");
			click = sc.nextInt();
			sc.nextLine();
			if(click > 0 && click <= seq) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		return click-1;
	}
}
