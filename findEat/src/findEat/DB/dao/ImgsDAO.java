package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.ImgsVO;
import findEat.DB.bean.MyPositionVO;

public interface ImgsDAO {
	public void insertIMGS(ImgsVO imgs) throws Exception;
	
	public int searchKeyword(String id) throws Exception;
	
	public ImgsVO selectKeyword(String id) throws Exception;
	
	public int checkMyPosition(String id) throws Exception;
	
	public MyPositionVO selectMyPosition(String id) throws Exception;
	
	public void insertMyPosition(MyPositionVO pvo) throws Exception;
	
}
