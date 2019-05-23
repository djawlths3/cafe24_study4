package ch10;

import java.util.ArrayList;
import java.util.List;

public class 쓰기메서드제거 {

	private static List<Long> pageList;

	public static List<Long> getPageList() {
		return pageList;
	}

	public 쓰기메서드제거(Long nowPage, Long pageSize) {
		if (pageSize == 0 ) {
			pageSize = 1L;
		}
		
		if(nowPage<=2 && pageSize>=5) {
			nowPage = 3L;
		}
		List<Long> li = new ArrayList();
		for(int i=-2; i<=2; i++) {
			Long result = nowPage + i;
			if(result >= 1 && result <= pageSize) {
				li.add(result);				
			}
		}
		if(li.size()<5 && li.get(0) >2) {
			Long differnce = pageSize - nowPage;
			if(differnce == 1) {
				li.add(0,li.get(0)-1);
			} else if(differnce == 0 ) {
				li.add(0,li.get(0)-1);
				li.add(0,li.get(0)-1);
			}
		}
		pageList = li;
	}

}
