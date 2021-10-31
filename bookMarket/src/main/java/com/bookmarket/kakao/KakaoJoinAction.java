package com.bookmarket.kakao;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bookmarket.dao.MemberDao;
import com.bookmarket.dto.KakaoMemberDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class KakaoJoinAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean result=false;
		request.setCharacterEncoding("UTF-8");

		
		String user_id=request.getParameter("user_id");
		String user_name=request.getParameter("user_name");
		String user_phone=request.getParameter("user_phone1")+"-"+request.getParameter("user_phone2")+"-"+request.getParameter("user_phone3");
		String user_email=request.getParameter("user_email1")+"@"+request.getParameter("user_email2");
		
		MemberDao dao=MemberDao.getInstance();
		KakaoMemberDto dto=new KakaoMemberDto();
		
		dto.setId(user_id);
		dto.setName(user_name);
		dto.setEmail(user_email);
		dto.setPhone(user_phone);
		
		result=dao.kakaoJoin(dto);
		
		if(result) {
			HttpSession session=request.getSession();
			session.setAttribute("currentName", user_name);
			session.setAttribute("currentId", user_id);
		}
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("./join/joinResult.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
	
}
