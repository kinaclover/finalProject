package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.CalendarVO;

public class CalendarDAOImpl implements CalendarDAO {
	
	private SqlSessionTemplate sqlSession	= null;
	private List<CalendarVO> list			= null;
	private Map<String, String> map			= new HashMap<>();
	//for suggestion ver2
	private List<String> weekList			= null;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession	= sqlSession;
	}

	/**************************************************************************************************/
	//suggestion-ver2
	@Override
	public List<CalendarVO> TotalClassifyList(int day) throws Exception {
		list	= sqlSession.selectList("cal.totalClassifyList",day);
		return list;
	}
	@Override
	public List<String> ThisWeekList(int week) throws Exception {
		weekList	= sqlSession.selectList("cal.weekList",week);
		return weekList;
	}
}
