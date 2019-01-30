package findEat.action.main;

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
public class SuggestAction {

	/***********************************************************************************************************************/
	/*	
	 * *** 메인페이지 하단에 표시되는 오늘의 메뉴 추천
	 *
	 *	Suggest Action class
	 * 	- index페이지 하단의 추천 통계
	 * 	- 해당 요일의 전체 랭킹, 카테고리별 랭킹 
	 * 
	/***********************************************************************************************************************/
	
	private List<CalendarVO> totalClassifyList		= null;			//해당 요일의 전체 음식 리스트
	private List<CalendarVO> userClassifyList		= null;			//회원의 해당 요일의 전체 음식 리스트
	private List<String>	 weekList				= null;			//이번주에 먹은 음식
	
	private Map<String,Integer> totalClassifyMap	= null;			//전체 분류통계용 자료
	private Map<String,Integer> userClassifyMap		= null;			//전체 분류통계용 자료
	
	private Map<String,Integer> totalRankMap		= null;			//전체 음식 순위			- total
	private Map<String,Integer> totalKMap			= null;			//전체 한식 순위			- total
	private Map<String,Integer> totalJMap			= null;			//전체 일식 순위			- total
	private Map<String,Integer> totalCMap			= null;			//전체 중식 순위			- total
	private Map<String,Integer> totalWMap			= null;			//전체 양식 순위			- total
	private Map<String,Integer> totalFMap			= null;			//전체 패스트푸드/분식 순위	- total
	private Map<String,Integer> totalEMap			= null;			//전체 기타 순위			- total
	
	private Map<String,Integer> userRankMap			= null;			//전체 음식 순위			- user
	private Map<String,Integer> userKMap			= null;			//전체 한식 순위			- user
	private Map<String,Integer> userJMap			= null;			//전체 일식 순위			- user	
	private Map<String,Integer> userCMap			= null;			//전체 중식 순위			- user
	private Map<String,Integer> userWMap			= null;			//전체 양식 순위			- user
	private Map<String,Integer> userFMap			= null;			//전체 패스트푸드/분식 순위	- user
	private Map<String,Integer> userEMap			= null;			//전체 기타 순위			- user
	
	private MapSort sort	= new MapSort();						//map 정렬을 위한 함수
	private Calendar cal	= new GregorianCalendar();				//오늘의 주,요일 값을 위한 달력 객체
	
	@Autowired
	private CalendarDAOImpl calDAO	= null;
	
	//추천 목록
	@RequestMapping("suggestion.do")
	public String sugVer2(HttpServletRequest request) throws Exception {
		//
		int week	= cal.get(Calendar.WEEK_OF_YEAR);		//오늘의 주 번호
		int day		= cal.get(Calendar.DAY_OF_WEEK) - 1;	//오늘의 요일
		String id	= null;
		if(request.getSession().getAttribute("id")!=null)	//id확인
			id = (String)request.getSession().getAttribute("id");
		
		totalClassifyList	= calDAO.TotalClassifyList();
		weekList			= calDAO.ThisWeekList(week);
		
		//회원일 경우에만 실행
		if(id!=null) {
			userClassifyList	= sort.SetListByID(totalClassifyList, id);
			//회원 리스트의 카테고리별 분류 및 정렬
			if(!userClassifyList.isEmpty()) {
				userRankMap	= sort.InsertAndSortWeek(userClassifyList,weekList);
				userKMap	= sort.SetListByClassifyWeek(userClassifyList, "k", weekList);
				userJMap	= sort.SetListByClassifyWeek(userClassifyList, "j", weekList);
				userCMap	= sort.SetListByClassifyWeek(userClassifyList, "c", weekList);
				userWMap	= sort.SetListByClassifyWeek(userClassifyList, "w", weekList);
				userFMap	= sort.SetListByClassifyWeek(userClassifyList, "f", weekList);
				userEMap	= sort.SetListByClassifyWeek(userClassifyList, "e", weekList);
				
				request.setAttribute("userRankMap", userRankMap);
				request.setAttribute("userKMap", userKMap);
				request.setAttribute("userJMap", userJMap);
				request.setAttribute("userCMap", userCMap);
				request.setAttribute("userWMap", userWMap);
				request.setAttribute("userFMap", userFMap);
				request.setAttribute("userEMap", userEMap);
			}
		}else {
			userClassifyList	= Collections.emptyList();		//null 방지
		}
		//카테고리별 리스트 분류 및 정렬
		totalRankMap	= sort.InsertAndSort(totalClassifyList);
		totalKMap		= sort.SetListByClassify(totalClassifyList, "k");
		totalJMap		= sort.SetListByClassify(totalClassifyList, "j");
		totalCMap		= sort.SetListByClassify(totalClassifyList, "c");
		totalWMap		= sort.SetListByClassify(totalClassifyList, "w");
		totalFMap		= sort.SetListByClassify(totalClassifyList, "f");
		totalEMap		= sort.SetListByClassify(totalClassifyList, "e");
		
		//전체 통계 자료
		totalClassifyMap	= sort.TotalClassify(totalClassifyList);	//전체 
		userClassifyMap		= sort.TotalClassify(userClassifyList);		//회원
		
		request.setAttribute("totalClassifyMap", totalClassifyMap);
		request.setAttribute("userClassifyMap", userClassifyMap);
		
		request.setAttribute("totalRankMap", totalRankMap);
		request.setAttribute("totalKMap", totalKMap);
		request.setAttribute("totalJMap", totalJMap);
		request.setAttribute("totalCMap", totalCMap);
		request.setAttribute("totalWMap", totalWMap);
		request.setAttribute("totalFMap", totalFMap);
		request.setAttribute("totalEMap", totalEMap);
		
		request.setAttribute("day", day);								//현재 요일 값 전송
		
		return "/main/suggestion-index";
	}
}
