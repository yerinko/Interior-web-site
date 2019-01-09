package kr.co.ots.vo;

public class CafeNameVO {
	private String cafe_name;
	private String bnum;
	private String cafe_hit_cnt;
	private String cafe_good;
	private String cafe_score;
	private String cafe_url;
	private String main_image;
	
	public String getCafe_name() {
		return cafe_name;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	
	public String getCafe_hit_cnt() {
		return cafe_hit_cnt;
	}
	public void setCafe_hit_cnt(String cafe_hit_cnt) {
		this.cafe_hit_cnt = cafe_hit_cnt;
	}
	public String getCafe_good() {
		return cafe_good;
	}
	public void setCafe_good(String cafe_good) {
		this.cafe_good = cafe_good;
	}
	public String getCafe_score() {
		return cafe_score;
	}
	public void setCafe_score(String cafe_score) {
		this.cafe_score = cafe_score;
	}
	public String getCafe_url() {
		return cafe_url;
	}
	public void setCafe_url(String cafe_url) {
		this.cafe_url = cafe_url;
	}
	
	public String getMain_image() {
		return main_image;
	}
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
	@Override
	public String toString() {
		return "CafeNameVO [cafe_name=" + cafe_name + ", bnum=" + bnum + ", cafe_hit_cnt=" + cafe_hit_cnt
				+ ", cafe_good=" + cafe_good + ", cafe_score=" + cafe_score + ", cafe_url=" + cafe_url + ", main_image="
				+ main_image + "]";
	}
	

	
}
