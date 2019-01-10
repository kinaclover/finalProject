package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.CalendarVO;
import findEat.DB.bean.FoodVO;

public interface FoodAdminDAO {
	/* insert foods */
	public int InsertFood(FoodVO foodVO) throws Exception;
	public int CheckTotal(String classify) throws Exception;
	public List<FoodVO> CheckGroup(String classify) throws Exception;
	public int DeleteFood(FoodVO foodVO) throws Exception;
	/* temporary insert cal */
	public int InsertCalDB(CalendarVO calVO) throws Exception;
}
