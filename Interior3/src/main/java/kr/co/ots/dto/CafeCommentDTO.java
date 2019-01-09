package kr.co.ots.dto;

public class CafeCommentDTO {

	private String dnum;
	private String image;
	private String userid;
	private String contents;
	private String score;

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

	public String getDnum() {
		return dnum;
	}
	public void setDnum(String dnum) {
		this.dnum = dnum;
	}
	@Override
	public String toString() {
		return "CafeCommentDTO [dnum=" + dnum + ", image=" + image
				+ ", userid=" + userid + ", contents=" + contents + ", score=" + score + "]";
	}
	
	
	
}
