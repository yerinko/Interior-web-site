package kr.co.ots.vo;

public class ColorListVO {

	private String inum;
	private String interior_img;
	private String color_score;
	private String interior_url;
	
	public String getInum() {
		return inum;
	}
	public void setInum(String inum) {
		this.inum = inum;
	}
	public String getInterior_img() {
		return interior_img;
	}
	public void setInterior_img(String interior_img) {
		this.interior_img = interior_img;
	}
	public String getInterior_url() {
		return interior_url;
	}
	public void setInterior_url(String interior_url) {
		this.interior_url = interior_url;
	}

	public String getColor_score() {
		return color_score;
	}
	public void setColor_score(String color_score) {
		this.color_score = color_score;
	}
	@Override
	public String toString() {
		return "ColorListVO [inum=" + inum + ", interior_img=" + interior_img + ", color_score=" + color_score
				+ ", interior_url=" + interior_url + "]";
	}
	
}
