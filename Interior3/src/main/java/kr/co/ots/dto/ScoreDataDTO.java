package kr.co.ots.dto;

public class ScoreDataDTO {
	 // ~~ 블로그의 좋아요 를 누른 사람들의 정보 입력
	private String bnum;
	private String userid; // 좋아요 누른사람 아이디
	private String sex;
	private String age;
	private String score;
	private String blog_userid; // 좋아요 당한사람 아이디
	private String blog_bnum;
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
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
	@Override
	public String toString() {
		return "ScoreDataDTO [bnum=" + bnum + ", userid=" + userid + ", sex=" + sex + ", age=" + age + ", score="
				+ score + ", blog_userid=" + blog_userid + ", blog_bnum=" + blog_bnum + "]";
	}
	
	
	
}
