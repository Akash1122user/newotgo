package com.outgo.services;

import com.outgo.myfun.MyFunction;

public class EmailThread extends Thread{

	String email;
	String massage;
	String subject;
	
	public EmailThread(String email,String massage,String subject)
	{
		this.email=email;
		this.massage=massage;
		this.subject=subject;
	}
	
public void run(){  
		
		MyFunction.Email(email, subject, massage);
		
	}  
	
}
