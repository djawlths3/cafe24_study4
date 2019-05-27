package chapter9;

public class 조건문의공통실행코드빼내기 {
	public static void main(String[] args) {
		double total = 0.0;
		double price = 0.0;
		
//		if(isSpecialDeal()) {
//			total = price * 0.95;
//			send();
//		}else {
//			total = price * 0.98;
//			send();
//		}
		
		if(isSpecialDeal()) {
			total = price * 0.95;
		}else {
			total = price * 0.98;
		}
		send();
	}

	private static boolean isSpecialDeal() {
		return false;
	}

	private static void send() {
		
	}
}
