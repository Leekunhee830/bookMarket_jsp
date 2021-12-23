package com.bookmarket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.kakao.KakaoFindIdAction;
import com.bookmarket.kakao.KakaoProfileAction;
import com.bookmarket.kakao.KakaoTokenAction;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class KakaoController extends HttpServlet {
	
	
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
			if(requestPage.equals("kakaoLogin.ka")) {
				action=new KakaoTokenAction();
				actionForward=action.execute(request, response);
			}else if(requestPage.equals("kakaoProfile.ka")) {
				action=new KakaoProfileAction();
				actionForward=action.execute(request, response);
			}else if(requestPage.equals("kakaoFindId.ka")) {
				action=new KakaoFindIdAction();
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

