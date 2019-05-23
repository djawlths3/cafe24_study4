package ch10;

public class 매겨변수를메서드로전환 {
	static final int 사과 = 0;
	static final int 복숭아 = 0;
	static final int 배 = 0;
	static final int 바나나 = 0;
	
	public static void main(String[] args) {
		/*
		 * 
		 * 메서드안에 조건문이 많을경우(분기점)
		 * 각 조건을 매서드로 변경해서 뺀다
		 * 
		 * 조건에 따른 실행도 방지하면서 컴파일할 때 검사가 된다
		 * 매개변수의 값이 많이 변할 경우는 실시하지말라
		 * 
		 */
		과일 a = 과일이름대기(사과);
		과일 b = 사과();
	}

	
	static void 과일이름대기(int type) {
		switch (type) {
		case 사과:
			return new 사과();
		case 배:
			return new 배();
		case 복숭아:
			return new 복숭아();
		case 바나나:
			return new 바나나();
		default:
			throw new IllegalAccessException();
		}
	}

}
