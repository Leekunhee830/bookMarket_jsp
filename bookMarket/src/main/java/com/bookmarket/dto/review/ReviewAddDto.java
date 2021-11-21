package com.bookmarket.dto.review;

public class ReviewAddDto {
	private int user_num;
	private int product_num;
	private String contents;
	
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@Override
	public String toString() {
		return "ReviewAddDto [user_num=" + user_num + ", product_num=" + product_num + ", contents=" + contents + "]";
	}
	
}
