package findEat.DB.dao;

import java.util.List;
import java.util.Map;

import findEat.DB.bean.CalendarVO;

public interface IndexCalendarDAO {
	public List<CalendarVO> TotalList() throws Exception;
	public List<CalendarVO> SelectAll(String id) throws Exception;
	public List<CalendarVO> TotalWeekList(int fweek) throws Exception;
	public List<CalendarVO> SelectThisWeek(String id, int fweek) throws Exception;
	public void InsertMenu(CalendarVO CalVO) throws Exception; 
	public void DeleteMenu(Map<String,Object> data) throws Exception;
}
