package com.outgo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.outgo.myfun.MyFunction;

public class AdminEmail extends Thread{

	String p;
	
	public AdminEmail(String perm) {
		p=perm;
		// TODO Auto-generated constructor stub
	}
	
	
public void run(){  
	sendEmail(p) ;
		
	System.out.println(p);
	}  



public void sendEmail(String  pram) {
	System.out.println(pram);
	try {
		URL obj = new URL("https://admin.outgo.co/email?"+pram);
	
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		System.setProperty("jsse.enableSNIExtension", "false");//for ssl Access Action set false property
					int responseCode = con.getResponseCode();
		System.out.println("code"+responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			System.out.println(responseCode);
			System.out.println(response);
		} else {
			System.out.println("POST request not worked");
			
		}
		} catch (IOException e1) {
			System.out.println("----------IOException-------- "+ e1);
			e1.printStackTrace();
		}
	
}
}
