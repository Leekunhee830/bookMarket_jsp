package com.bookmarket.dto.qna;

import java.sql.Timestamp;

public class QnaDetailDto {
	private int qna_num;
	private int option_num;
	private String user_id;
	private String contents;
	private String qna_password;
	private Timestamp regdate;
	
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public int getOption_num() {
		return option_num;
	}
	public void setOption_num(int option_num) {
		this.option_num = option_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "QnaDetailDto [qna_num=" + qna_num + ", option_num=" + option_num + ", user_id=" + user_id
				+ ", contents=" + contents + ", qna_password=" + qna_password + ", regdate=" + regdate + "]";
	}
	
}
