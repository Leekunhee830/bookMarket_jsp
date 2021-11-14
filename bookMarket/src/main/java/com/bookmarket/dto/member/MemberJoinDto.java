package com.bookmarket.dto.member;

public class MemberJoinDto {
	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "MemberJoinDto [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", phone="
				+ phone + "]";
	}
	
}
