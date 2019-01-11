package findEat.DB.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.ImgsVO;

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
	public int searchKeyword(String keyword, String pageNum) throws Exception {
		HashMap<String, String> map=new HashMap<>();
		map.put("keyword", keyword);
		map.put("pageNum", pageNum);
		int result=sqlSession.selectOne("Imgs.searchKeyword", map);
		return result;
	}
	
	@Override
	public List<ImgsVO> selectList(String keyword, String pageNum) throws Exception{
		HashMap<String, String> map=new HashMap<>();
		map.put("keyword", keyword);
		map.put("pageNum", pageNum);
		list=sqlSession.selectList("Imgs.selectKeyword", map);
		return list;
	}

}
