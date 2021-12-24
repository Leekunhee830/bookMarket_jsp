package com.bookmarket.kakao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.dao.KakaoDao;
import com.bookmarket.dto.kakao.KakaoJoinUser;
import com.bookmarket.dto.kakao.KakaoUser;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;
import com.bookmarket.util.SHA256;

public class KakaoJoinAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		KakaoDao dao=KakaoDao.getInstance();
		boolean result=false;
		int kakao_id=Integer.parseInt(request.getParameter("kakao_id"));
		String kakao_name=request.getParameter("kakao_name");
		String user_password=request.getParameter("user_password1");
		String user_phone=request.getParameter("user_phone1")+""+request.getParameter("user_phone2")+""+request.getParameter("user_phone3");
		String user_email=request.getParameter("user_email1")+""+request.getParameter("user_email2");
		String user_shaPassword=SHA256.encodeSHA256(user_password);
		
		KakaoJoinUser kakaoJoinUser=new KakaoJoinUser();
		kakaoJoinUser.setKakao_id(kakao_id);
		kakaoJoinUser.setKakao_name(kakao_name);
		kakaoJoinUser.setUser_password(user_shaPassword);
		kakaoJoinUser.setUser_phone(user_phone);
		kakaoJoinUser.setUser_email(user_email);
		
		result=dao.kakaoJoin(kakaoJoinUser);
		ActionForward actionForward=new ActionForward();
		
		if(result) {
			KakaoUser kakaoUser=new KakaoUser();
			kakaoUser.setId(kakao_id);
			kakaoUser.setNickname(kakao_name);
			request.setAttribute("kakaoUser",kakaoUser);
			actionForward.setNextPath("/kakao/kakaoFindId.ka");
			actionForward.setRedirect(false);
		}else {
			actionForward.setNextPath("/index.jsp");
			actionForward.setRedirect(false);
		}
		
		return actionForward;
	}
}
