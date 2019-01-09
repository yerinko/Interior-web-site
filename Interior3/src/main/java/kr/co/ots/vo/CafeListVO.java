package kr.co.ots.vo;

public class CafeListVO {
	
	private String cafe_name;
	private String bnum;
	private String hit_cnt;
	private String title;
	private String category;
	private String score;
	private String good;
	private String url;
	private String cafe_hit_cnt;
	private String title_image;
	private String dnum;
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
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getCafe_name() {
		return cafe_name;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	public String getGood() {
		return good;
	}
	public void setGood(String good) {
		this.good = good;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCafe_hit_cnt() {
		return cafe_hit_cnt;
	}
	public void setCafe_hit_cnt(String cafe_hit_cnt) {
		this.cafe_hit_cnt = cafe_hit_cnt;
	}
	
	
	public String getDnum() {
		return dnum;
	}
	public void setDnum(String dnum) {
		this.dnum = dnum;
	}
	public String getTitle_image() {
		return title_image;
	}
	public void setTitle_image(String title_image) {
		this.title_image = title_image;
	}
	@Override
	public String toString() {
		return "CafeListVO [cafe_name=" + cafe_name + ", bnum=" + bnum + ", hit_cnt=" + hit_cnt + ", title=" + title
				+ ", category=" + category + ", score=" + score + ", good=" + good + ", url=" + url + ", cafe_hit_cnt="
				+ cafe_hit_cnt + ", title_image=" + title_image + ", dnum=" + dnum + "]";
	}

	
}
