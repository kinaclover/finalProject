package findEat.action.main;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.CalendarVO;
import findEat.DB.dao.CalendarDAOImpl;

@Controller
public class SuggestAction {
	
	/***********************************************************************************************************************/
	//test version - suggestion_ver2
	private List<CalendarVO> totalClassifyList	= null;
	private List<String> weekList				= null;		//이번주에 먹은 음식
	private List<CalendarVO> userClassifyList	= null;
	private List<CalendarVO> totalKList			= null;
	private List<CalendarVO> totalJList			= null;
	private List<CalendarVO> totalCList			= null;
	private List<CalendarVO> totalWList			= null;
	private List<CalendarVO> totalFList			= null;
	private List<CalendarVO> totalEList			= null;
	private List<CalendarVO> userKList			= null;
	private List<CalendarVO> userJList			= null;
	private List<CalendarVO> userCList			= null;
	private List<CalendarVO> userWList			= null;
	private List<CalendarVO> userFList			= null;
	private List<CalendarVO> userEList			= null;
	private Map<String,Integer> totalClassifyMap	= null;		//전체 분류통계용 자료
	private Map<String,Integer> userClassifyMap		= null;		//전체 분류통계용 자료
	private Map<String,Integer> totalRankMap	= null;
	private Map<String,Integer> userRankMap		= null;
	private Map<String,Integer> totalKMap		= null;
	private Map<String,Integer> totalJMap		= null;
	private Map<String,Integer> totalCMap		= null;
	private Map<String,Integer> totalWMap		= null;
	private Map<String,Integer> totalFMap		= null;
	private Map<String,Integer> totalEMap		= null;
	private Map<String,Integer> userKMap		= null;
	private Map<String,Integer> userJMap		= null;
	private Map<String,Integer> userCMap		= null;
	private Map<String,Integer> userWMap		= null;
	private Map<String,Integer> userFMap		= null;
	private Map<String,Integer> userEMap		= null;
	
	private MapSort sort	= new MapSort();						//map 정렬을 위한 함수
	
	private Calendar cal	= new GregorianCalendar();
	
	@Autowired
	private CalendarDAOImpl calDAO	= null;

	
	/***********************************************************************************************************************/
	//test version - suggestion_ver2
	@RequestMapping("suggestion.do")
	public String sugVer2(HttpServletRequest request) throws Exception {
		//
		int week	= cal.get(Calendar.WEEK_OF_YEAR);		//오늘의 주 번호
		int day		= cal.get(Calendar.DAY_OF_WEEK) - 1;	//오늘의 요일
		String id	= null;		//id확인
		if(request.getSession().getAttribute("id")!=null) id = (String)request.getSession().getAttribute("id");
		
		totalClassifyList	= calDAO.TotalClassifyList(day);
		weekList			= calDAO.ThisWeekList(week);
		
		//user check
		if(id!=null) {
			userClassifyList	= sort.SetListByID(totalClassifyList, id);
			
			if(!userClassifyList.isEmpty()) {
				userKList	= sort.SetListByClassify(userClassifyList, "k");
				userJList	= sort.SetListByClassify(userClassifyList, "j");
				userCList	= sort.SetListByClassify(userClassifyList, "c");
				userWList	= sort.SetListByClassify(userClassifyList, "w");
				userFList	= sort.SetListByClassify(userClassifyList, "f");
				userEList	= sort.SetListByClassify(userClassifyList, "e");
			}
		}else {
			userClassifyList	= Collections.emptyList();
		}
		//total check
		totalKList	= sort.SetListByClassify(totalClassifyList, "k");
		totalJList	= sort.SetListByClassify(totalClassifyList, "j");
		totalCList	= sort.SetListByClassify(totalClassifyList, "c");
		totalWList	= sort.SetListByClassify(totalClassifyList, "w");
		totalFList	= sort.SetListByClassify(totalClassifyList, "f");
		totalEList	= sort.SetListByClassify(totalClassifyList, "e");
		
		//user map insert&sort
		if(!userClassifyList.isEmpty()) {
			userRankMap	= sort.InsertAndSortWeek(userClassifyList,weekList);
			userKMap	= sort.InsertAndSortWeek(userKList,weekList);
			userJMap	= sort.InsertAndSortWeek(userJList,weekList);
			userCMap	= sort.InsertAndSortWeek(userCList,weekList);
			userWMap	= sort.InsertAndSortWeek(userWList,weekList);
			userFMap	= sort.InsertAndSortWeek(userFList,weekList);
			userEMap	= sort.InsertAndSortWeek(userEList,weekList);
		}
		//total map insert&sort
		totalRankMap	= sort.InsertAndSort(totalClassifyList);
		totalKMap		= sort.InsertAndSort(totalKList);
		totalJMap		= sort.InsertAndSort(totalJList);
		totalCMap		= sort.InsertAndSort(totalCList);
		totalWMap		= sort.InsertAndSort(totalWList);
		totalFMap		= sort.InsertAndSort(totalFList);
		totalEMap		= sort.InsertAndSort(totalEList);
		
		//전체 통계용
		totalClassifyMap	= sort.TotalClassify(totalClassifyList);
		userClassifyMap		= sort.TotalClassify(userClassifyList);
		request.setAttribute("totalClassifyMap", totalClassifyMap);
		request.setAttribute("userClassifyMap", userClassifyMap);
		
		if(!userClassifyList.isEmpty()) {
			request.setAttribute("userRankMap", userRankMap);
			request.setAttribute("userKMap", userKMap);
			request.setAttribute("userJMap", userJMap);
			request.setAttribute("userCMap", userCMap);
			request.setAttribute("userWMap", userWMap);
			request.setAttribute("userFMap", userFMap);
			request.setAttribute("userEMap", userEMap);
		}
		request.setAttribute("totalRankMap", totalRankMap);
		request.setAttribute("totalKMap", totalKMap);
		request.setAttribute("totalJMap", totalJMap);
		request.setAttribute("totalCMap", totalCMap);
		request.setAttribute("totalWMap", totalWMap);
		request.setAttribute("totalFMap", totalFMap);
		request.setAttribute("totalEMap", totalEMap);
		
		return "/main/suggestion";
	}
}
