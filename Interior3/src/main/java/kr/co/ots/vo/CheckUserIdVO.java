package kr.co.ots.vo;

public class CheckUserIdVO {

	private int checkCount;

	public int getCheckCount() {
		return checkCount;
	}

	public void setCheckCount(int checkCount) {
		this.checkCount = checkCount;
	}

	
	@Override
	public String toString() {
		return "CheckUserIdVO [checkCount ="+checkCount+"]";
	}	
}
