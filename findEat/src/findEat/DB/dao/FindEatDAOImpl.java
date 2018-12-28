package findEat.DB.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.FindEatVO;

public class FindEatDAOImpl implements FindEatDAO{

	private SqlSessionTemplate sqlSession = null;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public void insertFood(FindEatVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getFoodCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List getFoods(int start, int end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updateMyFood(FindEatVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteMyFood() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int searchMyfood() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
