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
		random=(int)Math.floor((Math.random()*(99999-10000+1)))+10000;//������ȣ 5�ڸ� ��������
		Properties p=new Properties();//������ ���� ��ü
		
		p.put("mail.smtp.host", "smtp.gmail.com"); //���� smtp
		
		p.put("mail.smtp.user", "�ڽ��� ���̵�");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		//SMTP������ �����ϱ� ���� ������
		
		try {
			   Authenticator auth = new Gmail();
			   Session session = Session.getInstance(p, auth);
			   session.setDebug(true);
			     
			   MimeMessage msg = new MimeMessage(session); // ������ ������ ���� ��ü
			   msg.setSubject("jsp bookmarket �̸��� ����"); // ����
			     
			   Address fromAddr = new InternetAddress("�ڽ��� ���̵�");
			   msg.setFrom(fromAddr); // ������ ���
			     
			   Address toAddr = new InternetAddress(user_email);
			   msg.addRecipient(Message.RecipientType.TO, toAddr); // �޴� ���
			     
			   msg.setContent("������ȣ:"+random, "text/html;charset=UTF-8"); // ����� ���ڵ�
			     
			   Transport.send(msg); // ����
			   result=random;

		}catch(Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
