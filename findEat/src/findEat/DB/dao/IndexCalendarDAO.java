package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.IndexCalendarVO;
import findEat.DB.bean.FoodVO;

public interface IndexCalendarDAO {
	public List<IndexCalendarVO> TotalList() throws Exception;
	public List<IndexCalendarVO> SelectAll(String id) throws Exception;
	public List<IndexCalendarVO> TotalWeekList(int fweek) throws Exception;
	public List<IndexCalendarVO> SelectThisWeek(String id, int fweek) throws Exception;
}
