package kr.co.ots.vo;

public class BlogMainListVO {

	private String bnum;
	private String blog_img;
	private String hit_cnt;
	private String score;
	private String blog_userid;
	private String blog_userid_img;
	private String style;
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getBlog_img() {
		return blog_img;
	}
	public void setBlog_img(String blog_img) {
		this.blog_img = blog_img;
	}
	public String getHit_cnt() {
		return hit_cnt;
	}
	public void setHit_cnt(String hit_cnt) {
		this.hit_cnt = hit_cnt;
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
	public String getBlog_userid_img() {
		return blog_userid_img;
	}
	public void setBlog_userid_img(String blog_userid_img) {
		this.blog_userid_img = blog_userid_img;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
	
	@Override
	public String toString() {
		return "BlogMainListVO [bnum=" + bnum + ", blog_img=" + blog_img + ", hit_cnt=" + hit_cnt + ", score=" + score
				+ ", blog_userid=" + blog_userid + ", blog_userid_img=" + blog_userid_img + ", style=" + style + "]";
	}
	
	
	
	
	
	
	
	
	
}
