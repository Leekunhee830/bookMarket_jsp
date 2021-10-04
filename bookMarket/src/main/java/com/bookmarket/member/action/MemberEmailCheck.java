package com.bookmarket.member.action;

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
import javax.servlet.http.HttpSession;

import com.bookmarket.util.Gmail;

public class MemberEmailCheck {
	public int sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		int random=0;
		int result=0;
		String user_email=request.getParameter("user_email");
		System.out.println(user_email);
		random=(int)Math.floor((Math.random()*(99999-10000+1)))+10000;//인증번호 5자리 랜덤생성
		Properties p=new Properties();//정보를 담을 객체
		
		p.put("mail.smtp.host", "smtp.gmail.com"); //구글 smtp
		
		p.put("mail.smtp.user", "자신의 아이디");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		//SMTP서버에 접속하기 위한 정보들
		
		try {
			   Authenticator auth = new Gmail();
			   Session session = Session.getInstance(p, auth);
			   session.setDebug(true);
			     
			   MimeMessage msg = new MimeMessage(session); // 메일의 내용을 담을 객체
			   msg.setSubject("jsp bookmarket 이메일 인증"); // 제목
			     
			   Address fromAddr = new InternetAddress("자신의 아이디");
			   msg.setFrom(fromAddr); // 보내는 사람
			     
			   Address toAddr = new InternetAddress(user_email);
			   msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
			     
			   msg.setContent("인증번호:"+random, "text/html;charset=UTF-8"); // 내용과 인코딩
			     
			   Transport.send(msg); // 전송
			   result=random;

		}catch(Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
