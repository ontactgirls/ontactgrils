package com.project.on.view;

import java.util.Scanner;

public class AppMain {
	
	public void mainView() {
		System.out.println("\t\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t\t\t\n");
		System.out.println("\t\t\t\t   Project ON \t\t\t\t");
		System.out.println("\t\t\t       디자인 생성을 시작합니다     \t\t\t\t\n");
		System.out.println("\t\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t\t\t");
		callThread(1000);
		System.out.println("\t\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t\t\t");
		System.out.println("\t\t\t░░░░░████████░░░░░░████████░░░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░██████████████████████████░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░██████████████████████████░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░████░░██████████████░░████░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░████░░██████████████░░████░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░████░░██████████████░░████░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░████░░██████████████░░████░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░░░░░░░██████████████░░░░░░░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░░░░░░░██████████████░░░░░░░░\t\t\t");
		callThread(100);
		System.out.println("\t\t\t░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\t\t\t");
		callThread(100);
		System.out.println();

		Scanner sc = new Scanner(System.in);
		
		int menu = 1;
		
		switch(menu) {
			case 1: 
			case 2: 
				new SelectDesignMenu().selectDesignMenuView();
				break;
		}
		
	}
	
	public static void callThread(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
