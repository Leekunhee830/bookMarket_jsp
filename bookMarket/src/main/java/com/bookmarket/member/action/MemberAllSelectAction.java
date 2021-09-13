package com.bookmarket.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.controller.Action;
import com.bookmarket.controller.ActionForward;
import com.bookmarket.dao.MemberDao;
import com.bookmarket.dto.MemberDto;

public class MemberAllSelectAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		MemberDao dao=MemberDao.getInstance();
		
		list=dao.allSelect();
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("all_memberView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
