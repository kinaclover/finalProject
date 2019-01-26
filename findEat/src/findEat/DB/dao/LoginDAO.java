package findEat.DB.dao;

import findEat.DB.bean.LoginVO;

public interface LoginDAO {
	/*
	 *	로그인 DAO 
	 *	- 로그인/가입/수정 프로세스
	 *	- 삭제시 관련된 정보 일괄 삭제
	 *	- 임시 비밀번호 이메일 발송 전 이메일 확인, 임시비밀번호 사용여부 확인
	 *
	 */
	
	public int LoginPro(String id, String pw) throws Exception;		//로그인
	public int UpdatePro(LoginVO vo) throws Exception;				//정보 갱신
	public int JoinPro(LoginVO vo) throws Exception;				//가입
	public int DeletePro(String id) throws Exception;				//삭제
	public int DeleteCalCheck(String id) throws Exception;			//삭제시 Calendar 정보 확인
	public int DeleteCal(String id) throws Exception;				//삭제시 Calendar 정보 삭제
	public LoginVO SelectPro(String id) throws Exception;			//회원 정보 조회
	public int IdCheck(String id) throws Exception;					//아이디 중복 검사
	public int EmailCheck(String id,String email) throws Exception;	//이메일 확인 - 비밀번호 찾기
	public int ResetCheck(String id) throws Exception;				//임시비밀번호 사용 확인
}
