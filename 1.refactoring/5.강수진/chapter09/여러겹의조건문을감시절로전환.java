package chapter9;

public class 여러겹의조건문을감시절로전환 {
	private boolean _isDead;
	private boolean _isSeparated;
	private boolean _isRetired;

//	double getPayAmount() {
//		double result = 0;
//		if(_isDead) result = deadAmount();
//		else {
//			if(_isSeparated) result = separateAmount();
//			else {
//				if(_isRetired) result = retiredAmount();
//				else result = normalPayAmount();
//			}
//		}
//		return result;
//	}
	
	double getPayAmount() {
		if(_isDead) return deadAmount();
		if(_isSeparated) return separateAmount();
		if(_isRetired) return retiredAmount();
		return normalPayAmount();
	}

	private double retiredAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double normalPayAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double separateAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double deadAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
