package com.bookmarket.util;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("관리자 아이디", "관리자 비밀번호"); //사용자에게 보낼 관리자 자신의 아이디 비밀번호 
	}
}
