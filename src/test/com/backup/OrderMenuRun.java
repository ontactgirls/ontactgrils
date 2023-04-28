package test.com.backup;

import java.util.Map;

import com.on.project.dto.SelectDesignDTO;
import com.on.project.view.OrderMenu;

// OrderMenu 테스트
public class OrderMenuRun {

	public static void main(String[] args) {
		
		// OrderMenu 테스트를 위한 샘플 디자인데이터 얻기 시작
		ProductOptDB_backup pdOptDB = new ShirtOptDB_backup();
		Map< String, String[] > optMap = pdOptDB.getOptMap();
		SelectDesignDTO stdDTO = new SelectDesignDTO(pdOptDB.getSampleDesign(), pdOptDB);
		// OrderMenu 테스트를 위한 샘플 디자인데이터 얻기 끝
		
		// 샘플디자인데이터 OrderMenu로 넘김
		OrderMenu menu = new OrderMenu(stdDTO);
		menu.orderMenuView();
		
		System.out.println("종료하고 메인으로 돌아옴");
	}
} 
