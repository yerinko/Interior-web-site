package kr.co.ots.dto;

public class ReviewDataDTO {

	private String bnum;
	private String contents;
	private String review_userid;
	private String blog_userid;
	private String writed_bnum;
	private String reviewer_img;
	
	public String getWrited_bnum() {
		return writed_bnum;
	}
	public void setWrited_bnum(String writed_bnum) {
		this.writed_bnum = writed_bnum;
	}
	public String getReviewer_img() {
		return reviewer_img;
	}
	public void setReviewer_img(String reviewer_img) {
		this.reviewer_img = reviewer_img;
	}
	public String getBlog_userid() {
		return blog_userid;
	}
	public void setBlog_userid(String blog_userid) {
		this.blog_userid = blog_userid;
	}
	private String write_time;
	
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReview_userid() {
		return review_userid;
	}
	public void setReview_userid(String review_userid) {
		this.review_userid = review_userid;
	}
	public String getWrite_time() {
		return write_time;
	}
	public void setWrite_time(String write_time) {
		this.write_time = write_time;
	}
	@Override
	public String toString() {
		return "ReviewDataDTO [bnum=" + bnum + ", contents=" + contents + ", review_userid=" + review_userid
				+ ", blog_userid=" + blog_userid + ", writed_bnum=" + writed_bnum + ", reviewer_img=" + reviewer_img
				+ ", write_time=" + write_time + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
