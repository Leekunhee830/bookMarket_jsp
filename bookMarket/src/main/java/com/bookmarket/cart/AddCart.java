package com.bookmarket.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.dao.CartDao;




public class AddCart {
	public int addCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		CartDao dao=CartDao.getInstance();
		
		HttpSession session=request.getSession();
		int user_num=(Integer)session.getAttribute("currentNum");
		int pd_num=Integer.parseInt(request.getParameter("pd_num"));
		boolean result=false;
		
		boolean chk=dao.checkCart(user_num,pd_num);
		
		//중복체크
		if(chk) {
			result=false;
		}else {
			result=dao.addCart(user_num, pd_num);			
		}
		
		return result?1:0;
	}
}
