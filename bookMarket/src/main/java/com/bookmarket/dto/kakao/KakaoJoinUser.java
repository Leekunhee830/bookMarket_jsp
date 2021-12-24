package com.bookmarket.dto.kakao;

public class KakaoJoinUser {
	private int kakao_id;
	private String kakao_name;
	private String user_password;
	private String user_phone;
	private String user_email;
	
	public int getKakao_id() {
		return kakao_id;
	}
	public void setKakao_id(int kakao_id) {
		this.kakao_id = kakao_id;
	}
	public String getKakao_name() {
		return kakao_name;
	}
	public void setKakao_name(String kakao_name) {
		this.kakao_name = kakao_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	@Override
	public String toString() {
		return "KakaoJoinUser [kakao_id=" + kakao_id + ", kakao_name=" + kakao_name + ", user_password=" + user_password
				+ ", user_phone=" + user_phone + ", user_email=" + user_email + "]";
	}

	
}
