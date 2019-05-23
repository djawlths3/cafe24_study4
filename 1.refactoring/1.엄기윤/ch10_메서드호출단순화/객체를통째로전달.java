package ch10;

public class 객체를통째로전달 {
	public static void main(String[] args) {
		/*
		 * 코드를 알아보기 쉬워진다
		 * 하지만 유연성이 떨어진다
		 * 
		 * 
		 * p342
		 * 두번째 문단 
		 * 게다가 호출되는 객체가 데이터를 넘겨주는 객체를 통째로 넘겼더라면 사용할 수 있었을 다른 메서드를 이용할 수 없음으로 중복코드가 생긴다
		 * 이게 왜 장점일까요 토론해 봆시다. 
		 */
		
		int low = tempVo.getLow();
		int hight = tempVo.getHight();
		withinPlan = plan.withinRange(low, hight);
		/////////////////////////////////////////////////////
		withinPlan = plan.withinRange(tempVo);
	}
}
