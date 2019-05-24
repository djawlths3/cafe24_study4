package cafe24_study4.RefactoringTest.Hajiseung;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String name;
	private Vector _rentals = new Vector();

	public Customer(String _name) {
		this.name = _name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		long preTime = System.nanoTime();
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();

		String result = getName() + "고객님의 대여 기록\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();

//			switch (each.getMovie().getPriceCode()) {
//
//			case Movie.REGULAR:
//				thisAmount += 2;
//				if (each.getDaysRented() > 2)
//					thisAmount += (each.getDaysRented() - 2) * 1.5;
//				break;
//
//			case Movie.NEW_RELEASE:
//				thisAmount += each.getDaysRented() * 3;
//				break;
//
//			case Movie.CHILDERNS:
//				thisAmount += 1.5;
//				if (each.getDaysRented() > 3)
//					thisAmount += (each.getDaysRented() - 3) * 1.5;
//				break;
//			}

			// 리팩토링 실시
//			thisAmount = amountFor(each);

//			amountFor 메서드 Rental클래스로 위치 변경
			thisAmount = each.amountFor();

			frequentRenterPoints++;
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		result += "누적 대여료 :" + String.valueOf(totalAmount) + "\n";
		result += "적립 포인트 :" + String.valueOf(frequentRenterPoints) + "\n";
		long postTime = System.nanoTime();
		System.out.println(postTime-preTime);
		return result;
	}

//	statement내부 코드
//	분리 변수명
//	직관적으로 변경
//	private double amountFor(Rental aRental) {
//		double result = 0;
//		switch (aRental.getMovie().getPriceCode()) {
//
//		case Movie.REGULAR:
//			result += 2;
//			if (aRental.getDaysRented() > 2)
//				result += (aRental.getDaysRented() - 2) * 1.5;
//			break;
//
//		case Movie.NEW_RELEASE:
//			result += aRental.getDaysRented() * 3;
//			break;
//
//		case Movie.CHILDERNS:
//			result += 1.5;
//			if (aRental.getDaysRented() > 3)
//				result += (aRental.getDaysRented() - 3) * 1.5;
//			break;
//		}
//		return result;
//	}

}
