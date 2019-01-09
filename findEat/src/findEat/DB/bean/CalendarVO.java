package findEat.DB.bean;

public class CalendarVO {
	private String id;
	private int fyear;
	private int fmonth;
	private int fdate;
	private int fday;
	private int fweek;
	private String fname;
	private int fcode;
	private String classify;
	
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
	public int getFcode() {
		return fcode;
	}
	public void setFcode(int fcode) {
		this.fcode = fcode;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}	
}
