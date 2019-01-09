package kr.co.ots.dto;

public class FurnitureDTO {
		//furniture_img, color_score
	
	private String furniture_img;
	private String color_score;
	public String getFurniture_img() {
		return furniture_img;
	}
	public void setFurniture_img(String furniture_img) {
		this.furniture_img = furniture_img;
	}
	public String getColor_score() {
		return color_score;
	}
	public void setColor_score(String color_score) {
		this.color_score = color_score;
	}
	@Override
	public String toString() {
		return "FurnitrueDTO [furniture_img=" + furniture_img + ", color_score=" + color_score + "]";
	}
	
	
}
