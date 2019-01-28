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

	//로그인
	@Override
	public int LoginPro(String id, String pw) throws Exception {
		map.put("id", id);
		map.put("pw", pw);
		int check = (Integer)sqlSession.selectOne("login.loginPro", map);
		return check;
	}

	//정보 갱신
	@Override
	public int UpdatePro(LoginVO vo) throws Exception {
		int check = sqlSession.update("login.updatePro",vo);
		return check;
	}

	//가입
	@Override
	public int JoinPro(LoginVO vo) throws Exception {
		int check = (Integer)sqlSession.insert("login.joinPro",vo);
		return check;
	}

	//삭제
	@Override
	public int DeletePro(String id) throws Exception {
		int check	= (Integer)sqlSession.delete("login.delete",id);
		return check;
	}
	
	//삭제시 Calendar 정보 확인
	@Override
	public int DeleteCalCheck(String id) throws Exception {
		int check	= sqlSession.selectOne("login.deleteCalCheck",id);
		return check;
	}
	
	//삭제시 Calendar 정보 삭제
	@Override
	public int DeleteCal(String id) throws Exception {
		int check = sqlSession.delete("login.deleteCal",id);
		return check;
	}

	//회원 정보 조회
	@Override
	public LoginVO SelectPro(String id) throws Exception {
		loginVO	= sqlSession.selectOne("login.updateSet",id);
		return loginVO;
	}
	
	//아이디 중복 검사
	@Override
	public int IdCheck(String id) throws Exception {
		int check  = (int)sqlSession.selectOne("login.idCheck",id);
		return check;
	}
	
	//이메일 확인 - 비밀번호 찾기
	@Override
	public int EmailCheck(String id, String email) throws Exception {
		map.put("id",id);
		map.put("email", email);
		int check	= (int)sqlSession.selectOne("login.emailCheck",map);
		return check;
	}
	
	//임시비밀번호 사용 확인
	@Override
	public int ResetCheck(String id) throws Exception {
		int check	= (int)sqlSession.selectOne("login.resetCheck",id);
		return check;
	}

}
