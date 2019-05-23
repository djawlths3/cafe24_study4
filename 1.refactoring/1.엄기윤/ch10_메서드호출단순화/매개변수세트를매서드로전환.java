package ch10;

import java.util.Calendar;

public class 매개변수세트를매서드로전환 {
static double cost;
static double InflationRate;
static double discountLevel;
	public static void main(String[] args) {
		/*
		 * 가급적 매개변수는 없는게 좋다.(상황에따라 다르긴함)
		 * 만약 매개변수로 넘기는 값이 넘기는 메소드 내에서 실행 가능하다면 매개변수로 만들어 넘기기 보다
		 * 메소드 안에서 처리하는 방법이 좋다
		 */
		
		double price = cost * InflationRate; 
		discountLevel = getDiscountLevel();
		double finalPrice = discountedPrice(price, discountLevel);
		
		///////////////////////////////////////////////////////////////////
		finalPrice = discountedPrice(); 
	}
	
	
	
	private static double discountedPrice(double price, double discountLevel2) {
		/*
		 * 
		 * 생략
		 */
		return 0;
	}
	private static double discountedPrice() {
		double price = cost * InflationRate; 
		getDiscountLevel();
		/*
		 * 생략
		 */
		return 0;
	}



	private static double getDiscountLevel() {
		Calendar date = Calendar.getInstance();;
		if(date.YEAR>2018) {
			/*
			 * 
			 * 생략
			 */
		}
		return 0;
	}
	
	

}
