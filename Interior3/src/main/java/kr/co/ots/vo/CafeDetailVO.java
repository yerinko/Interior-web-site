package kr.co.ots.vo;

public class CafeDetailVO {

	private String dnum;
	private String bnum;
	private String cafe_name;
	private String title;
	private String hit_cnt;
	private String score;
	private String good;
	private String url;
	private String category;
	
	public String getCafe_name() {
		return cafe_name;
	}
	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	
	public String getDnum() {
		return dnum;
	}
	public void setDnum(String dnum) {
		this.dnum = dnum;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "CafeDetailVO [dnum=" + dnum + ", bnum=" + bnum + ", cafe_name=" + cafe_name + ", title=" + title
				+ ", hit_cnt=" + hit_cnt + ", score=" + score + ", good=" + good + ", url=" + url + ", category="
				+ category + "]";
	}
	
}
