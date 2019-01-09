package kr.co.ots.vo;

public class CafeCommentVO {
	private String cnum;
	private String bnum;
	private String image;
	private String userid;
	private String contents;
	private String score;
	private String write_time;
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getWrite_time() {
		return write_time;
	}
	public void setWrite_time(String write_time) {
		this.write_time = write_time;
	}
	
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	@Override
	public String toString() {
		return "CafeCommentVO [cnum=" + cnum + ", bnum=" + bnum + ", image=" + image + ", userid=" + userid
				+ ", contents=" + contents + ", score=" + score + ", write_time=" + write_time + "]";
	}

	
}
