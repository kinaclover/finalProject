package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.CalendarVO;
import findEat.DB.bean.FoodVO;

public interface IndexCalendarDAO {
	public List<CalendarVO> TotalList() throws Exception;
	public List<CalendarVO> SelectAll(String id) throws Exception;
	public List<CalendarVO> TotalWeekList(int fweek) throws Exception;
	public List<CalendarVO> SelectThisWeek(String id, int fweek) throws Exception;
	public void insertMenu(CalendarVO CalVO) throws Exception; 
}
