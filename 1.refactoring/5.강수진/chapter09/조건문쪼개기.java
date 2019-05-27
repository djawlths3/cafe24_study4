package chapter9;

import java.util.Date;

public class 조건문쪼개기 {

	private static final Date SUMMER_START = null;
	private static final Date SUMMER_END = null;
	private static double _winterServiceCharge;
	private static Date date;
	private static double charge = 0.0;
	private static double quantity = 0.0;
	private static double _winterRate = 0.0;
	private static double _summerRate = 0.0;

	public static void main(String[] args) {
		
//		if(date.before(SUMMER_START)|| date.after(SUMMER_END)) 
//			charge = quantity * _winterRate + _winterServiceCharge;
//		else charge = quantity * _summerRate;
		
		if(notSummer(date))
			charge = winterCharge(quantity);
		else charge= summerCharge(quantity);
		
	}

	private static boolean notSummer(Date date) {
		return date.before(SUMMER_START)|| date.after(SUMMER_END);
	}
	private static double winterCharge(double quantity) {
		return quantity * _winterRate + _winterServiceCharge;
	}
	private static double summerCharge(double quantity) {
		return quantity * _summerRate;
	}

}
