package com.bookmarket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.review.AddReview;
import com.bookmarket.review.ReviewAllListAction;
import com.bookmarket.review.ReviewDetailAction;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;



public class ReviewController extends HttpServlet {
	
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
			//리뷰작성페이지 이동
			if(requestPage.equals("reviewWriteView.rv")) {
				int productNum=Integer.parseInt(request.getParameter("prodNum"));
				request.setAttribute("prod_num", productNum);
				actionForward=new ActionForward();
				actionForward.setNextPath("/review/reviewWrite.jsp");
				actionForward.setRedirect(false);
			}
			//리뷰등록
			else if(requestPage.equals("reviewWrite.rv")) {
				int result=0;
				AddReview addReview=new AddReview();
				result=addReview.add(request, response);
				PrintWriter out=response.getWriter();
				out.print(result);
				out.flush();
			}
			//리뷰보기
			else if(requestPage.equals("reviewDetail.rv")) {
				action=new ReviewDetailAction();
				actionForward=action.execute(request, response);
			}
			//전체 리뷰 목록
			else if(requestPage.equals("reviewAllList.rv")) {
				action=new ReviewAllListAction();
				actionForward=action.execute(request, response);
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
