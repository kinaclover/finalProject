package findEat.DB.dao;

import java.util.List;
import java.util.Map;

import findEat.DB.bean.CalendarVO;

public interface IndexCalendarDAO {
	/*
	 *	추천리스트 DAO
	 *	- 전체/회원 음식목록 호출, 분류/정렬
	 *
	 */
	public List<CalendarVO> TotalList() throws Exception;							//추천 리스트
	public List<CalendarVO> SelectAll(String id) throws Exception;					//해당 회원의 리스트
	public List<CalendarVO> TotalWeekList(int fweek) throws Exception;				//해당 주의 리스트
	public List<CalendarVO> SelectThisWeek(String id, int fweek) throws Exception;	//해당 회원의 주의 리스트
	
	//Calendar 입력/삭제
	public void InsertMenu(CalendarVO CalVO) throws Exception; 
	public void AndMenu(CalendarVO CalVO) throws Exception;
	public void DeleteMenu(Map<String,Object> data) throws Exception;
}
