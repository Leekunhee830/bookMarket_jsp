package com.bookmarket.member;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class MemberLogoutAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		
		if(session.getAttribute("kakaoAccess_token")!=null) {
			String kakao_token=(String)session.getAttribute("kakaoAccess_token");
			String reqURL="https://kapi.kakao.com/v1/user/logout";
			try {
				URL url=new URL(reqURL);
				HttpURLConnection conn=(HttpURLConnection)url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Authorization", "Bearer "+kakao_token);
				System.out.println("세션:"+session.getAttribute("kakaoAccess_token")+"결과:"+conn.getResponseCode());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		session.removeAttribute("currentName");
		session.removeAttribute("currentId");
		session.removeAttribute("currentNum");
		session.invalidate();
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/index.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
