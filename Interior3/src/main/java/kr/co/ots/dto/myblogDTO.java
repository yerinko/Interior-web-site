package kr.co.ots.dto;

public class myblogDTO {
	private String style;
	private String blog_userid;
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getBlog_userid() {
		return blog_userid;
	}
	public void setBlog_userid(String blog_userid) {
		this.blog_userid = blog_userid;
	}
	@Override
	public String toString() {
		return "myblogDTO [style=" + style + ", blog_userid=" + blog_userid + "]";
	}
	
}
