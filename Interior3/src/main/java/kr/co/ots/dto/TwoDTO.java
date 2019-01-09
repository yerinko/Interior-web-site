package kr.co.ots.dto;

public class TwoDTO {
	private String userid;
	private String blog_bnum;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBlog_bnum() {
		return blog_bnum;
	}
	public void setBlog_bnum(String blog_bnum) {
		this.blog_bnum = blog_bnum;
	}
	@Override
	public String toString() {
		return "twoDTO [userid=" + userid + ", blog_bnum=" + blog_bnum + "]";
	}
	
}
