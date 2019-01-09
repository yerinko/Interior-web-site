package kr.co.ots.vo;

public class MemberInfoVO {
	
	private String userid;
	private String age;
	private String img;
	private String sex;
	private String style;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	@Override
	public String toString() {
		return "MemberInfoVO [userid=" + userid + ", age=" + age + ", img=" + img + ", sex=" + sex + ", style=" + style
				+ "]";
	}
	
}
