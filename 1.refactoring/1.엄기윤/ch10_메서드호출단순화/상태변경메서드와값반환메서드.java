package ch10;

public class 상태변경메서드와값반환메서드 {

	public static void main(String[] args) {
		String singer = 김종욱찾기("김종욱");
		/////////////////////////////////////////////////////////////////
		김종욱("아이유");
		String singer2 = 찾기("아이유");

	}

	static String 김종욱찾기(String people) {
		if(people.equals("김종욱")) {
			sendAlert();
			return "김종욱";
		}
		
		return "";
	}
	
///////////////////////////////////////////////////////////////////////////////	
	static void 김종욱(String people) {
		if(people.equals("김종욱")) {
			sendAlert();
		}
	}
	
	static String 찾기(String people) {
		return people;
	}
	
/////////////////////////////////////////////////////////////////////////////////	
	
	
	static void sendAlert(String singer){
		if(! 찾기(singer).equals("") ) 
			sendAlert();
	}
	
	static void sendAlert(){
		System.out.println("김종욱이다!");
	}
	
}
	
