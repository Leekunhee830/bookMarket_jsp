package com.bookmarket.kakao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.dao.KakaoDao;
import com.bookmarket.dto.kakao.KakaoUser;
import com.bookmarket.dto.member.MemberDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class KakaoFindIdAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		KakaoUser kakaoUser=(KakaoUser)request.getAttribute("kakaoUser");
		int kakaoId=kakaoUser.getId();
		String kakaoName=kakaoUser.getNickname();
		KakaoDao dao=KakaoDao.getInstance();
		MemberDto dto=new MemberDto();
		
		
		dto=dao.kakaofindId(kakaoId);
		
		ActionForward actionForward=new ActionForward();
		
		if(dto==null) {
			request.setAttribute("kakaoName", kakaoName);
			request.setAttribute("kakaoId", kakaoId);		
			actionForward.setNextPath("/kakao/kakaoJoin.jsp");
			actionForward.setRedirect(false);
		}else {
			session.setAttribute("currentName", dto.getName());
			session.setAttribute("currentId", dto.getId());
			session.setAttribute("currentNum", dto.getNum());
			actionForward.setNextPath("/index.jsp");
			actionForward.setRedirect(false);
		}
		
		
		return actionForward;
	}
}
