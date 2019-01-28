package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.CalendarVO;

public class CalendarDAOImpl implements CalendarDAO {
	
	private SqlSessionTemplate sqlSession	= null;
	private List<CalendarVO> list			= null;
	private Map<String, Integer> map			= new HashMap<>();
	//for suggestion ver2
	private List<String> weekList			= null;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession	= sqlSession;
	}

	/*
	 *	CalendarDAO 구현 클래스 
	 *	- index 페이지의 추천항목관련 DB호출
	 *
	 */
	
	//해당요일의 calendar DB 전체 값
	@Override
	public List<CalendarVO> TotalClassifyList(int day) throws Exception {
		list	= sqlSession.selectList("cal.totalClassifyList",day);
		return list;
	}
	//현재 주의 음식목록
	@Override
	public List<String> ThisWeekList(int week) throws Exception {
		weekList	= sqlSession.selectList("cal.weekList",week);
		return weekList;
	}
	//입력된 년도,월 에 따른 Calendar DB 값
	@Override
	public List<CalendarVO> TotalMonth(int year, int month) throws Exception {
		map.put("fyear", year);
		map.put("fmonth", month);
		list	= sqlSession.selectList("cal.monthList",map);
		return list;
	}
}
