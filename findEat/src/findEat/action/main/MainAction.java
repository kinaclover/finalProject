package findEat.action.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import findEat.DB.bean.BoardVO;
import findEat.DB.bean.CalendarVO;
import findEat.DB.dao.BoardDAOImpl;
import findEat.DB.dao.IndexCalendarDAOImpl;

@Controller
public class MainAction {
	
	private List<CalendarVO> totalList		= null;				//전체 음식목록
	private List<CalendarVO> totalWeekList	= null;				//이번주 전체 음식목록
	private List<CalendarVO> list			= null;				//회원 전체 음식목록
	private List<CalendarVO> weekList		= null;				//이번주 회원 전체 음식목록
	
	private Map<String,Integer> totalMonList	= null;			//전체 월요일 음식목록
	private Map<String,Integer> totalTueList	= null;			//전체 화요일 음식목록
	private Map<String,Integer> totalWedList	= null;			//전체 수요일 음식목록
	private Map<String,Integer> totalThuList	= null;			//전체 목요일 음식목록
	private Map<String,Integer> totalFriList	= null;			//전체 금요일 음식목록
	
	private Map<String,Integer> totalWeekMonList	= null;		//전체 이번주 월요일 음식목록
	private Map<String,Integer> totalWeekTueList	= null;		//전체 이번주 화요일 음식목록
	private Map<String,Integer> totalWeekWedList	= null;		//전체 이번주 수요일 음식목록
	private Map<String,Integer> totalWeekThuList	= null;		//전체 이번주 목요일 음식목록 
	private Map<String,Integer> totalWeekFriList	= null;		//전체 이번주 금요일 음식목록
	
	private Map<String,Integer> monList	= null;					//회원 월요일 음식목록
	private Map<String,Integer> tueList	= null;					//회원 화요일 음식목록
	private Map<String,Integer> wedList	= null;					//회원 수요일 음식목록
	private Map<String,Integer> thuList	= null;					//회원 목요일 음식목록
	private Map<String,Integer> friList	= null;					//회원 금요일 음식목록
	
	private MapSort sort = new MapSort();						//map 정렬을 위한 함수
	
	private Calendar cal	= new GregorianCalendar();
	
	@Autowired
	private IndexCalendarDAOImpl indexCalDAO	= null;
	
	@Autowired
	private BoardDAOImpl boardDAO = null;
	
