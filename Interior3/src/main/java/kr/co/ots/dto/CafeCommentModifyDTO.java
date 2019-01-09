package kr.co.ots.dto;

public class CafeCommentModifyDTO {
	private String dnum;
	private String cnum;
	private String cafe_name;
	private String contents;
	
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getDnum() {
		return dnum;
	}
	public void setDnum(String dnum) {
		this.dnum = dnum;
	}
	public String getCafe_name() {
		return cafe_name;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	@Override
	public String toString() {
		return "CafeCommentModifyDTO [dnum=" + dnum + ", cnum=" + cnum + ", cafe_name=" + cafe_name + ", contents="
				+ contents + "]";
	}
	
}
