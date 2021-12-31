package com.bookmarket.dto.order;

import java.sql.Timestamp;

public class OrderListDto {
	private String order_num;
	private String prod_name;
	private int prod_num;
	private int order_price;
	private Timestamp regdate;
	private int order_result;
	private String prod_img;
	
	
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getProd_img() {
		return prod_img;
	}
	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getOrder_result() {
		return order_result;
	}
	public void setOrder_result(int order_result) {
		this.order_result = order_result;
	}
	
	@Override
	public String toString() {
		return "OrderListDto [order_num=" + order_num + ", prod_name=" + prod_name + ", prod_num=" + prod_num
				+ ", order_price=" + order_price + ", regdate=" + regdate + ", order_result=" + order_result
				+ ", prod_img=" + prod_img + "]";
	}
	
}
