package chapter9;

public class 중복조건식통합 {
	private int _year;
	private int _month;
	private int _date;

//	public boolean isDate() {
//		if(_year < 0  ) return false;
//		if(_month> 12) return false;
//		if(_date > 31) return false ;
//	}

	public boolean isDate() {
		if (isDate())
			return false;
		
		//상관없는 문
		else return true;
	}

	private boolean isNotEligableForDisability() {
		return ((_year<0)||(_month > 12)|| _date>31);
	}
}
