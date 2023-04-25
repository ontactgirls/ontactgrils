package com.project.on.view;

import java.util.Map;
import java.util.Scanner;

import com.project.on.controller.SelectDesignMenuManager;
import com.project.on.dto.SelectDesignDTO;
import com.project.on.productOptDB.ProductOptDB;
import com.project.on.productOptDB.ShirtOptDB;

import test.view.OrderMenu;
import test.view.Test;

public class SelectDesignMenu {
	ProductOptDB pdOptDB = new ShirtOptDB();
	private Map< String, String[] > optMap = pdOptDB.getOptMap();
	private Scanner sc = new Scanner(System.in);
	
	
	public void selectDesignMenuView() {
		// manager의 추천디자인 생성 메서드를 호출하고 리턴 받은 값을 저장
		int[][] randomDesigns = new SelectDesignMenuManager().randomDesigns(pdOptDB);
		
		int chkNum;
		int menu;
		
		while(true) {
				
			chkNum = 0;
			menu=0;
			
			
			for(int[] rds : randomDesigns) {
				System.out.print("\t-------------------- ");
				System.out.print((++menu) + ". 추천디자인 선택하기");
				System.out.println(" --------------------\t");
				chkNum = 0;
				for(int rd : rds) {
					String key = (String) optMap.keySet().toArray()[chkNum];
					System.out.print("\t" + key + " : \t");
	//				System.out.print(" / rd값: " + rd);
					System.out.print(optMap.get(key)[rd] + "\t");
	//				System.out.print("|");
					chkNum++;
					if(chkNum % 3 == 0) {
						System.out.println();
					}
				}
				System.out.println("\n");
			}
			System.out.print("\t----------------------- ");
			System.out.print((++menu) + ". 커스텀하기");
			System.out.println(" -----------------------\t\n");
			
			System.out.print("\t----------------------- ");
			System.out.print((++menu) + ". 종료하기");
			System.out.println(" ------------------------\t\n");
			
			

			System.out.print(">>>>>>>>>>>>>> 메뉴를 선택해 주세요 : ");
			menu  = sc.nextInt();
			System.out.println();
			
			if(menu > 0 && menu <= 5) {
				break;
			} else {
				System.out.println("\t\t잘못 입력하셨습니다.");
			}
		} // while 종료
		
		switch(menu) {
			case 1:
			case 2:
			case 3:
				OrderMenu om = new OrderMenu(
									new SelectDesignDTO(randomDesigns[menu-1], pdOptDB));
				om.orderMenuView();
				break;
			case 4:
				new Test().method(new SelectDesignDTO(randomDesigns[menu-1], pdOptDB));
			case 5:return;
			//default는 while에서 menu 입력 값을 검증했기 때문에 생략함.
		}
	}
}