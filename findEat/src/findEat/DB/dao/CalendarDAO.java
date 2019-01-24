package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.CalendarVO;

public interface CalendarDAO {
	
	/**************************************************************************************************/
	//suggestion-ver2
	public List<CalendarVO> TotalClassifyList(int day) throws Exception;
	public List<String> ThisWeekList(int week) throws Exception;
	//statistic
	public List<CalendarVO> TotalMonth(int year, int month) throws Exception;
	public List<CalendarVO> UserMonth(CalendarVO cal) throws Exception;
}
