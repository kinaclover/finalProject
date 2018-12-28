package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.CalendarVO;
import findEat.DB.bean.FoodVO;

public class CalendarDAOImpl implements CalendarDAO {
	
	private SqlSessionTemplate sqlSession	= null;
	private CalendarVO calVO				= null;
	private List<CalendarVO> list			= null;
	private Map<String, String> map		= new HashMap<>();
		
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession	= sqlSession;
	}
	public void setCalVO(CalendarVO calVO) {
		this.calVO	= calVO;
	}
	
	/* override methods*/
	
	@Override
	public List<CalendarVO> TotalList() throws Exception {
		list	= sqlSession.selectList("cal.all");
		return list;
	}

	@Override
	public List<CalendarVO> SelectAll(String id) throws Exception {
		list	= sqlSession.selectList("cal.select",id);
		return list;
	}
	@Override
	public List<CalendarVO> TotalWeekList(int fweek) throws Exception {
		list	= sqlSession.selectList("cal.totalWeek",fweek);
		return list;
	}
	@Override
	public List<CalendarVO> SelectThisWeek(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.thisWeek",map);
		return list;
	}

}
