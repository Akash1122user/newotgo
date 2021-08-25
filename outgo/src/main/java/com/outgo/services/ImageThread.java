package com.outgo.services;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.web.multipart.MultipartFile;

import com.outgo.controller.ApiController;

public class ImageThread  extends Thread{
	
	String host;
	String port;
	 String userName;
	 String password;
			String toAddress;
			String subject;
			String message;
			MultipartFile attachFiles1;
			MultipartFile attachFiles2;			
			MultipartFile attachFiles3;
	
			public ImageThread(String host, String port, final String userName, final String password,
			String toAddress, String subject, String message, MultipartFile attachFiles1, MultipartFile attachFiles2,
			MultipartFile attachFiles3){
		
		
		this.host=host;
		this.port=port;
		 this.userName=userName;
		 this.password=password;
				this.toAddress=toAddress;
				this.subject=subject;
				this.message=message;
				this.attachFiles1=attachFiles1;
				this.attachFiles2=attachFiles2;				
				this.attachFiles3=attachFiles3;
		
	}
	
public void run(){  
		
		
			try {
				ApiController.sendEmailWithAttachments(host, port, userName, password, toAddress, subject, message, attachFiles1, attachFiles2, attachFiles3);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}  
	
}
