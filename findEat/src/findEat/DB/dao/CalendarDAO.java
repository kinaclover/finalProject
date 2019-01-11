package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.CalendarVO;

public interface CalendarDAO {
	public List<CalendarVO> DClassifyk(int fday, int fweek) throws Exception;
	public List<CalendarVO> DClassifyj(int fday, int fweek) throws Exception;
	public List<CalendarVO> DClassifyc(int fday, int fweek) throws Exception;
	public List<CalendarVO> DClassifyw(int fday, int fweek) throws Exception;
	public List<CalendarVO> DClassifyf(int fday, int fweek) throws Exception;
	public List<CalendarVO> DClassifye(int fday, int fweek) throws Exception;
	public List<CalendarVO> WClassifyk(int fweek) throws Exception;
	public List<CalendarVO> WClassifyj(int fweek) throws Exception;
	public List<CalendarVO> WClassifyc(int fweek) throws Exception;
	public List<CalendarVO> WClassifyw(int fweek) throws Exception;
	public List<CalendarVO> WClassifyf(int fweek) throws Exception;
	public List<CalendarVO> WClassifye(int fweek) throws Exception;
	public List<CalendarVO> DPClassifyk(String id, int fweek, int fday) throws Exception;
	public List<CalendarVO> DPClassifyj(String id, int fweek, int fday) throws Exception;
	public List<CalendarVO> DPClassifyc(String id, int fweek, int fday) throws Exception;
	public List<CalendarVO> DPClassifyw(String id, int fweek, int fday) throws Exception;
	public List<CalendarVO> DPClassifyf(String id, int fweek, int fday) throws Exception;
	public List<CalendarVO> DPClassifye(String id, int fweek, int fday) throws Exception;
	public List<CalendarVO> WPClassifyk(String id, int fweek) throws Exception;
	public List<CalendarVO> WPClassifyj(String id, int fweek) throws Exception;
	public List<CalendarVO> WPClassifyc(String id, int fweek) throws Exception;
	public List<CalendarVO> WPClassifyw(String id, int fweek) throws Exception;
	public List<CalendarVO> WPClassifyf(String id, int fweek) throws Exception;
	public List<CalendarVO> WPClassifye(String id, int fweek) throws Exception;
}
