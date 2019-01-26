package findEat.DB.bean;

import java.sql.Timestamp;

public class CommentsVO {
	private int num;				//댓글 고유값
	private String id;				//댓글 작성자 id
	private int idx;				//댓글 번호
	private String content;			//댓글 내용
	private Timestamp regDate;		//댓글 작성 시간
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
}
