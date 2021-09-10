package com.bookmarket.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.controller.Action;
import com.bookmarket.controller.ActionForward;
import com.bookmarket.dao.MemberDao;
import com.bookmarket.dto.MemberDto;

public class MypageAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		String currentId=(String)session.getAttribute("currentId");
		System.out.println(currentId);
		MemberDto dto=new MemberDto();
		MemberDao dao=MemberDao.getInstance();
		
		dto=dao.myPage(currentId);
		request.setAttribute("memberDto", dto);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("myPageView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
