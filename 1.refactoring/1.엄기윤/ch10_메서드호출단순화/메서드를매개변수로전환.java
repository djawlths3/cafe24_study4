package ch10;

public class 메서드를매개변수로전환 {
	double salary;
	
	/*
	 * 매개변수에 따라 매서드가 달라진다면
	 * 매개변수를 전달 받는 메서드를 만들자
	 */

	void 이자5프로올리기() {
		salary *= 0.05;
	}

	void 이자10프로올리기() {
		salary *= 0.1;
	}
	
	void 이자올리기(double rate) {
		salary *= (1+rate);
	}
}