	@RequestMapping("index.do")
	public String index(HttpServletRequest request) throws Exception {
		int count	= 0;
		int week	= cal.get(Calendar.WEEK_OF_YEAR);
		int day		= cal.get(Calendar.DAY_OF_WEEK);
		
		//total list
		totalList		= indexCalDAO.TotalList();
		totalMonList	= new HashMap<>();
		totalTueList	= new HashMap<>();
		totalWedList	= new HashMap<>();
		totalThuList	= new HashMap<>();
		totalFriList	= new HashMap<>();
		
		//this week total
		for(CalendarVO temp: totalList) {
			switch(temp.getFday()) {
			case 1:
				if(totalMonList.isEmpty()) totalMonList.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :totalMonList.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) totalMonList.put(temp.getFname(), 1);
					count = 0;
				}
				break;
			case 2:
				if(totalTueList.isEmpty()) totalTueList.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :totalTueList.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) totalTueList.put(temp.getFname(), 1);
					count = 0;
				}
				break;
			case 3:
				if(totalWedList.isEmpty()) totalWedList.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :totalWedList.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) totalWedList.put(temp.getFname(), 1);
					count = 0;
				}
				break;
			case 4:
				if(totalThuList.isEmpty()) totalThuList.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :totalThuList.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) totalThuList.put(temp.getFname(), 1);
					count = 0;
				}
				break;
			case 5:
				if(totalFriList.isEmpty()) totalFriList.put(temp.getFname(), 1);
				else {
					for(Map.Entry<String, Integer> x :totalFriList.entrySet()) {
						if(temp.getFname().equals(x.getKey())) {
							x.setValue(x.getValue()+1);
							count++;
						}
					}
					if(count==0) totalFriList.put(temp.getFname(), 1);
					count = 0;
				}
				break;
			}
		}//for end
		
		//total week list
		if(day>2) {
			totalWeekList		= indexCalDAO.TotalWeekList(week);
			totalWeekMonList	= new HashMap<>();
			totalWeekTueList	= new HashMap<>();
			totalWeekWedList	= new HashMap<>();
			totalWeekThuList	= new HashMap<>();
			totalWeekFriList	= new HashMap<>();
			for(CalendarVO temp: totalWeekList) {
				switch(temp.getFday()) {
				case 1:
					if(totalWeekMonList.isEmpty()) totalWeekMonList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:totalWeekMonList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) totalWeekMonList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				case 2:
					if(totalWeekTueList.isEmpty()) totalWeekTueList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:totalWeekTueList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) totalWeekTueList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				case 3:
					if(totalWeekWedList.isEmpty()) totalWeekWedList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:totalWeekWedList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) totalWeekWedList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				case 4:
					if(totalWeekThuList.isEmpty()) totalWeekThuList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:totalWeekThuList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) totalWeekThuList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				case 5:
					if(totalWeekFriList.isEmpty()) totalWeekFriList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:totalWeekFriList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) totalWeekFriList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				}
			}
		}//this week end
		
		//personal list
		if(request.getSession().getAttribute("id")!=null) {
			String id	= (String)request.getSession().getAttribute("id");
			list		= indexCalDAO.SelectAll(id);			//
			monList	= new HashMap<>();
			tueList	= new HashMap<>();
			wedList	= new HashMap<>();
			thuList	= new HashMap<>();
			friList	= new HashMap<>();

			//this week data
			if(day>2) {
				weekList		= indexCalDAO.SelectThisWeek(id, week);
			}//this week data end
			
			//insert to map food list by day
			for(CalendarVO temp: list) {
				switch(temp.getFday()) {
				case 1:
					if(monList.isEmpty()) monList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:monList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) monList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				case 2:
					if(tueList.isEmpty()) tueList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:tueList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) tueList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				case 3:
					if(wedList.isEmpty()) wedList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:wedList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) wedList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				case 4:
					if(thuList.isEmpty()) thuList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:thuList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) thuList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				case 5:
					if(friList.isEmpty()) friList.put(temp.getFname(),1);
					else {
						for(Map.Entry<String, Integer> x:friList.entrySet()) {
							if(temp.getFname().equals(x.getKey())) {
								x.setValue(x.getValue()+1);
								count++;
							}
						}
						if(count==0) friList.put(temp.getFname(),1);
						count = 0;
					}
					break;
				}
			}//for end
			
			//sort maps
			monList	= sort.Sorting(monList);
			tueList	= sort.Sorting(tueList);
			wedList	= sort.Sorting(wedList);
			thuList	= sort.Sorting(thuList);
			friList	= sort.Sorting(friList);
			
			request.setAttribute("monList", monList);
			request.setAttribute("tueList", tueList);
			request.setAttribute("wedList", wedList);
			request.setAttribute("thuList", thuList);
			request.setAttribute("friList", friList);
			request.setAttribute("weekList", weekList);
		}//personal list end
		

		//sort maps
		totalMonList = sort.Sorting(totalMonList);
		totalTueList = sort.Sorting(totalTueList);
		totalWedList = sort.Sorting(totalWedList);
		totalThuList = sort.Sorting(totalThuList);
		totalFriList = sort.Sorting(totalFriList);
		
		totalWeekMonList = sort.Sorting(totalWeekMonList);
		totalWeekTueList = sort.Sorting(totalWeekTueList);
		totalWeekWedList = sort.Sorting(totalWeekWedList);
		totalWeekThuList = sort.Sorting(totalWeekThuList);
		totalWeekFriList = sort.Sorting(totalWeekFriList);
		
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
		
		return "/main/index";
	}
	
	//fixed menu bar
	@RequestMapping("menu.do")
	public String menu(HttpServletRequest request) throws Exception {
		List<BoardVO> noticeList = boardDAO.NoticeList();
		request.setAttribute("noticeList", noticeList);
		return "/menu/menu";
	}
	
	//index modals
	@RequestMapping("indexModal.do")
	public String indexModal() {
		return "/main/indexModal";
	}
}
