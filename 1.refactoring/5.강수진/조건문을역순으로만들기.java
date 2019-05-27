package chapter9;

public class 조건문을역순으로만들기 {
	private double _duration;
	private double _intRate;
	private double _capital;
	private double _income;
	private double ADJ_FACTOR;

//	public double getAdjustedCapital() {
//		double result = 0.0;
//		if(_capital>0.0) {
//			if(_intRate > 0.0 && _duration > 0.0) {
//				result = (_income / _duration) * ADJ_FACTOR;
//			}
//		}
//		return result;
//	}
	
	public double getAdjustedCapital() {
		double result = 0.0;
		if(_capital<=0.0) return 0.0;
		if(_intRate <= 0.0 || _duration <= 0.0) return 0.0;
		result = (_income / _duration) * ADJ_FACTOR;
		return result;
	}
}
