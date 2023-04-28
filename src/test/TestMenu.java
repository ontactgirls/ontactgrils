package test;

import java.util.Scanner;

import com.on.project.database.ProductDB;

public class TestMenu {
	Scanner sc = new Scanner(System.in);
	int click = -1;
	
	public void mainMenu() {
		String[] texts = 
			{
					"1. 관리자",
					"2. 맞춤패션제작"
			};
		
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
				System.out.println("잘못된 메뉴입니다.");
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
		
		ProductDB productDB = new ProductDB();
		
	} // clientMenu()
}