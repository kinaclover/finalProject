package findEat.DB.bean;

import java.sql.Timestamp;

public class BoardVO {
	private int idx;				//글 고유번호(시퀀스를 이용하여 자동증가)
	private String id;				//작성자 아이디
	private String pw;				//글 비밀번호
	private String email;			//작성자 이메일
	private String subject;			//글 제목
	private String content;			//글 내용
	private Timestamp regDate;		//등록시간
	private int vcount;				//뷰 카운트
	private int src;				//답글 표시를 위한 값***현재 사용하지 않음
	private int srcStep;			//답글 표시를 위한 값***현재 사용하지 않음
	private int srcLevel;			//답글 표시를 위한 값***현재 사용하지 않음
	private String atype;			//글 종류
	private int comments;			//해당 글의 총 댓글 수
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getVcount() {
		return vcount;
	}
	public void setVcount(int vcount) {
		this.vcount = vcount;
	}
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int getSrcStep() {
		return srcStep;
	}
	public void setSrcStep(int srcStep) {
		this.srcStep = srcStep;
	}
	public int getSrcLevel() {
		return srcLevel;
	}
	public void setSrcLevel(int srcLevel) {
		this.srcLevel = srcLevel;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
}
