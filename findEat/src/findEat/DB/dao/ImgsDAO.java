package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.ImgsVO;

public interface ImgsDAO {
	public void insertIMGS(ImgsVO imgs) throws Exception;
	public int searchKeyword(String keyword, String pageNum) throws Exception;
	public List<ImgsVO> selectList(String keyword, String pageNum) throws Exception;
	
}
