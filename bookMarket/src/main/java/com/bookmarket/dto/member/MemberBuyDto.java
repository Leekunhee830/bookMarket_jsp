package com.bookmarket.dto.member;

public class MemberBuyDto {
	private int user_num;
	private String user_id;
	private String user_email;
	private String user_name;
	private String user_phone;
	
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	@Override
	public String toString() {
		return "MemberBuyDto [user_num=" + user_num + ", user_id=" + user_id + ", user_email=" + user_email
				+ ", user_name=" + user_name + ", user_phone=" + user_phone + "]";
	}
	
}
