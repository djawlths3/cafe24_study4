package chapter9;

public class 제어플래그제거2 { //기존 제어 플래그가 결과값으로 사용한 경우
	
	
//	void checkSecurity(String[] people) {
//		String found = "";
//		for(int i=0;i<people.length;i++) {
//			if(found.equals("")) {
//				if(people[i].equals("Don")) {
//					sendAlert();
//					found = "Don";
//				}
//				if(people[i].equals("John")) {
//					sendAlert();
//					found = "John";
//				}
//			}
//		}
//		someLaterCode(found);
//	}
	
	String checkSecurity(String[] people) {
		for(int i=0;i<people.length;i++) {
				if(people[i].equals("Don")) {
					sendAlert();
					return "Don";
				}
				if(people[i].equals("John")) {
					sendAlert();
					return "John";
				}
		}
		return "";
	}

	private void someLaterCode(String found) {
		// TODO Auto-generated method stub
		
	}

	private void sendAlert() {
		
	}
}
