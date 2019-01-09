package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.CalendarVO;

public interface CalendarDAO {
	public List<CalendarVO> Classifyk(int fweek) throws Exception;
	public List<CalendarVO> Classifyj(int fweek) throws Exception;
	public List<CalendarVO> Classifyc(int fweek) throws Exception;
	public List<CalendarVO> Classifyw(int fweek) throws Exception;
	public List<CalendarVO> Classifyf(int fweek) throws Exception;
	public List<CalendarVO> Classifye(int fweek) throws Exception;
	public List<CalendarVO> PClassifyk(String id, int fweek) throws Exception;
	public List<CalendarVO> PClassifyj(String id, int fweek) throws Exception;
	public List<CalendarVO> PClassifyc(String id, int fweek) throws Exception;
	public List<CalendarVO> PClassifyw(String id, int fweek) throws Exception;
	public List<CalendarVO> PClassifyf(String id, int fweek) throws Exception;
	public List<CalendarVO> PClassifye(String id, int fweek) throws Exception;
}
