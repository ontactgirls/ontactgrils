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
		
		System.out.println(
			  "\t ####### #     #    ######  ######  #######       # #######  #####  #######\n" 
			+ "\t #     # ##    #    #     # #     # #     #       # #       #     #    #\n"    
			+ "\t #     # # #   #    #     # #     # #     #       # #       #          #\n"    
			+ "\t #     # #  #  #    ######  ######  #     #       # #####   #          #\n"    
			+ "\t #     # #   # #    #       #   #   #     # #     # #       #          #\n"    
			+ "\t #     # #    ##    #       #    #  #     # #     # #       #     #    #\n"    
			+ "\t ####### #     #    #       #     # #######  #####  #######  #####     #\n"
		);

		
		
		while(true) {
			String[] texts = 
				{
						"\t\t1. 관리자메뉴"
				      , "\t\t2. 맞춤제작하기"
					  , "\t\t3. 프로그램 종료"
				};
			int click = 0;
			
			while(true) {
				for(String text : texts) {
					System.out.println(text);
				}
	
				System.out.print("\n\t\t메뉴를 선택하세요 : ");
				click = sc.nextInt();
				sc.nextLine();
				// 메뉴의 입력이 정상 범주다.
				if (click > 0 && click <= texts.length) {
					break;
				} else {
					System.out.println(errMsg);
				}
			}
			System.out.println();
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
				System.out.println("\t\t" + text);
			}
			
			System.out.print("\n\t\t메뉴를 선택하세요 : ");
			click = sc.nextInt();
			sc.nextLine();
			System.out.println();
			if(click > 0 && click <= texts.length) {
				break;
			} else {
				System.out.println(errMsg);
			}
		}
		
		OptionDTO optionData;
		switch(click) {
			case 1: // 주문현황
				
				if (mm.getOrderList().size() == 0) {
					System.out.println("\t\t주문 목록이 없습니다.\n");					
				} else {
					System.out.println("\t\t--------------------------------------------------------------");
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
				System.out.println();
				break;
			case 4: // 옵션추가
				addOptionInput(mm.getDB().getProductList().get(clickProduct()));
				System.out.println();
				break;
			case 5: // 스타일추가
				mm.setProductData(mm.getDB().getProductList().get(clickProduct()));
				optionData = mm.getProductData().getOptionList().get(clickOption()); 
				addStyleInput(optionData);
				System.out.println();
				break;
			case 6: // 제품삭제
				mm.deleteInDB(clickProduct());
				System.out.println("\t\t제품이 삭제되었습니다.");
				System.out.println();
				break;
			case 7: // 옵션삭제
				
				mm.setProductData(mm.getDB().getProductList().get(clickProduct()));
				mm.deleteInDB(mm.getProductData(), clickOption());
				System.out.println("\t\t옵션이 삭제되었습니다.");
				System.out.println();
				break;
			case 8: // 스타일삭제
				mm.setProductData(mm.getDB().getProductList().get(clickProduct()));
				optionData = mm.getProductData().getOptionList().get(clickOption());
				mm.deleteInDB(optionData, clickStyle(optionData));
				System.out.println("\t\t스타일이 삭제되었습니다.");
				System.out.println();
				break;
		} // switch
		

	} // adminMenu()
	
	private void addProductInput() {
		while(true) { 
			String name = "";
			while(name.equals("")) {
				System.out.print("\t\t제품이름을 입력하세요 : ");
				name = sc.nextLine();
			}
	
			ProductDTO np = mm.addInDB(name);
			if(np == null) {
				System.out.println("\t\t중복된 제품입니다.");
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
					System.out.print("\t\t옵션이름을 입력하세요 : ");
					name = sc.nextLine();
				}
	
				OptionDTO no = mm.addInDB(p, name);
				
				if(no == null) {
					System.out.println("\t\t중복된 옵션입니다.");
				} else {
					addStyleInput(no);
					break;
				}
			}

			System.out.print("\t\t0. 종료하기 / 1. 옵션 계속 추가 : ");
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
					System.out.print("\t\t스타일 이름 : ");
					name = sc.nextLine();
				}
				
				while(price < 1) {
					System.out.print("\t\t스타일 가격 : ");
					price = sc.nextInt();
					sc.nextLine();
				}
	
				StyleDTO ns = mm.addInDB(o, name, price);
				
				if(ns == null) {
					System.out.println("\t\t중복된 스타일입니다.");
				} else {
					break;
				}
			}
			
			System.out.print("\t\t0. 종료하기 / 1. 스타일 계속 추가 : ");
			click = sc.nextInt();
			sc.nextLine();
		}
	}
	
	private void clientMenu() {
		System.out.println();
		System.out.println("\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println("\t\t░░░░░░░░████████████████░░░░░░░░");
		System.out.println("\t\t░░░░░░░░██░░░░░░░░░░░░██░░░░░░░░");
		System.out.println("\t\t░░░░░░░░██░░██░░░░██░░██░░░░░░░░");
		System.out.println("\t\t░░░░░░░░██░░░░░░░░░░░░██░░░░░░░░");
		System.out.println("\t\t░░░░░░░░██░░░░████░░░░██░░░░░░░░");
		System.out.println("\t\t░░░░██████░░░░░░░░░░░░██████░░░░");
		System.out.println("\t\t░░░░██░░████████████████░░██░░░░");
		System.out.println("\t\t░░░░██░░██░░░░░░░░░░░░██░░██░░░░");
		System.out.println("\t\t░░░░██░░████████████████░░██░░░░");
		System.out.println("\t\t░░░░██░░░░░░██░░░░██░░░░░░██░░░░");
		System.out.println("\t\t░░░░░░░░░░░░██░░░░██░░░░░░░░░░░░");
		System.out.println("\t\t░░░░░░░░░░░░██░░░░██░░░░░░░░░░░░");
		System.out.println("\t\t░░░░░░░░░░░░████░░████░░░░░░░░░░");
		System.out.println("\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
		System.out.println();


		int click = clickProduct();
		
		mm.setProductData(mm.getDB().getProductList().get(click));
		designSelectMenu();

	} // clientMenu()
	
	
	private void designSelectMenu() {
		System.out.println("\t\t===================================\t\t\n");
		System.out.println("\t\t  " + mm.getProductData().getName()
									+ " 제품의 디자인 생성을 시작합니다     \t\t\n");
		System.out.println("\t\t===================================\t\t");
		callThread(1000);
		System.out.println("\t\t   ░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t");
		System.out.println("\t\t   ░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t");
		callThread(500);
		System.out.println("\t\t   ░░░░░░░░░██░░░░░░██░░░░░░░░░\t");
		System.out.println("\t\t   ░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t");
		callThread(500);
		System.out.println("\t\t   ░░░░░██░░░░░░░░░░░░░░██░░░░░\t");
		System.out.println("\t\t   ░░░░░░░██░░░░░░░░░░██░░░░░░░\t");
		System.out.println("\t\t   ░░░░░░░░░██████████░░░░░░░░░\t");
		callThread(500);
		System.out.println("\t\t   ░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t");
		System.out.println("\t\t   ░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t");
		callThread(500);
		
		int click = 0;
		ArrayList<ProductDTO> productList = mm.randomDesignProductList();
		System.out.println("\n");
		System.out.println("\t\t□□□□□□□□□□□□   " + mm.getProductData().getName() + " 맞춤 제작   □□□□□□□□□□□□ ");
		System.out.println("");
		while(true) {
			int seq = 0;
			for(ProductDTO p : productList) {
				System.out.println("\t\t" + ++seq + ". 추천디자인 선택하기");
				mm.printDesign(p.getOptionList());
				System.out.println("");
			}
			System.out.println("\t\t" + ++seq + ". ALL 커스텀 선택하기");

			System.out.print("\n\t\t메뉴를 선택해주세요 : ");
			click = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			
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
			System.out.println("\n\t\t아래 디자인으로 (" + product.getName() + ") 제품을 주문하시겠습니까?");
			System.out.println();
			mm.printDesign(product.getOptionList());
			
			System.out.println("\t\t제품의 가격은 " + sum + "원 입니다.\n");
			
			System.out.println("\t\t" + ++seq + ". 주문하기");
			System.out.println("\t\t" + ++seq + ". 디자인 수정 하기");
			System.out.println("\t\t" + ++seq + ". 주문취소");
			
			System.out.print("\n\t\t메뉴를 선택해주세요 : ");
			click = sc.nextInt();
			sc.nextLine();
			System.out.println();
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
				
				System.out.println();
				System.out.println("\t ####### #     #    #    #     # #    #    #     # ####### #     # ");
				System.out.println("\t    #    #     #   # #   ##    # #   #      #   #  #     # #     # ");
				System.out.println("\t    #    #     #  #   #  # #   # #  #        # #   #     # #     # ");
				System.out.println("\t    #    ####### #     # #  #  # ###          #    #     # #     # ");
				System.out.println("\t    #    #     # ####### #   # # #  #         #    #     # #     # ");
				System.out.println("\t    #    #     # #     # #    ## #   #        #    #     # #     # ");
				System.out.println("\t    #    #     # #     # #     # #    #       #    #######  #####  ");
				
				
//				System.out.println("\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t\t");
//				System.out.println("\t\t░░░░░░░░░████░░░░░░████░░░░░░░░\t\t");
//				System.out.println("\t\t░░░░░░░████████░░████████░░░░░░\t\t");
//				System.out.println("\t\t░░░░░██████████████████████░░░░\t\t");
//				System.out.println("\t\t░░░░░██████░░██████░░██████░░░░\t\t");
//				System.out.println("\t\t░░░░░██████████████████████░░░░\t\t");
//				System.out.println("\t\t░░░░░░░████░░██████░░████░░░░░░\t\t");
//				System.out.println("\t\t░░░░░░░░░████░░░░░░████░░░░░░░░\t\t");
//				System.out.println("\t\t░░░░░░░░░░░██████████░░░░░░░░░░\t\t");
//				System.out.println("\t\t░░░░░░░░░░░░░██████░░░░░░░░░░░░\t\t");
//				System.out.println("\t\t░░░░░░░░░░░░░░░██░░░░░░░░░░░░░░\t\t");
//				System.out.println("\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t\t");
//				System.out.println("\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t\t");
				
				
				cal.add(cal.DATE, 7);
				System.out.print("\n\t\t주문하신 제품은 ");
				System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
				System.out.println(" 에 배송될 예정입니다.");
				System.out.println("\t\t주문해주셔서 감사합니다.\n");
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
			input.put("이름", "");
			input.put("핸드폰 번호", "");
			input.put("배송받을 주소", "");
			
			System.out.println("\n\t\t배송 정보를 입력해주세요.");
			
			for(String key : input.keySet()) {
				while(input.get(key).equals("")) {
					System.out.print("\t\t" + key + " : ");
					input.put(key, sc.nextLine());
				}
			}
			
			System.out.println("\n\t\t입력하신 정보를 확인해주세요.");
			for(String key : input.keySet()) {
				System.out.println("\t\t" + key + " : " + input.get(key));
			}
			
			while(click < 1 || click > 2) {
				System.out.print("\n\t\t1. 주문하기 / 2. 배송정보 수정하기 : ");
				click = sc.nextInt();
				sc.nextLine();
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
			
			System.out.println("\t\t" + product.getName() + " 제품 커스텀 하기");
			System.out.println();
			for(int i = 0; i < product.getOptionList().size(); i++) {
				customStyleMenu(product, i);
			}
//			System.out.println(product);
			
		} else {
			int click = 1;
			while(click == 1) {
				System.out.println("\t\t" + product.getName() + " 제품의 디자인 정보");
				mm.printDesign(product.getOptionList());
				System.out.println();
				System.out.println("\t\t옵션 리스트");
				customStyleMenu(product, clickOption());
				System.out.println("\t\t수정되었습니다.");
				
				System.out.print("\n\t\t0. 수정 종료 / 1. 수정 계속 : ");
				click = sc.nextInt();
				sc.nextLine();
			}
		}
		
		orderPageMenu(product);

	}
	
	private void customStyleMenu(ProductDTO product, int optionId) {
		
		OptionDTO optionData = mm.getProductData().getOptionList().get(optionId);
		System.out.println("\t\t" + optionData.getName() + " 옵션의 스타일 리스트");
		mm.modifyStyle(product, optionId, clickStyle(optionData));
		System.out.println();
	}
	
	private int clickProduct() {
		int click = 0;
		while(true) {
			click = 0;
			int seq = 0;
			for(ProductDTO p : mm.getDB().getProductList()) {
				System.out.println("\t\t" + ++seq + ". " + p.getName());
			}
			
			System.out.print("\n\t\t제품을 선택해주세요 : ");
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
				System.out.println("\t\t" + ++seq + ". " + o.getName());
			}
	
			System.out.print("\n\t\t옵션을 선택하세요 : ");
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
				System.out.println("\t\t" + ++seq + ". " + s.getName());
			}
			System.out.print("\n\t\t스타일을 선택하세요 : ");
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
	
	public static void callThread(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
