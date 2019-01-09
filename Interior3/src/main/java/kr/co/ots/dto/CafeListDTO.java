package kr.co.ots.dto;

public class CafeListDTO {
	private String bnum;
	private String cafe_name;
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getCafe_name() {
		return cafe_name;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	@Override
	public String toString() {
		return "CafeListDTO [bnum=" + bnum + ", cafe_name=" + cafe_name + "]";
	}
	
}
