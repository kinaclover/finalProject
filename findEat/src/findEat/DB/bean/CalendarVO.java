package findEat.DB.bean;

public class CalendarVO {
	private String id;			//회원 id
	private int fyear;			//해당 값의 년도
	private int fmonth;			//해당 값의 월
	private int fdate;			//해당 값의 일
	private int fday;			//해당 값의 요일
	private int fweek;			//해당 값의 주
	private String fname;		//음식 이름
	private String classify;	//음식 카테고리
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFyear() {
		return fyear;
	}
	public void setFyear(int fyear) {
		this.fyear = fyear;
	}
	public int getFmonth() {
		return fmonth;
	}
	public void setFmonth(int fmonth) {
		this.fmonth = fmonth;
	}
	public int getFdate() {
		return fdate;
	}
	public void setFdate(int fdate) {
		this.fdate = fdate;
	}
	public int getFday() {
		return fday;
	}
	public void setFday(int fday) {
		this.fday = fday;
	}
	public int getFweek() {
		return fweek;
	}
	public void setFweek(int fweek) {
		this.fweek = fweek;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}	
}
