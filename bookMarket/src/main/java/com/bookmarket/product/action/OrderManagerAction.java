package com.bookmarket.product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.dao.OrderDao;
import com.bookmarket.dto.OrderDtailDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class OrderManagerAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		int user_num=(Integer)session.getAttribute("currentNum");
		OrderDao dao=OrderDao.getInstance();
		ArrayList<OrderDtailDto> list=new ArrayList<OrderDtailDto>();
		
		list=dao.getOrder_all(user_num);
		
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("order_Manager.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
