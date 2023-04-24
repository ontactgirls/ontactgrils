package test.run;

import java.util.Map;

import com.project.on.dto.SelectDesignDTO;
import com.project.on.productOptDB.ProductOptDB;
import com.project.on.productOptDB.ShirtOptDB;

import test.view.OrderMenu;

// OrderMenu 테스트
public class OrderMenuRun {

	public static void main(String[] args) {
		
		// OrderMenu 테스트를 위한 샘플 디자인데이터 얻기 시작
		ProductOptDB pdOptDB = new ShirtOptDB();
		Map< String, String[] > optMap = pdOptDB.getOptMap();
		SelectDesignDTO stdDTO = new SelectDesignDTO(pdOptDB.getSampleDesign(), optMap);
		// OrderMenu 테스트를 위한 샘플 디자인데이터 얻기 끝
		
		// 샘플디자인데이터 OrderMenu로 넘김
		OrderMenu menu = new OrderMenu(stdDTO);
		menu.OrderMenuView();
		
		System.out.println("종료하고 메인으로 돌아옴");
	}
} 
