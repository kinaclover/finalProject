package findEat.DB.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import findEat.DB.bean.LoginVO;

public class LoginDAOImpl implements LoginDAO {
	
	private SqlSessionTemplate sqlSession = null;
	private LoginVO loginVO = null;
	private HashMap<String,String> map = new HashMap<>();
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO	= loginVO;
	}

	@Override
	public int LoginPro(String id, String pw) throws Exception {
		map.put("id", id);
		map.put("pw", pw);
		int check = (Integer)sqlSession.selectOne("login.loginPro", map);
		return check;
	}

	@Override
	public int UpdatePro(LoginVO vo) throws Exception {
		int check = sqlSession.update("login.updatePro",vo);
		return check;
	}

	@Override
	public int JoinPro(LoginVO vo) throws Exception {
		int check = (Integer)sqlSession.insert("login.joinPro",vo);
		return check;
	}

	@Override
	public int DeletePro(String id, String pw) throws Exception {
		map.put("id", id);
		map.put("pw", pw);
		int check	= (Integer)sqlSession.delete("login.delete",map);
		return check;
	}

	@Override
	public LoginVO SelectPro(String id) throws Exception {
		loginVO	= sqlSession.selectOne("login.updateSet",id);
		return loginVO;
	}
	
	@Override
	public int IdCheck(String id) throws Exception {
		int check  = (int)sqlSession.selectOne("login.idCheck",id);
		return check;
	}
	@Override
	public int EmailCheck(String id, String email) throws Exception {
		map.put("id",id);
		map.put("email", email);
		int check	= (int)sqlSession.selectOne("login.emailCheck",map);
		return check;
	}
	@Override
	public int ResetCheck(String id) throws Exception {
		int check	= (int)sqlSession.selectOne("login.resetCheck",id);
		return check;
	}

}
