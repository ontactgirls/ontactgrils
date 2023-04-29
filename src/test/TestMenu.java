package test;

import java.util.ArrayList;
import java.util.Scanner;

import com.on.project.database.ProductDB;
import com.on.project.dto.ProductDTO;

public class TestMenu {
	Scanner sc = new Scanner(System.in);
	ProductDB db = new ProductDB();
	TestManager tm = new TestManager();
	
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
				System.out.println("없는 메뉴입니다.");
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

			for(ProductDTO pDTO : db.getProductList()) {
				System.out.println(++seq + ". " + pDTO.getName());
			}
			
			System.out.print("원하시는 제품을 선택해주세요 : ");
			click = sc.nextInt();
			
			// 메뉴 입력이 정상 범위이다.
			if (click > 0 && click <= db.getProductList().size()) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}

		new TestMenu().designSelectMenu(db.getProductList().get(click-1));

	} // clientMenu()
	
	
	private void designSelectMenu(ProductDTO product) {
		
		
		int click = 0;
		ArrayList<ProductDTO> productList = tm.randomDesignProductList(product);
		
		while(true) {
			int seq = 0;
			for(ProductDTO p : productList) {
				
				System.out.println("\t" + ++seq + ". 추천디자인 선택하기");
				System.out.print("\t\t");
				tm.printDesign(p.getOptionList());
			}
			System.out.println("\t" + ++seq + ". ALL 커스텀 선택하기");

			System.out.print("\n------------- 메뉴를 선택해주세요 : ");
			click = sc.nextInt();
			
			if (click > 0 && click <= seq) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}

		switch(click) {
			case 1 :
			case 2 :
			case 3 :
				System.out.println("당신이 선택한 디자인은");
				tm.printDesign(productList.get(click-1).getOptionList());
				break;
			case 4 :

		}
		

	} // designSelectMenu()

}