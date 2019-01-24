package findEat.action.statistic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
	private List<Map<String,Integer>> statisticList	= null;
	
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
		int year	= 0;
		int month	= 0;
		String id	= null;
		if(request.getParameter("year")==null) {
			year	= cal.get(Calendar.YEAR);
			month	= cal.get(Calendar.MONTH)+1;
		}else {
			year	= Integer.parseInt(request.getParameter("year"));
			month	= Integer.parseInt(request.getParameter("month"));
		}
		if(request.getSession().getAttribute("id")!=null) id = (String)request.getSession().getAttribute("id");
		if(id!=null) {
			statisticList	= statisticGraph(year,month,id);
			request.setAttribute("statisticList", statisticList);
		}

		request.setAttribute("currentYear", year);
		request.setAttribute("currentMonth", month);
		
		return "statistic/totalStatistic";
	}
	
	public List<Map<String,Integer>> statisticGraph(int year, int month, String id) throws Exception {
		if(id!=null) {
			calVO.setId(id);
			calVO.setFyear(year);
			calVO.setFmonth(month);
			monthCalList		= calDAO.TotalMonth(year,month);
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
			foodUser			= sort.EmptyCheck(foodUser);
			monFoodUser			= sort.EmptyCheck(monFoodUser);
			tueFoodUser			= sort.EmptyCheck(tueFoodUser);
			wedFoodUser			= sort.EmptyCheck(wedFoodUser);
			thuFoodUser			= sort.EmptyCheck(thuFoodUser);
			friFoodUser			= sort.EmptyCheck(friFoodUser);
			categoryUser		= sort.TotalMap(monthCalListUser, "category");
			monCategoryUser		= sort.DayMap(monthCalListUser, "category", 1);
			tueCategoryUser		= sort.DayMap(monthCalListUser, "category", 2);
			wedCategoryUser		= sort.DayMap(monthCalListUser, "category", 3);
			thuCategoryUser		= sort.DayMap(monthCalListUser, "category", 4);
			friCategoryUser		= sort.DayMap(monthCalListUser, "category", 5);
			
			statisticList	= new ArrayList<>();
			statisticList.add(foodTotal);			//0
			statisticList.add(monFoodTotal);		//1
			statisticList.add(tueFoodTotal);		//2
			statisticList.add(wedFoodTotal);		//3
			statisticList.add(thuFoodTotal);		//4
			statisticList.add(friFoodTotal);		//5
			statisticList.add(categoryTotal);		//6
			statisticList.add(monCategoryTotal);	//7
			statisticList.add(tueCategoryTotal);	//8
			statisticList.add(wedCategoryTotal);	//9
			statisticList.add(thuCategoryTotal);	//10
			statisticList.add(friCategoryTotal);	//11
			
			statisticList.add(foodUser);			//12
			statisticList.add(monFoodUser);			//13
			statisticList.add(tueFoodUser);			//14
			statisticList.add(wedFoodUser);			//15
			statisticList.add(thuFoodUser);			//16
			statisticList.add(friFoodUser);			//17
			statisticList.add(categoryUser);		//18
			statisticList.add(monCategoryUser);		//19
			statisticList.add(tueCategoryUser);		//20
			statisticList.add(wedCategoryUser);		//21
			statisticList.add(thuCategoryUser);		//22
			statisticList.add(friCategoryUser);		//23
			
			return statisticList;
		}else {
			return Collections.emptyList();
		}
	}
}
