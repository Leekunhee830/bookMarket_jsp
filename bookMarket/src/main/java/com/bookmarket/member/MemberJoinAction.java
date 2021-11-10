package com.bookmarket.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.dto.MemberDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;
import com.bookmarket.util.SHA256;

public class MemberJoinAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String user_email=request.getParameter("user_email1")+"@"+request.getParameter("user_email2");
		String user_phone=request.getParameter("user_phone1")+"-"
							+request.getParameter("user_phone2")+"-"
							+request.getParameter("user_phone3");
		String rawPassword=request.getParameter("user_password");
		String password=SHA256.encodeSHA256(rawPassword);
		boolean result=false;

		MemberDao dao=MemberDao.getInstance();
		MemberDto dto=new MemberDto();
		
		dto.setId(request.getParameter("user_id"));
		dto.setPassword(password);
		dto.setName(request.getParameter("user_name"));
		dto.setEmail(user_email);
		dto.setPhone(user_phone);
		
		result=dao.insert(dto);
		
		request.setAttribute("result", result);
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/join/joinResult.do");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

	
}
