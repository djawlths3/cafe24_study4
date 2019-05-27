package chapter9;

public class 제어플래그제거 {
	
	
//	void checkSecurity(String[] people) {
//		boolean found = false;
//		for(int i=0;i<people.length;i++) {
//			if(!found) {
//				if(people[i].equals("Don")) {
//					sendAlert();
//					found = true;
//				}
//				if(people[i].equals("John")) {
//					sendAlert();
//					found = true;
//				}
//			}
//		}
//	}
	
	void checkSecurity(String[] people) {
		for (int i = 0; i < people.length; i++) {
			
				if (people[i].equals("Don")) {
					sendAlert();
					break;
				}
				if (people[i].equals("John")) {
					sendAlert();
					break;
				}
		}
	}

	private void sendAlert() {
		
	}
}
