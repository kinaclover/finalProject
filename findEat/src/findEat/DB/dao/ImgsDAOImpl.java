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
	public int checkMyPosition(String address_name1, String address_name2, String address_name3, String place_name)	throws Exception {
		HashMap<String,String> map=new HashMap<String, String>();
		map.put("address_name1", address_name1);
		map.put("address_name2", address_name2);
		map.put("address_name3", address_name3);
		map.put("place_name", place_name);
		int check=sqlSession.selectOne("Imgs.checkMyPosition", map);
		return check;
	}
	@Override
	public MyPositionVO getPostionVO(String address_name1, String address_name2, String address_name3, String place_name)
			throws Exception {
		HashMap<String,String> map=new HashMap<String, String>();
		map.put("address_name1", address_name1);
		map.put("address_name2", address_name2);
		map.put("address_name3", address_name3);
		map.put("place_name", place_name);
		MyPositionVO vo=sqlSession.selectOne("Imgs.selectMyPosition", map);
		
		return vo;
	}
	@Override
	public int searchKeyword(String address_name1,String address_name2,String address_name3,String keyword, String place_name) throws Exception {
		HashMap<String, String> map=new HashMap<>();
		map.put("address_name1", address_name1);
		map.put("address_name2", address_name2);
		map.put("address_name3", address_name3);
		map.put("menu", keyword);
		map.put("place_name", place_name);
		
		int result=sqlSession.selectOne("Imgs.searchKeyword", map);
		return result;
	}
	
	@Override
	public ImgsVO selectVO(String address_name1,String address_name2,String address_name3,String menu, String place_name) throws Exception{
		HashMap<String, String> map=new HashMap<>();
		ImgsVO iv=new ImgsVO();
		map.put("address_name1", address_name1);
		map.put("address_name2", address_name2);
		map.put("address_name3", address_name3);
		map.put("menu", menu);
		map.put("place_name", place_name);
		
		iv=sqlSession.selectOne("Imgs.selectKeyword", map);
		return iv;
	}

}
