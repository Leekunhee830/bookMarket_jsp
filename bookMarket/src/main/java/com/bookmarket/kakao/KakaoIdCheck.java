package com.bookmarket.kakao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.dao.MemberDao;

public class KakaoIdCheck {
	public int kakaoIdck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean result=false;
		
		request.setCharacterEncoding("UTF-8");
		String user_id=request.getParameter("user_id")+"@k";
		String user_name=request.getParameter("user_name");
		MemberDao dao=MemberDao.getInstance();
		
		result=dao.kakaoIdck(user_id);
		
		if(result) {
			HttpSession session=request.getSession();
			session.setAttribute("currentName", user_name);
			session.setAttribute("currentId", user_id);
		}
		
		return result?1:0;
	}
}
