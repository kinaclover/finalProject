package findEat.DB.dao;

import findEat.DB.bean.LoginVO;

public interface LoginDAO {
	public int LoginPro(String id, String pw) throws Exception;
	public int UpdatePro(LoginVO vo) throws Exception;
	public int JoinPro(LoginVO vo) throws Exception;
	public int DeletePro(String id, String pw) throws Exception;
	public LoginVO SelectPro(String id) throws Exception;
	public int IdCheck(String id) throws Exception;
	public int EmailCheck(String id,String email) throws Exception;
	public int ResetCheck(String id) throws Exception;
}
