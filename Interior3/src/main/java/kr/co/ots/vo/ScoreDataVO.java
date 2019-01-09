package kr.co.ots.vo;

public class ScoreDataVO {
	
	private String bnum;
	private String userid; // 좋아요 누른사람 아이디
	private String sex;
	private String age;
	private String blog_userid; // 좋아요 당한사람 아이디
	private String blog_bnum;
	private String style;
	
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBlog_userid() {
		return blog_userid;
	}
	public void setBlog_userid(String blog_userid) {
		this.blog_userid = blog_userid;
	}
	public String getBlog_bnum() {
		return blog_bnum;
	}
	public void setBlog_bnum(String blog_bnum) {
		this.blog_bnum = blog_bnum;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	@Override
	public String toString() {
		return "scoreDataVO [bnum=" + bnum + ", userid=" + userid + ", sex=" + sex + ", age=" + age + ", blog_userid="
				+ blog_userid + ", blog_bnum=" + blog_bnum + ", style=" + style + "]";
	}
	
	
}
