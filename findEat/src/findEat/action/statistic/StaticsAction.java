package findEat.action.statistic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.CalendarVO;
import findEat.DB.dao.CalendarDAOImpl;

@Controller
public class StaticsAction {
	
	private Calendar cal		= new GregorianCalendar();
	private SortClass sort		= new SortClass();
	private CalendarVO calVO	= new CalendarVO();
	private List<CalendarVO> monthCalList			= null;
	private List<CalendarVO> monthCalListUser		= null;
	
	private Map<String, Integer> foodTotal				= null;
	private Map<String, Integer> monFoodTotal			= null;
	private Map<String, Integer> tueFoodTotal			= null;
	private Map<String, Integer> wedFoodTotal			= null;
	private Map<String, Integer> thuFoodTotal			= null;
	private Map<String, Integer> friFoodTotal			= null;
	private Map<String, Integer> categoryTotal			= null;
	private Map<String, Integer> monCategoryTotal		= null;
	private Map<String, Integer> tueCategoryTotal		= null;
	private Map<String, Integer> wedCategoryTotal		= null;
	private Map<String, Integer> thuCategoryTotal		= null;
	private Map<String, Integer> friCategoryTotal		= null;
	
	private Map<String, Integer> foodUser				= null;
	private Map<String, Integer> monFoodUser			= null;
	private Map<String, Integer> tueFoodUser			= null;
	private Map<String, Integer> wedFoodUser			= null;
	private Map<String, Integer> thuFoodUser			= null;
	private Map<String, Integer> friFoodUser			= null;
	private Map<String, Integer> categoryUser			= null;
	private Map<String, Integer> monCategoryUser		= null;
	private Map<String, Integer> tueCategoryUser		= null;
	private Map<String, Integer> wedCategoryUser		= null;
	private Map<String, Integer> thuCategoryUser		= null;
	private Map<String, Integer> friCategoryUser		= null;
	
	@Autowired
	private CalendarDAOImpl calDAO	= null;
	
	@RequestMapping("statistic.do")
	public String statics(HttpServletRequest request) throws Exception {
		String id	= null;
		int month	= cal.get(Calendar.MONTH)+1;
		
		if(request.getSession().getAttribute("id")!=null) {
			id	= (String)request.getSession().getAttribute("id");
		}
		if(id!=null) {
			calVO.setId(id);
			calVO.setFmonth(month);
			monthCalList		= calDAO.TotalMonth(month);
			monthCalListUser	= calDAO.UserMonth(calVO);
			
			foodTotal			= sort.TotalMap(monthCalList, "food");
			monFoodTotal		= sort.DayMap(monthCalList, "food", 1);
			tueFoodTotal		= sort.DayMap(monthCalList, "food", 2);
			wedFoodTotal		= sort.DayMap(monthCalList, "food", 3);
			thuFoodTotal		= sort.DayMap(monthCalList, "food", 4);
			friFoodTotal		= sort.DayMap(monthCalList, "food", 5);
			categoryTotal		= sort.TotalMap(monthCalList, "category");
			monCategoryTotal	= sort.DayMap(monthCalList, "category", 1);
			tueCategoryTotal	= sort.DayMap(monthCalList, "category", 2);
			wedCategoryTotal	= sort.DayMap(monthCalList, "category", 3);
			thuCategoryTotal	= sort.DayMap(monthCalList, "category", 4);
			friCategoryTotal	= sort.DayMap(monthCalList, "category", 5);
			
			foodUser			= sort.TotalMap(monthCalListUser, "food");
			monFoodUser			= sort.DayMap(monthCalListUser, "food", 1);
			tueFoodUser			= sort.DayMap(monthCalListUser, "food", 2);
			wedFoodUser			= sort.DayMap(monthCalListUser, "food", 3);
			thuFoodUser			= sort.DayMap(monthCalListUser, "food", 4);
			friFoodUser			= sort.DayMap(monthCalListUser, "food", 5);
			categoryUser		= sort.TotalMap(monthCalListUser, "category");
			monCategoryUser		= sort.DayMap(monthCalListUser, "category", 1);
			tueCategoryUser		= sort.DayMap(monthCalListUser, "category", 2);
			wedCategoryUser		= sort.DayMap(monthCalListUser, "category", 3);
			thuCategoryUser		= sort.DayMap(monthCalListUser, "category", 4);
			friCategoryUser		= sort.DayMap(monthCalListUser, "category", 5);
			
			request.setAttribute("foodTotal", foodTotal);
			request.setAttribute("monFoodTotal", monFoodTotal);
			request.setAttribute("tueFoodTotal", tueFoodTotal);
			request.setAttribute("wedFoodTotal", wedFoodTotal);
			request.setAttribute("thuFoodTotal", thuFoodTotal);
			request.setAttribute("friFoodTotal", friFoodTotal);
			request.setAttribute("categoryTotal", categoryTotal);
			request.setAttribute("monCategoryTotal", monCategoryTotal);	
			request.setAttribute("tueCategoryTotal", tueCategoryTotal);
			request.setAttribute("wedCategoryTotal", wedCategoryTotal);
			request.setAttribute("thuCategoryTotal", thuCategoryTotal);
			request.setAttribute("friCategoryTotal", friCategoryTotal);	
			
			request.setAttribute("foodUser", foodUser);
			request.setAttribute("monFoodUser", monFoodUser);
			request.setAttribute("tueFoodUser", tueFoodUser);
			request.setAttribute("wedFoodUser", wedFoodUser);
			request.setAttribute("thuFoodUser", thuFoodUser);
			request.setAttribute("friFoodUser", friFoodUser);
			request.setAttribute("categoryUser", categoryUser);
			request.setAttribute("monCategoryUser", monCategoryUser);	
			request.setAttribute("tueCategoryUser", tueCategoryUser);
			request.setAttribute("wedCategoryUser", wedCategoryUser);
			request.setAttribute("thuCategoryUser", thuCategoryUser);
			request.setAttribute("friCategoryUser", friCategoryUser);
		}
		
		
		request.setAttribute("currentMonth", month);
		
		return "statistic/totalStatistic";
	}
}
