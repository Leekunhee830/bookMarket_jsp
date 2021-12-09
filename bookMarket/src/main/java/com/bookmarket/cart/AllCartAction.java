package com.bookmarket.cart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.dao.CartDao;
import com.bookmarket.dto.cart.CartAllDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class AllCartAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		int user_num=(Integer)session.getAttribute("currentNum");
		ArrayList<CartAllDto> list=new ArrayList<CartAllDto>();
		CartDao dao=CartDao.getInstance();
		
		list=dao.all_Cart(user_num);
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("cart_allView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
