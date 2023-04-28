// ------ 목표 -------
//	제품 추가 및 수정이 가능할 것.
//	옵션 타이틀 추가 및 수정이 가능할 것.
//	옵션 종류 추가 및 수정이 가능할 것.
//	중복 되지 않도록 할 것.

package test.com.backup;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductDB_backup {
	private Map<String, Map<String, Map<String, Integer>>> productMap = new LinkedHashMap<>();
	private Map<String, Map<String, Integer>> titleMap;
	private Map<String, Integer> designMap;
	
	public ProductDB_backup() {
	//	---- 데이터 구성 ------
	//   product > title > design
	//	 Map (셔츠 ,  List1)
	//	             List1( 카라, List2 ) -> List1(Map)
	//	                         List2 (숏, 2000원) -> List2(Map)
	//							      					  String, int
	//						     List2(굴림, 3000원)
	//							 List2(육각, 2500원)
	//	 Map (바지 ,  List1)
	// 			 	 List1(밑단, List2 )
	//              			List2(넓게, 1000원)
	//							List2(좁게, 1500원)
	// 				 List1(길이, List2 )
	//			     			List2(긴바지,3000원)
	//							List2(반바지,2000원)

	// 셔츠 제품
	titleMap = new LinkedHashMap<>();
	productMap.put("셔츠", titleMap);
	 	designMap = new LinkedHashMap<>();
	 	titleMap.put("카라", designMap);
			designMap.put("숏카라", 2000);
			designMap.put("롱카라", 2500);
			designMap.put("하프와이드", 5000);
			
		designMap = new LinkedHashMap<>();	
		titleMap.put("커프스", designMap);
			designMap.put("굴림", 3000);
			designMap.put("육각", 3500);
			designMap.put("사각", 2000);
	// 바지 제품			
	titleMap = new LinkedHashMap<>();				
	productMap.put("바지", titleMap);
		designMap = new LinkedHashMap<>();
		titleMap.put("길이", designMap);
			designMap.put("긴바지", 2000);
			designMap.put("반바지", 2500);
		
	}
	
	public static void main(String[] args) {
		ProductDB_backup db = new ProductDB_backup();

		System.out.println(db.getKeyArray()[0]);
		System.out.println(db.getKeyArray(db.getKeyArray()[0])[0]);
		System.out.println(db.getKeyArray(db.getKeyArray()[0], db.getKeyArray(db.getKeyArray()[0])[0])[0]);

	}
	public String[] getKeyArray() {
		return keyToArray(productMap);
	}
	
	public String[] getKeyArray(String productKey) {
		Map titles = productMap.get(productKey);
		return keyToArray(titles);
	}
	
	public String[] getKeyArray(String productKey, String titleKey) {
		Map designs = productMap.get(productKey).get(titleKey);
		return keyToArray(designs);
	}
	
	public String[] keyToArray(Map map) {
		return (String[]) map.keySet().toArray(new String[map.size()]);
	}
	
	
	
	public void test() {
		for(int i = 0; i < productMap.size(); i++) {
			String product = (String)productMap.keySet().toArray()[i];
//			System.out.println("product : " + product);
			
			System.out.println(productMap.keySet());
			System.out.println(productMap.values());
			System.out.println();
			for(int j = 0; j < productMap.get(product).size(); j++) {
				String title = (String)productMap.get(product).keySet().toArray()[j];
				//System.out.println("\ttitle : " + title);
				System.out.println("keyset" + productMap.get(product).keySet());
				System.out.println("values" + productMap.get(product).values());
			
				System.out.println(productMap.get("셔츠").get("카라").get("숏카라"));

//				System.out.println(products.);
				
			}
			
//			데이터의 구조
//			products.values()
//			[
//			  {
//				카라={숏카라=2000, 롱카라=2500, 하프와이드=5000} ,
//			    커프스={굴림=3000, 육각=3500, 사각=2000}
//			  } ,
//			  {
//			    길이={긴바지=2000, 반바지=2500}
//			  }
//			]
//			titleMap.entrySet()
//			[
//				카라={숏카라=2000, 롱카라=2500, 하프와이드=5000},
//				커프스={굴림=3000, 육각=3500, 사각=2000}
//			]
//			designMap.entrySet()
//			[
//				숏카라=2000,
//				롱카라=2500,
//				하프와이드=5000
//			]

			for (Map<String, Map<String, Integer>> titleMap : productMap.values()) {
				
			    for (Map.Entry<String, Map<String, Integer>> titleEntry : titleMap.entrySet()) {
			        String titleName = titleEntry.getKey();
			        Map<String, Integer> designMap = titleEntry.getValue();
			        
			        for (Map.Entry<String, Integer> designEntry : designMap.entrySet()) {
			            String designName = designEntry.getKey();
			            int designPrice = designEntry.getValue();
			            System.out.println(titleName + " : " + designName + " : " + designPrice);
			        }
			    }
			}
		}
	}
}
