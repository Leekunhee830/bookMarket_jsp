package com.bookmarket.util;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("�����»�����̵�", "�����»�����"); //����ڿ��� ���� ������ �ڽ��� ���̵� ��й�ȣ 
	}
}
