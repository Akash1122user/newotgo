package com.outgo.services;

import com.outgo.myfun.MyFunction;

public class SMSThread extends Thread{

	
	
	String  mobile; String msg; 
	String link;
	public SMSThread(String  mobile, String msg, String link){  
		this.mobile=mobile;  
		this.msg=msg;  
		this.link=link;  
		  
	}  
	public void run(){  
		
		MyFunction.sendSMS(mobile, msg, link);
		
	}  
	
}



