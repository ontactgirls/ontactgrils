package com.project.on.controller;

import java.util.Map;

public class SelectDesignMenuManager {

	/**
	 * 중복되지 않은 랜덤 값으로 추천 디자인을 생성한다. 
	 * @return int[][] 생성된 추천 디자인
	 */
	public int[][] randomDesigns(Map< String, String[] > optMap) {
		int optMapSize = optMap.size(); // 옵션 타이틀 개수 (ex : 카라, 주머니, 커프스 > 3개)
		int designCnt=3; // 생성할 추천디자인 개수
		// 생성된 추천 디자인 값을 담을 2차원 배열
		int[][] randomDesigns = new int[designCnt][optMapSize];

		// 랜덤 값이 0부터 시작하기 때문에 randomDesigns의 값을 -1로 초기화 했다
		for(int i = 0; i < designCnt; i++) {
			for(int j = 0; j < optMapSize; j++) {
				randomDesigns[i][j] = -1;
//				System.out.print(randomDesigns[i][j]);
			}
//			System.out.println();
		}
		
		int chkNum = 0; //중복체크 카운트

		// 옵션 타이틀에 해당하는 종류 만큼 랜덤 값을 생성하고 추천디자인을 만든다.
		// ex : 옵션 타이틀 카라의 종류는 굴림, 사각 > 2 > 랜덤 값 2개 생성
		//		옵션 타이틀 주머니의 종류는 왼쪽, 오른쪽, 양쪽 > 3 > 랜덤 값 3개 생성
		for(int i = 0; i < designCnt; i++) { // 생성할 추천디자인의 개수 for i
			
			// 추천 디자인을 생성한다
			for(int j = 0; j < optMapSize; j++) { // 옵션 타이틀 개수 for j
				// 랜덤 값은 0부터 시작하기 때문에 -1로 초기화
				int ranNum = -1;
				// key 값 = 옵션 타이틀 (ex : 카라, 주머니, 소매 등) 
				String key = (String) optMap.keySet().toArray()[j];
				
				// 옵션 타이틀의 종류만큼 random() 생성 (ex : 카라 > 굴림, 사각, 육각 등)
				randomDesigns[i][j] = (int)(java.lang.Math.random()
										* optMap.get(key).length);
				
//				System.out.print("키값 " + j + " : "  + key);
//				System.out.print(" / 옵션수 " + optMap.get(key).length);
//				System.out.println(" / 생성랜 : " + randomDesigns[i][j]);
			}
			
			// 생성된 추천 디자인을 중복체크 한다
			for(int k = 0; k < i; k++) { // 현재 인덱스 i 와 앞의 인덱스들 k를 비교함.
				chkNum = 0;
				for(int j = 0; j < optMapSize; j++) { // 옵션 타이틀 개수 만큼 for
					// if 옵션 타이틀의 종류 값이 같으면 chkNum 1 증가한다.
					if(randomDesigns[k][j] == randomDesigns[i][j]) {
						chkNum++;
					}
				}
				
				
				
				
//				System.out.println("chkNum : " + chkNum);
				
				// 옵션 타이틀의 개수와 같다는건 모든 디자인이 중복되었다는 뜻이다.
				if(chkNum == optMapSize) {
//					System.out.println("중복입니다");
					i--; // 디자인을 다시 생성해야 하기 때문에 현재 인덱스 -1
				}
			}
		}

//		for(String key : optMap.keySet()) {
//			System.out.println(optMap.get(key)[0]);
//		}
		
//		String key = (String) optMap.keySet().toArray()[0];
//		System.out.println("key 0 : " + key);
//		key = (String) optMap.keySet().toArray()[1];
//		System.out.println("key 1 : " + key);
//		key = (String) optMap.keySet().toArray()[2];
//		System.out.println("key 2 : " + key);
		
		
//		for(int i = 0; i < optMapSize; i++) {
//			String key = (String) optMap.keySet().toArray()[i];
//			System.out.println(" : " + optMap.get(key)[randomDesign[][]]);
//		}
		return randomDesigns;
	}
}
