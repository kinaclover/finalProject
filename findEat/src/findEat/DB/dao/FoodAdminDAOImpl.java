package findEat.DB.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.CalendarVO;
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

	/* temporary insert cal */
	@Override
	public int InsertCalDB(CalendarVO calVO) throws Exception {
		int check	= sqlSession.insert("food.calDB",calVO);
		return check;
	}
	@Override
	public List<CalendarVO> CalTotalList() throws Exception {
		List<CalendarVO> list	= sqlSession.selectList("food.selectAll");
		return list;
	}
	@Override
	public int DeleteOne(CalendarVO calVO) throws Exception {
		int check	= sqlSession.delete("food.deleteOne",calVO);
		return check;
	}

	@Override
	public String SelectFname(CalendarVO calVO) throws Exception {
		String fname	= sqlSession.selectOne("food.selectFname",calVO);
		return fname;
	}
	
	
}
