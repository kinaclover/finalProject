package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.ImgsVO;
import findEat.DB.bean.MyPositionVO;

public class ImgsDAOImpl implements ImgsDAO {
	
	private SqlSessionTemplate sqlSession=null;
	private List<ImgsVO> list=null;
	private ImgsVO iv=null;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession	= sqlSession;
	}
	public void setImgsVO(ImgsVO iv) {
		this.iv	= iv;
	}
	
	@Override
	public void insertIMGS(ImgsVO imgs) throws Exception {
			sqlSession.insert("Imgs.insertImgs", imgs);
	}

	@Override
	public void insertMyPosition(MyPositionVO pvo) throws Exception {
		sqlSession.insert("Imgs.insertMyPosition", pvo);
		
	}
	@Override
	public int checkMyPosition(String id)	throws Exception {
		int check=sqlSession.selectOne("Imgs.checkMyPosition", id);
		return check;
	}
	@Override
	public MyPositionVO selectMyPosition(String id) throws Exception {
		
		MyPositionVO vo=sqlSession.selectOne("Imgs.selectMyPosition", id);
		return vo;
	}
	@Override
	public int searchKeyword(String id) throws Exception {
		
		System.out.println("id====="+id);
		
		
		int result=sqlSession.selectOne("Imgs.searchKeyword", id);
		return result;
	}
	
	@Override
	public ImgsVO selectKeyword(String id) throws Exception{
		
		iv=sqlSession.selectOne("Imgs.selectKeyword", id);
		return iv;
	}

}
