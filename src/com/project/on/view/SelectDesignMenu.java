package com.project.on.view;

import java.util.Map;
import java.util.Scanner;

import com.project.on.controller.SelectDesignMenuManager;
import com.project.on.dto.SelectDesignDTO;
import com.project.on.productDB.ProductOptDB_backup;
import com.project.on.productDB.ShirtOptDB_backup;

public class SelectDesignMenu {
	ProductOptDB_backup pdOptDB = new ShirtOptDB_backup();
	private Map< String, String[] > optMap = pdOptDB.getOptMap();
	private SelectDesignMenuManager sdManager = new SelectDesignMenuManager();
	private SelectDesignDTO stdDTO;
	private Scanner sc = new Scanner(System.in);
	
	int[][] randomDesigns;
	private int menu;
	
	public void selectDesignMenuView() {
		// manager의 추천디자인 생성 메서드를 호출하고 리턴 받은 값을 저장
		randomDesigns = sdManager.randomDesigns(pdOptDB);

		int chkNum;
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
					System.out.print(optMap.get(key)[rd] + "\t");
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
			case 1: // 추천디자인1
				
			case 2: // 추천디자인2
				
			case 3: // 추천디자인3
				callOrderMenu();
				break;
			case 4:
				callCustomMenu();
				break;
			case 5:
				return;
			//default는 while에서 menu 입력 값을 검증했기 때문에 생략함.
		}
	} // SelectDesignMenuView() 끝
	
	private void callOrderMenu() {
		// OrderMenu의 매개변수 생성자 호출
		stdDTO = new SelectDesignDTO(randomDesigns[menu-1], pdOptDB);
		new OrderMenu(stdDTO).orderMenuView();
	}
	
	private void callCustomMenu() {
		stdDTO = new SelectDesignDTO(pdOptDB);
		// customMenu의 매개변수 생성자 호출
		// 사용자가 선택한 디자인 값이 없기 때문에 제품객체만 인자값으로 전달함.
		new CustomMenu(stdDTO).customMenuView();
	}

}