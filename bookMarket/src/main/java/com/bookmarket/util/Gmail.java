package com.bookmarket.util;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("leekunhee8307@gmail.com", "rjsgml2984"); //����ڿ��� ���� ������ �ڽ��� ���̵� ��й�ȣ 
	}
}
