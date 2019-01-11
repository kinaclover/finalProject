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
	public List<CalendarVO> DClassifyk(int fday, int fweek) throws Exception {
		map.put("fday", String.valueOf(fday));
		map.put("fweek", String.valueOf(fweek));
		list = sqlSession.selectList("cal.dclassifyk", map);
		return list;
	}
	@Override
	public List<CalendarVO> DClassifyj(int fweek, int fday) throws Exception {
		map.put("fday", String.valueOf(fday));
		map.put("fweek", String.valueOf(fweek));
		list = sqlSession.selectList("cal.dclassifyj", map);
		return list;
	}
	@Override
	public List<CalendarVO> DClassifyc(int fweek, int fday) throws Exception {
		map.put("fday", String.valueOf(fday));
		map.put("fweek", String.valueOf(fweek));
		list = sqlSession.selectList("cal.dclassifyc", map);
		return list;
	}
	@Override
	public List<CalendarVO> DClassifyw(int fweek, int fday) throws Exception {
		map.put("fday", String.valueOf(fday));
		map.put("fweek", String.valueOf(fweek));
		list = sqlSession.selectList("cal.dclassifyw", map);
		return list;
	}
	@Override
	public List<CalendarVO> DClassifyf(int fweek, int fday) throws Exception {
		map.put("fday", String.valueOf(fday));
		map.put("fweek", String.valueOf(fweek));
		list = sqlSession.selectList("cal.dclassifyf", map);
		return list;
	}
	@Override
	public List<CalendarVO> DClassifye(int fweek, int fday) throws Exception {
		map.put("fday", String.valueOf(fday));
		map.put("fweek", String.valueOf(fweek));
		list = sqlSession.selectList("cal.dclassifye", map);
		return list;
	}
	@Override
	public List<CalendarVO> DPClassifyk(String id, int fweek, int fday) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		map.put("fday", String.valueOf(fday));
		list	= sqlSession.selectList("cal.dpclassifyk",map);
		return list;
	}
	@Override
	public List<CalendarVO> DPClassifyj(String id, int fweek, int fday) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		map.put("fday", String.valueOf(fday));
		list	= sqlSession.selectList("cal.dpclassifyj",map);
		return list;
	}
	@Override
	public List<CalendarVO> DPClassifyc(String id, int fweek, int fday) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		map.put("fday", String.valueOf(fday));
		list	= sqlSession.selectList("cal.dpclassifyc",map);
		return list;
	}
	@Override
	public List<CalendarVO> DPClassifyw(String id, int fweek, int fday) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		map.put("fday", String.valueOf(fday));
		list	= sqlSession.selectList("cal.dpclassifyw",map);
		return list;
	}
	
	@Override
	public List<CalendarVO> DPClassifyf(String id, int fweek, int fday) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		map.put("fday", String.valueOf(fday));
		list	= sqlSession.selectList("cal.dpclassifyf",map);
		return list;
	}
	@Override
	public List<CalendarVO> DPClassifye(String id, int fweek, int fday) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		map.put("fday", String.valueOf(fday));
		list	= sqlSession.selectList("cal.dpclassifye",map);
		return list;
	}

	@Override
	public List<CalendarVO> WClassifyk(int fweek) throws Exception {
		list = sqlSession.selectList("cal.wclassifyk",fweek);
		return list;
	}

	@Override
	public List<CalendarVO> WClassifyj(int fweek) throws Exception {
		list = sqlSession.selectList("cal.wclassifyj",fweek);
		return list;
	}

	@Override
	public List<CalendarVO> WClassifyc(int fweek) throws Exception {
		list = sqlSession.selectList("cal.wclassifyc",fweek);
		return list;
	}

	@Override
	public List<CalendarVO> WClassifyw(int fweek) throws Exception {
		list = sqlSession.selectList("cal.wclassifyw",fweek);
		return list;
	}

	@Override
	public List<CalendarVO> WClassifyf(int fweek) throws Exception {
		list = sqlSession.selectList("cal.wclassifyf",fweek);
		return list;
	}

	@Override
	public List<CalendarVO> WClassifye(int fweek) throws Exception {
		list = sqlSession.selectList("cal.wclassifye",fweek);
		return list;
	}

	@Override
	public List<CalendarVO> WPClassifyk(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.wpclassifyk",map);
		return list;
	}

	@Override
	public List<CalendarVO> WPClassifyj(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.wpclassifyj",map);
		return list;
	}

	@Override
	public List<CalendarVO> WPClassifyc(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.wpclassifyc",map);
		return list;
	}

	@Override
	public List<CalendarVO> WPClassifyw(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.wpclassifyw",map);
		return list;
	}

	@Override
	public List<CalendarVO> WPClassifyf(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.wpclassifyf",map);
		return list;
	}

	@Override
	public List<CalendarVO> WPClassifye(String id, int fweek) throws Exception {
		map.put("id", id);
		map.put("fweek", String.valueOf(fweek));
		list	= sqlSession.selectList("cal.wpclassifye",map);
		return list;
	}

}
