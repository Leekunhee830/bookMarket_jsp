package com.bookmarket.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.dto.MemberDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class MemberJoinAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String user_email=request.getParameter("user_email1")+"@"+request.getParameter("user_email2");
		String user_phone=request.getParameter("user_phone1")+"-"
							+request.getParameter("user_phone2")+"-"
							+request.getParameter("user_phone3");
		
		
		ActionForward actionForward=new ActionForward();
		boolean result=false;
		
		MemberDao dao=MemberDao.getInstance();
		MemberDto dto=new MemberDto();
		
		dto.setId(request.getParameter("user_id"));
		dto.setPassword(request.getParameter("user_password"));
		dto.setName(request.getParameter("user_name"));
		dto.setEmail(user_email);
		dto.setPhone(user_phone);
		
		result=dao.insert(dto);
		
		request.setAttribute("result", result);
		actionForward.setNextPath("joinResult.do");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

	
}
