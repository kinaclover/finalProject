package findEat.DB.bean;

public class LoginVO {
	private String id;			//회원 아이디
	private String pw;			//회원 비밀번호 - OAuth로 로그인시 공백처리
	private String email;		//회원 이메일
	private int reset;			//비밀번호 재설정 확인값
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getReset() {
		return reset;
	}
	public void setReset(int reset) {
		this.reset = reset;
	}
}
