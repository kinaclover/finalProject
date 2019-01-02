package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.IndexCalendarVO;
import findEat.DB.bean.FoodVO;

public class IndexCalendarDAOImpl implements IndexCalendarDAO {
	
	private SqlSessionTemplate sqlSession	= null;
	private IndexCalendarVO calVO				= null;
	private List<IndexCalendarVO> list			= null;
	private Map<String, String> map		= new HashMap<>();
		
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession	= sqlSession;
	}
	public void setCalVO(IndexCalendarVO calVO) {
		this.calVO	= calVO;
	}
	
	/* override methods*/
	
	@Override
	public List<IndexCalendarVO> TotalList() throws Exception {
		list	= sqlSession.selectList("cal.all");
		return list;
	}

	@Override
	public List<IndexCalendarVO> SelectAll(String id) throws Exception {
		list	= sqlSession.selectList("cal.select",id);
		return list;
	}
	@Override
	public List<IndexCalendarVO> TotalWeekList(int fweek) throws Exception {
		list	= sqlSession.selectList("cal.totalWeek",fweek);
		return list;
	}
	@Override
	public List<IndexCalendarVO> SelectThisWeek(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.thisWeek",map);
		return list;
	}

}
