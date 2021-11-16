package com.bookmarket.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.CartDao;

public class DeleteCart {
public int cart_delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		CartDao dao=CartDao.getInstance();
		
		
		int user_num=Integer.parseInt(request.getParameter("user_num"));
		int pd_num=Integer.parseInt(request.getParameter("pd_num"));
		boolean result=false;
		
		result=dao.deleteCart(user_num, pd_num);
		
		return result?1:0;
	}
}
