package com.bookmarket.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.controller.Action;
import com.bookmarket.controller.ActionForward;
import com.bookmarket.dao.MemberDao;
import com.bookmarket.dto.MemberDto;

public class MemberJoinAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ActionForward actionForward=new ActionForward();
		boolean result=false;
		
		MemberDao dao=MemberDao.getInstance();
		MemberDto dto=new MemberDto();
		
		dto.setId(request.getParameter("user_id"));
		dto.setPassword(request.getParameter("user_password"));
		dto.setName(request.getParameter("user_name"));
		dto.setEmail(request.getParameter("user_email"));
		dto.setPhone(request.getParameter("user_phone"));
		
		result=dao.insert(dto);
		
		request.setAttribute("result", result);
		actionForward.setNextPath("joinResult.do");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

	
}
