package com.bookmarket.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.dao.OrderDao;
import com.bookmarket.dto.order.OrderDetailDto;
import com.bookmarket.dto.order.OrderListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class OrderManagerAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		int user_num=(Integer)session.getAttribute("currentNum");
		OrderDao dao=OrderDao.getInstance();
		ArrayList<OrderListDto> list=new ArrayList<OrderListDto>();
		
		list=dao.getOrderList(user_num);
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/mypage/order_Manager.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
