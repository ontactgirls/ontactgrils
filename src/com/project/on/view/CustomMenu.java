package com.project.on.view;

import java.util.Map;
import java.util.Scanner;

import com.project.on.dto.SelectDesignDTO;

public class CustomMenu {
	
	private SelectDesignDTO stdDTO;
	private Scanner sc = new Scanner(System.in);
	Map<String, String[]> optMap;

	//기본생성자
	public CustomMenu() {}
	
	//매개변수 생성자
	public CustomMenu(SelectDesignDTO stdDTO) {
		this.stdDTO = stdDTO;
	}
	
	public void customMenuView() {
		optMap = stdDTO.getPdOptDB().getOptMap();
		
		if(stdDTO.getConfirmDesign() == null) {
			// 디자인 정보가 NULL 인것은 커스텀 하기메뉴를 눌렀다는 뜻이다.
			// System.out.println("null값들고 진입");
			System.out.println("------------ 디자인 커스텀 하기 --------------");
			for(String key : optMap.keySet()) {
				runCustom(key);
			}
		} else {
			// 디자인 수정 하기
			System.out.println("------------ 디자인 수정 하기 --------------");
			int menu = 0;
			for(String key : optMap.keySet()) {
				System.out.print((++menu) + ". " + key + "\t");
				
				if(menu % 3 == 0) {
					System.out.println();
				}
			}

			while(true) {
				System.out.print("\n수정할 옵션을 선택해주세요 : ");
				menu = sc.nextInt();
				// 사용자 편의성으로 1부터 시작하기 때문에 < size가 아니라 <= size
				if(menu > 0 && menu <= optMap.size()) {
					break;
				}
			}

			runCustom((String)optMap.keySet().toArray()[menu-1]);
		}
	}
	
	private void runCustom(String key) {
		String[] values = optMap.get(key);
		System.out.println(key + "의 디자인 종류 입니다.");
		
		for(int i = 0; i < values.length; i++) {
			System.out.print("\t" + (i+1) + ". " + values[i]);
		}
		int selectValue = 0;
		while(true) {
			System.out.print("\n\n디자인을 선택해주세요 : ");
			selectValue = sc.nextInt();
			
			// 사용자 편의성으로 인하여 1부터 시작하니까 < length가 아니라 <= length이다.
			if(selectValue > 0 && selectValue <= values.length) {
				break;
			}
		}
	}
}
