package com.bookmarket.dto.order;

public class OrderAddDto {
	private String order_num;
	private int user_num;
	private int prod_num;
	private String order_name;
	private String order_phone;
	private String order_address;
	private String order_message;
	private int order_price;
	
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
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
	
	@Override
	public String toString() {
		return "OrderAddDto [order_num=" + order_num + ", user_num=" + user_num + ", prod_num=" + prod_num
				+ ", order_name=" + order_name + ", order_phone=" + order_phone + ", order_address=" + order_address
				+ ", order_message=" + order_message + ", order_price=" + order_price + "]";
	}
	
}
