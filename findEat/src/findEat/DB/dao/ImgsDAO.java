package findEat.DB.dao;

import java.util.List;

import findEat.DB.bean.ImgsVO;
import findEat.DB.bean.MyPositionVO;

public interface ImgsDAO {
	public void insertIMGS(ImgsVO imgs) throws Exception;
	
	public int searchKeyword(String address_name1,String address_name2,String address_name3,String keyword,String place_name) throws Exception;
	
	public ImgsVO selectVO(String address_name1,String address_name2,String address_name3,String keyword,String place_name) throws Exception;
	
	public int checkMyPosition(String address_name1,String address_name2,String address_name3, String place_name) throws Exception;
	
	public MyPositionVO getPostionVO(String address_name1,String address_name2,String address_name3,String place_name) throws Exception;
	
	public void insertMyPosition(MyPositionVO pvo) throws Exception;
	
}
