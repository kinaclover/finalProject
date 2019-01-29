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

	/***********************************************************************************************************************/
	/*
	 *	*** 월별 통계를 위한 페이지
	 *
	 *	Statistic Action class
	 *	- 해당 월의 전체 통계수치를 연산, 전달
	 *	- 전달하는 Map객체의 size가 10 미만일 경우 빈값을 넣어서 전달
	 *	- 모든 Map객체들을 하나의 리스트에 묶어서 전달 / 순서에 유의 - view 페이지 참고
	 *
	/***********************************************************************************************************************/
	
	private Calendar cal		= new GregorianCalendar();			//연,월,일 값을 가져오기 위한 달력 객체
	private SortClass sort		= new SortClass();					//정렬을 위한 함수 클래스
	
	private List<CalendarVO> monthCalList				= null;		//DB에서 해당 월의 전체 자료 호출
	private List<CalendarVO> monthCalListUser			= null;		//DB에서 받은 리스트 중 회원의 자료 분류
	
	private Map<String, Integer> foodTotal				= null;		//해당 월의 전체 순위
	private Map<String, Integer> monFoodTotal			= null;		//해당 월의 월요일 순위
	private Map<String, Integer> tueFoodTotal			= null;		//해당 월의 화요일 순위
	private Map<String, Integer> wedFoodTotal			= null;		//해당 월의 수요일 순위
	private Map<String, Integer> thuFoodTotal			= null;		//해당 월의 목요일 순위
	private Map<String, Integer> friFoodTotal			= null;		//해당 월의 금요일 순위
	private Map<String, Integer> categoryTotal			= null;		//해당 월의 전체 카테고리 순위
	private Map<String, Integer> monCategoryTotal		= null;		//해당 월의 월요일 카테고리 순위
	private Map<String, Integer> tueCategoryTotal		= null;		//해당 월의 화요일 카테고리 순위
	private Map<String, Integer> wedCategoryTotal		= null;		//해당 월의 수요일 카테고리 순위
	private Map<String, Integer> thuCategoryTotal		= null;		//해당 월의 목요일 카테고리 순위
	private Map<String, Integer> friCategoryTotal		= null;		//해당 월의 금요일 카테고리 순위
	
	private Map<String, Integer> foodUser				= null;		//해당 월의 회원 전체 순위
	private Map<String, Integer> monFoodUser			= null;		//해당 월의 회원 월요일 순위
	private Map<String, Integer> tueFoodUser			= null;		//해당 월의 회원 화요일 순위
	private Map<String, Integer> wedFoodUser			= null;		//해당 월의 회원 수요일 순위
	private Map<String, Integer> thuFoodUser			= null;		//해당 월의 회원 목요일 순위
	private Map<String, Integer> friFoodUser			= null;		//해당 월의 회원 금요일 순위
	private Map<String, Integer> categoryUser			= null;		//해당 월의 회원 카테고리 순위
	private Map<String, Integer> monCategoryUser		= null;		//해당 월의 월요일(회원) 카테고리 순위
	private Map<String, Integer> tueCategoryUser		= null;		//해당 월의 화요일(회원) 카테고리 순위
	private Map<String, Integer> wedCategoryUser		= null;		//해당 월의 수요일(회원) 카테고리 순위
	private Map<String, Integer> thuCategoryUser		= null;		//해당 월의 목요일(회원) 카테고리 순위
	private Map<String, Integer> friCategoryUser		= null;		//해당 월의 금요일(회원) 카테고리 순위
	
	@Autowired
	private CalendarDAOImpl calDAO	= null;
	
	@RequestMapping("statistic.do")
	public String statics(HttpServletRequest request) throws Exception {
		int year		= 0;
		int month		= 0;
		int fixedYear	= cal.get(Calendar.YEAR);
		int fixedMonth	= cal.get(Calendar.MONTH)+1;
		String id	= null;
		if(request.getParameter("year")==null) {								//쿼리스트링으로 받는 값이 없을 경우 오늘의 데이터 사용 
			year	= fixedYear;
			month	= fixedMonth;
		}else {																	//쿼리스트링으로 받는 값이 있을 경우 입력
			year	= Integer.parseInt(request.getParameter("year"));
			month	= Integer.parseInt(request.getParameter("month"));
		}
		if(request.getSession().getAttribute("id")!=null) id = (String)request.getSession().getAttribute("id");
		if(id!=null) {
			monthCalList		= calDAO.TotalMonth(year,month);				//DB에서 자료 호출
			monthCalListUser	= sort.UserList(monthCalList, id);				//DB에서 받은 자료에서 해당 아이디로 분류
			
			//전체 데이터 분류 및 정렬
			foodTotal			= sort.TotalMap(monthCalList, "food");
			monFoodTotal		= sort.DayMap(monthCalList, "food", 1);
			tueFoodTotal		= sort.DayMap(monthCalList, "food", 2);
			wedFoodTotal		= sort.DayMap(monthCalList, "food", 3);
			thuFoodTotal		= sort.DayMap(monthCalList, "food", 4);
			friFoodTotal		= sort.DayMap(monthCalList, "food", 5);
			//값이 충분하지 않을 경우 빈 값으로 채
			foodTotal			= sort.EmptyCheck(foodTotal);
			monFoodTotal		= sort.EmptyCheck(monFoodTotal);
			tueFoodTotal		= sort.EmptyCheck(tueFoodTotal);
			wedFoodTotal		= sort.EmptyCheck(wedFoodTotal);
			thuFoodTotal		= sort.EmptyCheck(thuFoodTotal);
			friFoodTotal		= sort.EmptyCheck(friFoodTotal);
			categoryTotal		= sort.TotalMap(monthCalList, "category");
			monCategoryTotal	= sort.DayMap(monthCalList, "category", 1);
			tueCategoryTotal	= sort.DayMap(monthCalList, "category", 2);
			wedCategoryTotal	= sort.DayMap(monthCalList, "category", 3);
			thuCategoryTotal	= sort.DayMap(monthCalList, "category", 4);
			friCategoryTotal	= sort.DayMap(monthCalList, "category", 5);
			
			//전체 데이터 분류 및 정렬(회원)
			foodUser			= sort.TotalMap(monthCalListUser, "food");
			monFoodUser			= sort.DayMap(monthCalListUser, "food", 1);
			tueFoodUser			= sort.DayMap(monthCalListUser, "food", 2);
			wedFoodUser			= sort.DayMap(monthCalListUser, "food", 3);
			thuFoodUser			= sort.DayMap(monthCalListUser, "food", 4);
			friFoodUser			= sort.DayMap(monthCalListUser, "food", 5);
			//회원의 경우 값이 비어있을 경우 빈 값으로 값을 채워줌 >> 그래프에서의 null 방지
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

		request.setAttribute("currentYear", year);
		request.setAttribute("currentMonth", month);
		request.setAttribute("fixedYear", fixedYear);
		request.setAttribute("fixedMonth",fixedMonth);
		
		return "statistic/totalStatistic";
	}
}
