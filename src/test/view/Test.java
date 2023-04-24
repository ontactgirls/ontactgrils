package test.view;

import com.project.on.dto.SelectDesignDTO;

public class Test {
	
	SelectDesignDTO sdDTO;
	
	public void method(SelectDesignDTO sdDTO) {
		this.sdDTO = sdDTO;
		
		int[] test = sdDTO.getStdDTO();
		
		System.out.println("test[0]" + test[0]);
	}

}