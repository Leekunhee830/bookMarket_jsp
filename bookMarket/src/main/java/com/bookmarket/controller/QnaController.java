package com.bookmarket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.qna.AddQna;
import com.bookmarket.qna.DeleteQna;
import com.bookmarket.qna.QnaDetailAction;
import com.bookmarket.qna.QnaPasswordCheckAction;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class QnaController extends HttpServlet implements Servlet {
	


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
			if(requestPage.equals("qnaWriteView.qna")) {
				int productNum=Integer.parseInt(request.getParameter("prodNum"));
				request.setAttribute("prod_num", productNum);
				actionForward=new ActionForward();
				actionForward.setNextPath("/qna/qnaWrite.jsp");
				actionForward.setRedirect(false);
			}
			//Q&A 등록
			else if(requestPage.equals("qnaWrite.qna")) {
				AddQna addQna=new AddQna();
				int result=addQna.add(request,response);
				PrintWriter out=response.getWriter();
				out.print(result);
				out.flush();
			}
			//Q&A 글 보기
			else if(requestPage.equals("qnaDetail.qna")) {
				action=new QnaDetailAction();
				actionForward=action.execute(request, response);
			}
			//Q&A 비밀번호 체크
			else if(requestPage.equals("passwordCheck.qna")) {
				action=new QnaPasswordCheckAction();
				actionForward=action.execute(request, response);
			}
			//Q&A 글 삭제
			else if(requestPage.equals("qnaDelete.qna")) {
				DeleteQna deleteQna=new DeleteQna();
				int result=deleteQna.delete(request,response);
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
