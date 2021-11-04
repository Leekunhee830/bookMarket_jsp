package com.bookmarket.member;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.util.Gmail;

public class MemberFindPw {
	
	public int findPw(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDao dao=MemberDao.getInstance();
		
		boolean result=false;
		request.setCharacterEncoding("UTF-8");
		String user_email=request.getParameter("user_email");
		String user_id=request.getParameter("user_id");
		
		result=dao.findPw(user_id, user_email);
		
		if(result) {
			String ranPw=""; //임시 비번
			char[] charSet= {'1','2','3','4','5','6','7','8','9','0',
                    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                    '!','@','#','$','%','^','&','*'};
			for(int i=0;i<10;i++) {
				int selectRanPw=(int)(Math.random()*(charSet.length));
				ranPw+=charSet[selectRanPw];
			}
			
			Properties p=new Properties();//정보를 담을 객체
			
			p.put("mail.smtp.host", "smtp.gmail.com"); //구글 smtp
			
			p.put("mail.smtp.user", "관리자아이디");
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth","true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");
			
			try {
				   Authenticator auth = new Gmail();
				   Session session = Session.getInstance(p, auth);
				   session.setDebug(true);
				     
				   MimeMessage msg = new MimeMessage(session); // 메일의 내용을 담을 객체
				   msg.setSubject("jsp bookmarket 임시 비밀번호"); // 제목
				     
				   Address fromAddr = new InternetAddress("관리자아이디");
				   msg.setFrom(fromAddr); // 보내는 사람
				     
				   Address toAddr = new InternetAddress(user_email);
				   msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
				     
				   msg.setContent("임시 비밀번호:"+ranPw, "text/html;charset=UTF-8"); // 내용과 인코딩
				     
				   Transport.send(msg); // 전송
				   
				   dao.modifyPw(user_id, user_email, ranPw);//임시 비번으로 변경
				   
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
//		request.setAttribute("result", result);
		
//		ActionForward actionForward=new ActionForward();
//		actionForward.setNextPath("memberFindPwResult.jsp");
//		actionForward.setRedirect(false);
//		
//		return actionForward;
		return result?1:0;
	}
}
