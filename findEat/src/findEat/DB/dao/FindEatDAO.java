package findEat.DB.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import findEat.DB.bean.FindEatVO;

@Service
public interface FindEatDAO {
	public void insertFood(FindEatVO vo) throws Exception;
	
	public int getFoodCount() throws Exception;
	
	public List getFoods(int start, int end) throws Exception;
	
	public int updateMyFood(FindEatVO vo) throws Exception;

	public int deleteMyFood() throws Exception;
	
	public int searchMyfood() throws Exception;

}
