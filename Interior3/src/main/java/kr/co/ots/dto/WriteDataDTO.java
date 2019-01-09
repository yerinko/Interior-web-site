package kr.co.ots.dto;

public class WriteDataDTO {
	
	private String blog_img;
	private String style;
	private String title;
	private String contents;
	private String blog_userid;
	private String blog_userid_img;
	private String score;
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
	public String getBlog_userid_img() {
		return blog_userid_img;
	}
	public void setBlog_userid_img(String blog_userid_img) {
		this.blog_userid_img = blog_userid_img;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "WriteDataDTO [blog_img=" + blog_img + ", style=" + style + ", title=" + title + ", contents=" + contents
				+ ", blog_userid=" + blog_userid + ", blog_userid_img=" + blog_userid_img + ", score=" + score + "]";
	}
	
	
	
	
	
	
	
	
	
}
