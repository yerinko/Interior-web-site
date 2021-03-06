package kr.co.ots.vo;

public class BlogDetailVO {

	private String bnum;
	private String blog_img;
	private String style;
	private String title;
	private String contents;
	private String blog_userid;
	private String write_time;
	private String hit_cnt;
	private String score; // 좋아요!
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
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getBlog_userid() {
		return blog_userid;
	}
	public void setBlog_userid(String blog_userid) {
		this.blog_userid = blog_userid;
	}
	public String getWrite_time() {
		return write_time;
	}
	public void setWrite_time(String write_time) {
		this.write_time = write_time;
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
	@Override
	public String toString() {
		return "BlogDetailVO [bnum=" + bnum + ", blog_img=" + blog_img + ", style=" + style + ", title=" + title
				+ ", contents=" + contents + ", blog_userid=" + blog_userid + ", write_time=" + write_time
				+ ", hit_cnt=" + hit_cnt + ", score=" + score + "]";
	}
	
	
	
	
	
	
}
