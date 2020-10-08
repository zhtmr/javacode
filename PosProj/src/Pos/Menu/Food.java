package Pos.Menu;

public class Food {
	private String picture;
	private String name;
	private String contents;
	private int price;
	
	public String getPicture() {
		
		return picture;
		
	}



	@Override
	public String toString() {
		return "Food [picture=" + picture + ", name=" + name + ", contents=" + contents + ", price=" + price + "]";
	}



	public void setPicture(String picture) {
		
		this.picture = picture;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



}
