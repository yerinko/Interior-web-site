package kr.co.ots.vo;

public class genderChartVO {
	
	private String sex;
	private String count;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "sex_chartVO [sex=" + sex + ", count=" + count + "]";
	}
	
	
}
