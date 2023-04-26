package com.project.on.view;

import java.util.Scanner;

import com.project.on.dto.SelectDesignDTO;

public class OrderMenu {
	
	private SelectDesignDTO stdDTO;
	private Scanner sc = new Scanner(System.in);

	//기본생성자
	public OrderMenu() {}
	
	//매개변수 생성자
	public OrderMenu(SelectDesignDTO stdDTO) {
		this.stdDTO = stdDTO;
	}
	
	public SelectDesignDTO orderMenuView() {
		
		int menu = 0;
		while(true) {
			System.out.println("\n\t---------------- 아래 디자인으로 주문하시겠습니까? ---------------\t");
			System.out.println(stdDTO);
			System.out.println("\n\t 1. 주문하기");
			System.out.println("\t 2. 수정하기\n");
			
			System.out.print(">>>>> 메뉴를 입력해주세요 : ");
			menu = sc.nextInt();
			System.out.println();
			
			
			if(menu > 0 && menu <= 2) {
				break;
			}
		}
		
		switch(menu) {
			case 1:
				
				System.out.println(stdDTO);
				
				System.out.println();
				System.out.println();
				System.out.println("\t\t감사합니다.\t\t");
				System.out.println();
				System.out.println();
				break;
			case 2:
				System.out.println("수정하기 메서드 호출");
				new CustomMenu(stdDTO).customMenuView();
				break;
		}
		return stdDTO;
	}
}