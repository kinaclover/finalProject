package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.CalendarVO;

public interface CalendarDAO {
	
	/*
	 *	메인페이지 추천항목/통계페이지 DAO
	 *	- 해당 요일과 이번주의 리스트 호출
	 *	- 입력된 년/월 에 따른 리스트 호출
	 *
	 */
	//메인페이지 추천 항목
	public List<CalendarVO> TotalClassifyList() throws Exception;				//전체 기간의 calendar DB 전체 값
	public List<String> ThisWeekList(int week) throws Exception;				//현재 주의 음식목록
	
	//통계페이지용 자료
	public List<CalendarVO> TotalMonth(int year, int month) throws Exception;	//입력된 년도,월 에 따른 Calendar DB 값
}
