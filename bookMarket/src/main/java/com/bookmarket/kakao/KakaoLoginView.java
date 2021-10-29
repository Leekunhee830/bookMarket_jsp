package com.bookmarket.kakao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KakaoLoginView {
	public int info(HttpServletRequest request, HttpServletResponse response) throws Exception{

		request.setCharacterEncoding("UTF-8");
		String kakao_id=request.getParameter("user_id")+"@k";
		String kakao_name=request.getParameter("user_name");
		
		HttpSession session=request.getSession();
		session.setAttribute("kakao_id", kakao_id);
		session.setAttribute("kakao_name", kakao_name);
		
		return 1;
	}
}
