package com.bookmarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.product.action.AddProductAction;
import com.bookmarket.product.action.AllProductAction;



@WebServlet("*.pd")
public class FrontControllerPd extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����");
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