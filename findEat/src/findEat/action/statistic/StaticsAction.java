package findEat.action.statistic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
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
	
	private Calendar cal	= new GregorianCalendar();
	private SortClass sort	= new SortClass();
	private List<CalendarVO> monthCalList			= null;
	
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
	
	@Autowired
	private CalendarDAOImpl calDAO	= null;
	
	@RequestMapping("statistic.do")
	public String statics(HttpServletRequest request) throws Exception {
		int month	= cal.get(Calendar.MONTH)+1;
		monthCalList	= calDAO.TotalMonth(month);
		
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
		
		request.setAttribute("food-total", foodTotal);
		request.setAttribute("monFood-total", monFoodTotal);
		request.setAttribute("tueFood-total", tueFoodTotal);
		request.setAttribute("wedFood-total", wedFoodTotal);
		request.setAttribute("thuFood-total", thuFoodTotal);
		request.setAttribute("friFood-total", friFoodTotal);
		request.setAttribute("category-total", categoryTotal);
		request.setAttribute("monCategory-total", monCategoryTotal);	
		request.setAttribute("tueCategory-total", tueCategoryTotal);
		request.setAttribute("wedCategory-total", wedCategoryTotal);
		request.setAttribute("thuCategory-total", thuCategoryTotal);
		request.setAttribute("friCategory-total", friCategoryTotal);	
		
		return "statistic/totalStatistic";
	}
}
