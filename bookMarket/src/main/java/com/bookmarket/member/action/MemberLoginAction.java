package com.bookmarket.member.action;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.controller.Action;
import com.bookmarket.controller.ActionForward;
import com.bookmarket.dao.MemberDao;
import com.bookmarket.dto.MemberDto;

public class MemberLoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		String user_id=request.getParameter("user_id");
		String user_password=request.getParameter("user_password");
		boolean user_id_remember=Boolean.parseBoolean(request.getParameter("user_id_remember"));
		
		ActionForward actionForward=new ActionForward();
		MemberDao dao=MemberDao.getInstance();
		MemberDto dto=new MemberDto();
		
		if(user_id_remember) {
			Cookie cookie=new Cookie("user_id_remember",user_id );
			cookie.setMaxAge(60*60*24);
			cookie.setPath("/");
			response.addCookie(cookie);
		}else {
			Cookie cookie=new Cookie("user_id_remember",null );
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		
		dto=dao.login(user_id, user_password);
		
		if(dto!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("currentName", dto.getName());
			actionForward.setNextPath("/index.jsp");
		}
		
		if(dto==null) {
			request.setAttribute("login_msg", "아이디 또는 비밀번호를 확인해주세요.");
			actionForward.setNextPath("loginView.jsp");
		}
		
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
