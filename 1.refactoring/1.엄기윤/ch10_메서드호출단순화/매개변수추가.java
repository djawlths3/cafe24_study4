package ch10;

public class 매개변수추가 {

	
			
	public static void main(String[] args) {
		/*
		 * 가급적 사용하지말자.
		 * 매개변수가 많으면 보기도 힘들고 기억하기도 힘들다
		 */
	}
	
	/*
	 * public void getList() {
			pageNo = 10 -10;
		}
	 * 
	 */
	public void getList(Long pageNo) {
		pageNo = pageNo*10 -10;		
	}
}
