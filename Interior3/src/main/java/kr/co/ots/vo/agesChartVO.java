package kr.co.ots.vo;

public class agesChartVO {
	
	private String ages;
	private String count;
	
	public String getAges() {
		return ages;
	}
	public void setAges(String ages) {
		this.ages = ages;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ages_ChartVO [ages=" + ages + ", count=" + count + "]";
	}
	
}
