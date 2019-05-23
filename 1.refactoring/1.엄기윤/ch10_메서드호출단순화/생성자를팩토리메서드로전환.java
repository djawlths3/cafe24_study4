package ch10;

import com.cafe24.mysite1.action.guestbook.AddAction;
import com.cafe24.mysite1.action.guestbook.Delete;
import com.cafe24.mysite1.action.guestbook.Deleteform;
import com.cafe24.mysite1.action.guestbook.ListAction;
import com.cafe24.web.mvc.Action;

public class 생성자를팩토리메서드로전환 {
	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("add".equals(actionName)) {
			action = new AddAction();
		} else if("deleteform".equals(actionName)) {
			action = new Deleteform();
		} else if("delete".equals(actionName)) {
			action = new Delete();
		} else {
			action = new ListAction();
		}
		return action;
	}
}
