package com.bookmarket.cart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.ProductDto;

public class AddCart {
	public int addCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		int pd_num=Integer.parseInt(request.getParameter("pd_num"));
		
		ProductDto dto=new ProductDto(); 
		ProductDao dao=ProductDao.getInstance();
		dto=dao.selectProduct(pd_num);
		
		
		
		return 1;
	}
}
