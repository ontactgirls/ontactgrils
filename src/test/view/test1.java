package test.view;

import com.project.on.dto.SelectDesignDTO;
import com.project.on.productOptDB.ProductOptDB;
import com.project.on.productOptDB.ShirtOptDB;

public class test1 {

	public static void main(String[] args) {
		ProductOptDB test = new ShirtOptDB();
		int[] d = new int[]{1, 2, 3};
		SelectDesignDTO dot = new SelectDesignDTO(d, test);
	}
}