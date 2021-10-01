package com.bookmarket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.member.action.MemberAllSelectAction;
import com.bookmarket.member.action.MemberFindAction;
import com.bookmarket.member.action.MemberIdCheck;
import com.bookmarket.member.action.MemberJoinAction;
import com.bookmarket.member.action.MemberLoginAction;
import com.bookmarket.member.action.MemberLogoutAction;
import com.bookmarket.member.action.MemberModifyAction;
import com.bookmarket.member.action.MemberSignoutAction;
import com.bookmarket.member.action.MypageAction;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;



public class FrontController extends HttpServlet {
	
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
			if(requestPage.equals("MemberJoin.do")) {
				action=new MemberJoinAction();
				actionForward= action.execute(request, response);
			}
			else if(requestPage.equals("joinResult.do")) {
				actionForward=new ActionForward();
				actionForward.setNextPath("joinResult.jsp");
				actionForward.setRedirect(false);
			}
			else if(requestPage.equals("MemberLogin.do")) {
				action=new MemberLoginAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("logout.do")) {
				action=new MemberLogoutAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("MemberFind.do")) {
				action=new MemberFindAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("mypage.do")) {
				action=new MypageAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("memberModify.do")) {
				action=new MemberModifyAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("signout.do")) {
				action=new MemberSignoutAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("all_members.do")) {
				action=new MemberAllSelectAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("idCheck.do")) {
				MemberIdCheck idcheck=new MemberIdCheck();
				int result=idcheck.idCheck(request, response);
				response.getWriter().write(result+"");
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
