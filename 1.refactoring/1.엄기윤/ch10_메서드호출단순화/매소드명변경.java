package ch10;

public class 매소드명변경 {

	static String phoneNumber= "0000-0000";
	static String areaNumber= "02";
	
	public static void main(String[] args) {
		/* 코드는 컴퓨터보다 인간이 알아볼 수 있게 작성.
		 * 그러기 위해서는 코드에 사용된 이름이 적절해야 한다.
		 * 
		 * 1. 매서드가 상위 혹은 하위에서 사용 되고 있는지 알아본다.
		 * 	    적절한 방법 ? (ctrl + click), (ctrl + h), (ctrl + shift + g) 또무엇이 있을까
		 * 
		 * 2. 만약 구현되어 있다면 일단 새로운매서드를 만든다.
		 * 
		 * 3. 기존매서드에서 새로운 매서드를 호출 한다
		 * 
		 * 4.테스트를 해본다
		 * 
		 * 5. 원본 매서드를 참조하는 부분을 새 매소드로 변경 한다
		 * 
		 * 6. 테스트 후 이상없으면 원본 매서드 삭제
		 * 
		*/

	}
	/*
	public String 전화번호가져오기() {
		return areaNumber+phoneNumber;
	}

	public String 지역번호붙여서전화번호가져오기() {
		return areaNumber+phoneNumber;
	}
	*/
	public String 전화번호가져오기() {
		return 지역번호붙여서전화번호가져오기();
	}

	public String 지역번호붙여서전화번호가져오기() {
		return areaNumber+phoneNumber;
	}
	
}
