package com.bookmarket.dto.qna;

public class QnaAddDto {
	private int user_num;
	private int product_num;
	private int option_num;
	private String contents;
	private String qna_password;
	
	
	public int getOption_num() {
		return option_num;
	}
	public void setOption_num(int option_num) {
		this.option_num = option_num;
	}
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
	public String getQna_password() {
		return qna_password;
	}
	public void setQna_password(String qna_password) {
		this.qna_password = qna_password;
	}
	
	@Override
	public String toString() {
		return "QnaAddDto [user_num=" + user_num + ", product_num=" + product_num + ", option_num=" + option_num
				+ ", contents=" + contents + ", qna_password=" + qna_password + "]";
	}
	
}
