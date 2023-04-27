package test.run;

import java.util.Map;

import com.project.on.dto.SelectDesignDTO;
import com.project.on.productDB.ProductOptDB_backup;
import com.project.on.productDB.ShirtOptDB_backup;
import com.project.on.view.OrderMenu;

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
