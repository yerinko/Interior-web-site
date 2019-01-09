package kr.co.ots.dto;

public class UserModifyDTO {

	private String userid;
	private String userpw;	
	private String img;	
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
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
	
	@Override
	public String toString() {
		return "UserModifyDTO [userid=" + userid + ", userpw=" + userpw + ", img=" + img + ", style=" + style + "]";
	}
	public void getUserid(String string) {
		// TODO Auto-generated method stub
		
	}
	
	

		
	}

	
