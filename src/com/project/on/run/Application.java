package com.project.on.run;

import com.project.on.view.AppMain;

public class Application {

	public static void main(String[] args) {
		// 실행
		AppMain app = new AppMain();
		app.mainView();
		System.out.println("종료하고 메인으로 돌아옴");
	}
}