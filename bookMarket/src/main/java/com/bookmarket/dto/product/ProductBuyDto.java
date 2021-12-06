package com.bookmarket.dto.product;


public class ProductBuyDto {
	private int pd_num;
	private String pd_name;
	private int pd_price;
	private String pd_manufacturer;
	private String pd_imgName;
	
	public int getPd_num() {
		return pd_num;
	}
	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public int getPd_price() {
		return pd_price;
	}
	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}
	public String getPd_manufacturer() {
		return pd_manufacturer;
	}
	public void setPd_manufacturer(String pd_manufacturer) {
		this.pd_manufacturer = pd_manufacturer;
	}
	public String getPd_imgName() {
		return pd_imgName;
	}
	public void setPd_imgName(String pd_imgName) {
		this.pd_imgName = pd_imgName;
	}
	
	@Override
	public String toString() {
		return "ProductBuyDto [pd_num=" + pd_num + ", pd_name=" + pd_name + ", pd_price=" + pd_price
				+ ", pd_manufacturer=" + pd_manufacturer + ", pd_imgName=" + pd_imgName + "]";
	}
	
}
