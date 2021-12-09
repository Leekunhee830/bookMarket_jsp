package com.bookmarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.kakao.KakaoIdCheck;
import com.bookmarket.product.AddProductAction;
import com.bookmarket.product.AllProductAction;
import com.bookmarket.product.MainProductAction;
import com.bookmarket.product.ModifiyProductViewAction;
import com.bookmarket.product.ModifyProduct;
import com.bookmarket.product.OrderDetailAction;
import com.bookmarket.product.OrderManagerAction;
import com.bookmarket.product.ProductCategoryAction;
import com.bookmarket.product.ProductDelete;
import com.bookmarket.product.ProductDirectBuyAction;
import com.bookmarket.product.ProductManagerAction;
import com.bookmarket.product.SelectProductAction;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class ProductController extends HttpServlet {
 
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
			if(requestPage.equals("Main.pd")){
				action=new MainProductAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("AddProduct.pd")) {
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
			//카테고리 도서 목록
			else if(requestPage.equals("ProductCategoryView.pd")) {
				action=new ProductCategoryAction();
				actionForward=action.execute(request, response);
			}
			//상품구매
			else if(requestPage.equals("directBuy.pd")) {
				action=new ProductDirectBuyAction();
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
