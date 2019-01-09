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
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession	= sqlSession;
	}

	@Override
	public List<CalendarVO> Classifyk(int fweek) throws Exception {
		list = sqlSession.selectList("cal.classifyk", fweek);
		return list;
	}
	@Override
	public List<CalendarVO> Classifyj(int fweek) throws Exception {
		list = sqlSession.selectList("cal.classifyj", fweek);
		return list;
	}
	@Override
	public List<CalendarVO> Classifyc(int fweek) throws Exception {
		list = sqlSession.selectList("cal.classifyc", fweek);
		return list;
	}
	@Override
	public List<CalendarVO> Classifyw(int fweek) throws Exception {
		list = sqlSession.selectList("cal.classifyw", fweek);
		return list;
	}
	@Override
	public List<CalendarVO> Classifyf(int fweek) throws Exception {
		list = sqlSession.selectList("cal.classifyf", fweek);
		return list;
	}
	@Override
	public List<CalendarVO> Classifye(int fweek) throws Exception {
		list = sqlSession.selectList("cal.classifye", fweek);
		return list;
	}
	@Override
	public List<CalendarVO> PClassifyk(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.pclassifyk",map);
		return list;
	}
	@Override
	public List<CalendarVO> PClassifyj(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.pclassifyj",map);
		return list;
	}
	@Override
	public List<CalendarVO> PClassifyc(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.pclassifyc",map);
		return list;
	}
	@Override
	public List<CalendarVO> PClassifyw(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.pclassifyw",map);
		return list;
	}
	
	@Override
	public List<CalendarVO> PClassifyf(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.pclassifyf",map);
		return list;
	}
	@Override
	public List<CalendarVO> PClassifye(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.pclassifye",map);
		return list;
	}

}
