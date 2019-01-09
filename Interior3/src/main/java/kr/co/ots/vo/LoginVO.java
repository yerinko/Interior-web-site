package kr.co.ots.vo;

public class LoginVO {
   
   private String userid;
   private String img;
   private String style;
   public String getUserid() {
      return userid;
   }
   public void setUserid(String userid) {
      this.userid = userid;
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
      return "LoginVO [userid=" + userid + ", img=" + img + ", style=" + style + "]";
   }
   
   


   

}