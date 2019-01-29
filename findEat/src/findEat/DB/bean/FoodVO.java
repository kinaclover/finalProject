package findEat.DB.bean;

public class FoodVO {
	private String classify;
	private int fcount;
	private String fname;
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public int getFcount() {
		return fcount;
	}
	public void setFcount(int fcode) {
		this.fcount = fcode;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
}
