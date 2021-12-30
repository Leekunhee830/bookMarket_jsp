package com.bookmarket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.order.OrderAdd;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class OrderController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI=request.getRequestURI();
		int lastIndex=requestURI.lastIndexOf("/")+1;
		String requestPage=requestURI.substring(lastIndex);
	
		Action action=null;
		ActionForward actionForward=null;
		
		try {
			//상품주문
			if(requestPage.equals("orderAdd.od")) {
				OrderAdd order=new OrderAdd();
				String result=order.orderAdd(request, response);
				PrintWriter out=response.getWriter();
				out.print(result);
				out.flush();
			}
			
			
			if(actionForward!=null) {
				if(actionForward.isRedirect()) {
					response.sendRedirect(actionForward.getNextPath());
				}else {
					request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
