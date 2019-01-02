package findEat.action.cal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.IndexCalendarVO;
import findEat.DB.dao.IndexCalendarDAOImpl;

@Controller
public class CalendarAction {
	
	@Autowired
	private IndexCalendarVO calVO = null;

}
