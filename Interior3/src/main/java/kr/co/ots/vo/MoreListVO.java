package kr.co.ots.vo;

public class MoreListVO {
	
	String data_bno;
	String data_color_score;
	public String getData_bno() {
		return data_bno;
	}
	public void setData_bno(String data_bno) {
		this.data_bno = data_bno;
	}
	public String getData_color_score() {
		return data_color_score;
	}
	public void setData_color_score(String data_color_score) {
		this.data_color_score = data_color_score;
	}
	@Override
	public String toString() {
		return "MoreListVO [data_bno=" + data_bno + ", data_color_score=" + data_color_score + "]";
	}
	
}
