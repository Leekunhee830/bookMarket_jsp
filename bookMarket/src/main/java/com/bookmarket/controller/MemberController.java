package com.bookmarket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.kakao.KakaoIdCheck;
import com.bookmarket.kakao.KakaoJoinAction;
import com.bookmarket.kakao.KakaoLoginView;
import com.bookmarket.member.MemberAllSelectAction;
import com.bookmarket.member.MemberEmailCheck;
import com.bookmarket.member.MemberFindIdAction;
import com.bookmarket.member.MemberFindPw;
import com.bookmarket.member.MemberIdCheck;
import com.bookmarket.member.MemberJoinAction;
import com.bookmarket.member.MemberLoginAction;
import com.bookmarket.member.MemberLogoutAction;
import com.bookmarket.member.MemberModifyPwAction;
import com.bookmarket.member.MemberPwCheck;
import com.bookmarket.member.MemberSignoutAction;
import com.bookmarket.member.MypageAction;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;



public class MemberController extends HttpServlet {
	
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
			else if(requestPage.equals("MemberFindId.do")) {
				action=new MemberFindIdAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("MemberFindPw.do")) {
				MemberFindPw memberFindPw=new MemberFindPw();
				int result=memberFindPw.findPw(request, response);
				response.getWriter().write(result+"");
			}
			else if(requestPage.equals("mypage.do")) {
				action=new MypageAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("ModifyPw.do")) {
				action=new MemberModifyPwAction();
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
			else if(requestPage.equals("PwCheck.do")) {
				MemberPwCheck memberPwCheck=new MemberPwCheck();
				int result=memberPwCheck.pwCheck(request,response);
				response.getWriter().write(result+"");
			}
			else if(requestPage.equals("idCheck.do")) {
				MemberIdCheck memberIdCheck=new MemberIdCheck();
				int result=memberIdCheck.idCheck(request, response);
				response.getWriter().write(result+"");
			}
			else if(requestPage.equals("emailCheck.do")) {
				MemberEmailCheck mailcheck=new MemberEmailCheck();
				int result=mailcheck.sendEmail(request, response);
				response.getWriter().write(result+"");
			}
			//카카오 db 추가
			else if(requestPage.equals("KakaoJoin.do")) {
				action=new KakaoJoinAction();
				actionForward=action.execute(request, response);
			}
			//카카오 추가정보 입력창 이동
			else if(requestPage.equals("KakaoLoginView.do")) {
				KakaoLoginView kakaoLoginView=new KakaoLoginView();
				int result=kakaoLoginView.info(request, response);
				response.getWriter().write(result+"");
			}
			
			//카카오 아이디 가입여부체크
			else if(requestPage.equals("KakaoIdCheck.do")) {
				KakaoIdCheck kakaoIdcheck=new KakaoIdCheck();
				int result=kakaoIdcheck.kakaoIdck(request, response);
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
