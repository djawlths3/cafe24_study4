package cafe24_study4.RefactoringTest.Hajiseung;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	/* statement내부 코드 분리 */
	/* 변수명 직관적으로 변경 */
	public double amountFor() {
		double result = 0;
		switch (getMovie().getPriceCode()) {

		case Movie.REGULAR:
			result += 2;
			if (getDaysRented() > 2)
				result += (getDaysRented() - 2) * 1.5;
			break;

		case Movie.NEW_RELEASE:
			result += getDaysRented() * 3;
			break;

		case Movie.CHILDERNS:
			result += 1.5;
			if (getDaysRented() > 3)
				result += (getDaysRented() - 3) * 1.5;
			break;
		}
		return result;
	}
}
