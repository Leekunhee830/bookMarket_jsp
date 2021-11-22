package com.bookmarket.dto.review;

import java.sql.Timestamp;

public class ReviewListDto {
	private int review_num;
	private String user_id;
	private String contents;
	private Timestamp regdate;
	
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
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
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "ReviewListDto [review_num=" + review_num + ", user_id=" + user_id + ", contents=" + contents
				+ ", regdate=" + regdate + "]";
	}
	
	
}
