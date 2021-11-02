package com.bookmarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.kakao.KakaoIdCheck;
import com.bookmarket.product.action.AddProductAction;
import com.bookmarket.product.action.AllProductAction;
import com.bookmarket.product.action.ModifiyProductViewAction;
import com.bookmarket.product.action.ModifyProduct;
import com.bookmarket.product.action.OrderDetailAction;
import com.bookmarket.product.action.OrderManagerAction;
import com.bookmarket.product.action.OrderProductAction;
import com.bookmarket.product.action.ProductDelete;
import com.bookmarket.product.action.ProductManagerAction;
import com.bookmarket.product.action.SelectProductAction;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class FrontControllerPd extends HttpServlet {
 
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
			if(requestPage.equals("AddProduct.pd")) {
				action=new AddProductAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("AllProductView.pd")) {
				action=new AllProductAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("SelectProductView.pd")) {
				action=new SelectProductAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("OrderProduct.pd")) {
				action=new OrderProductAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("OrderManager.pd")) {
				action=new OrderManagerAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("OrderDetail.pd")) {
				action=new OrderDetailAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("ProductManager.pd")) {
				action=new ProductManagerAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("ProductDelete.pd")) {
				ProductDelete pdDelete=new ProductDelete();
				int result=pdDelete.product_delete(request, response);
				response.getWriter().write(result+"");
			}
			else if(requestPage.equals("ModifyProductView.pd")) {
				action=new ModifiyProductViewAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("ModifyProduct.pd")) {
				ModifyProduct ModifyPd=new ModifyProduct();
				ModifyPd.modify(request,response);
			}
			
			
			
			if(actionForward!=null) {
				if(actionForward.isRedirect()) {
					response.sendRedirect(actionForward.getNextPath());
				}else {
					request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
