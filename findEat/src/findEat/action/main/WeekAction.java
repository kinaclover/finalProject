package findEat.action.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.CalendarVO;
import findEat.DB.dao.IndexCalendarDAOImpl;

@Controller
public class WeekAction {

	/***********************************************************************************************************************/
	/*	
	 *	*** 메인페이지의 주단위 음식순위 및 이번주의 식단
	 * 
	 * 	Week Action class
	 * 	- index 페이지의 월~금 목록 표시
	 * 	- 페이지 및 스크립트에서 total/personal 로 구분
	 * 
	/***********************************************************************************************************************/
	
	private List<CalendarVO> totalList				= null;			//전체 음식목록
	private List<CalendarVO> totalWeekList			= null;			//이번주 전체 음식목록
	private List<CalendarVO> list					= null;			//회원 전체 음식목록
	private List<CalendarVO> weekList				= null;			//이번주 회원 전체 음식목록
	
	private Map<String,Integer> totalMonList		= null;			//전체 월요일 음식목록
	private Map<String,Integer> totalTueList		= null;			//전체 화요일 음식목록
	private Map<String,Integer> totalWedList		= null;			//전체 수요일 음식목록
	private Map<String,Integer> totalThuList		= null;			//전체 목요일 음식목록
	private Map<String,Integer> totalFriList		= null;			//전체 금요일 음식목록
	
	private Map<String,Integer> totalWeekMonList	= null;			//전체 이번주 월요일 음식목록
	private Map<String,Integer> totalWeekTueList	= null;			//전체 이번주 화요일 음식목록
	private Map<String,Integer> totalWeekWedList	= null;			//전체 이번주 수요일 음식목록
	private Map<String,Integer> totalWeekThuList	= null;			//전체 이번주 목요일 음식목록 
	private Map<String,Integer> totalWeekFriList	= null;			//전체 이번주 금요일 음식목록
	
	private Map<String,Integer> monList				= null;			//회원 월요일 음식목록
	private Map<String,Integer> tueList				= null;			//회원 화요일 음식목록
	private Map<String,Integer> wedList				= null;			//회원 수요일 음식목록
	private Map<String,Integer> thuList				= null;			//회원 목요일 음식목록
	private Map<String,Integer> friList				= null;			//회원 금요일 음식목록
	
	private MapSort sort	= new MapSort();						//map 정렬을 위한 함수
	private Calendar cal	= new GregorianCalendar();				//주, 요일 값을 위한 달력 객체
	
	@Autowired
	private IndexCalendarDAOImpl indexCalDAO	= null;
	
	@RequestMapping("week.do")
	public String week(HttpServletRequest request) throws Exception {
		int week	= cal.get(Calendar.WEEK_OF_YEAR);
		int day		= cal.get(Calendar.DAY_OF_WEEK);
		
		/*
		 * 	Calendar.DAY_OF_WEEK value
		 * 	- Monday	: 2
		 * 	- Tuesday	: 3
		 * 	- Wednesday	: 4
		 * 	- Thursday	: 5
		 * 	- Friday	: 6
		 * 	- 스크립트에서의 값보다 1씩 많음 / DB에 저장은 스크립트에서의 값을 기준
		 */
		
		//total list
		totalList		= indexCalDAO.TotalList();							//DB에서 전체 자료 호출
		//요일별로 분류,정렬(desc)
		totalMonList	= sort.ListUpforDay(totalList, 1);
		totalTueList	= sort.ListUpforDay(totalList, 2);
		totalWedList	= sort.ListUpforDay(totalList, 3);
		totalThuList	= sort.ListUpforDay(totalList, 4);
		totalFriList	= sort.ListUpforDay(totalList, 5);
		
		//total 이번주 목록 - 일요일은 건너뜀
		if(day>1) {
			totalWeekList		= indexCalDAO.TotalWeekList(week);
			totalWeekMonList	= sort.ListUpforDay(totalWeekList, 1);
			totalWeekTueList	= sort.ListUpforDay(totalWeekList, 2);
			totalWeekWedList	= sort.ListUpforDay(totalWeekList, 3);
			totalWeekThuList	= sort.ListUpforDay(totalWeekList, 4);
			totalWeekFriList	= sort.ListUpforDay(totalWeekList, 5);
		}
		
		//personal list
		if(request.getSession().getAttribute("id")!=null) {
			String id	= (String)request.getSession().getAttribute("id");
			list		= indexCalDAO.SelectAll(id);						//DB에서 해당 아이디의 전체 자료 호출
			//요일별로 분류,정렬(desc)
			monList		= sort.ListUpforDay(list, 1);
			tueList		= sort.ListUpforDay(list, 2);
			wedList		= sort.ListUpforDay(list, 3);
			thuList		= sort.ListUpforDay(list, 4);
			friList		= sort.ListUpforDay(list, 5);
			
			//일요일은 건너뜀
			if(day>1) weekList	= indexCalDAO.SelectThisWeek(id, week);	
			
			request.setAttribute("monList", monList);
			request.setAttribute("tueList", tueList);
			request.setAttribute("wedList", wedList);
			request.setAttribute("thuList", thuList);
			request.setAttribute("friList", friList);
			request.setAttribute("weekList", weekList);
		}
		
		request.setAttribute("totalMonList", totalMonList);
		request.setAttribute("totalTueList", totalTueList);
		request.setAttribute("totalWedList", totalWedList);
		request.setAttribute("totalThuList", totalThuList);
		request.setAttribute("totalFriList", totalFriList);
		request.setAttribute("totalWeekMonList", totalWeekMonList);
		request.setAttribute("totalWeekTueList", totalWeekTueList);
		request.setAttribute("totalWeekWedList", totalWeekWedList);
		request.setAttribute("totalWeekThuList", totalWeekThuList);
		request.setAttribute("totalWeekFriList", totalWeekFriList);
		
		return "/main/week";
	}
}
