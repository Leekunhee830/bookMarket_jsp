package com.bookmarket.dto.order;

import java.sql.Timestamp;

public class OrderDetailDto {
	private String order_num;
	private int prod_num;
	private int user_num;
	private String product_name;
	private String product_img;
	private String order_name;
	private String order_phone;
	private String order_address;
	private String order_message;
	private int order_price;
	private int order_result;
	private Timestamp regdate;
	
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public String getOrder_message() {
		return order_message;
	}
	public void setOrder_message(String order_message) {
		this.order_message = order_message;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public int getOrder_result() {
		return order_result;
	}
	public void setOrder_result(int order_result) {
		this.order_result = order_result;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "OrderDetailDto [order_num=" + order_num + ", prod_num=" + prod_num + ", user_num=" + user_num
				+ ", product_name=" + product_name + ", product_img=" + product_img + ", order_name=" + order_name
				+ ", order_phone=" + order_phone + ", order_address=" + order_address + ", order_message="
				+ order_message + ", order_price=" + order_price + ", order_result=" + order_result + ", regdate="
				+ regdate + "]";
	}
	
}
