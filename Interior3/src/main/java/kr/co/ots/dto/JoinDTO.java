package kr.co.ots.dto;

public class JoinDTO {

	private String userid;
	private String userpw;
	private String birth_date;
	private String username;
	private String img;
	private String sex;
	private String style;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		return "JoinDTO [userid=" + userid + ", userpw=" + userpw + ", birth_date=" + birth_date + ", username="
				+ username + ", img=" + img + ", sex=" + sex + ", style=" + style + "]";
	}
	}


	
	

	