package findEat.DB.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.FoodVO;

public class FoodAdminDAOImpl implements FoodAdminDAO {

	private SqlSessionTemplate sqlSession	= null;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession	= sqlSession;
	}

	/* insert foods */
	@Override
	public int InsertFood(FoodVO foodVO) throws Exception {
		int check = sqlSession.insert("food.insertFood", foodVO);
		return check;
	}
	@Override
	public int CheckTotal(String classify) throws Exception {
		int total	= sqlSession.selectOne("food.checkTotal",classify);
		return total;
	}
	@Override
	public List<FoodVO> CheckGroup(String classify) throws Exception {
		List<FoodVO> group = sqlSession.selectList("food.checkGroup", classify);
		return group;
	}

	@Override
	public int DeleteFood(FoodVO foodVO) throws Exception {
		int check = sqlSession.delete("food.delete", foodVO);
		return check;
	}
	
	
}
