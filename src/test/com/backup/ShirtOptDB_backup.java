package test.com.backup;


public class ShirtOptDB_backup extends ProductOptDB_backup {
	
	//생성자
	public ShirtOptDB_backup() {
		super();
		super.optMap.put("카라", new String[] {"롱", "숏", "하프"});
//		ArrayList<String> sarr = new ArrayList<>();
//		sarr.add("롱");
//		sarr.add("숏");
//		sarr.add("하프");
//		optMap.put("카라", sarr);
		super.optMap.put("소매", new String[] {"굴림"});
		super.optMap.put("주머니", new String[] {"왼쪽", "dddd"});
		super.optMap.put("앞단", new String[] {"테스트1", "ㅁ", "ㄴ"});
		super.optMap.put("뒷판", new String[] {"홍길동"});
		super.optMap.put("기장", new String[] {"유관순"});
		
	}

	@Override
	public String toString() {
		return "셔츠";
	}
}