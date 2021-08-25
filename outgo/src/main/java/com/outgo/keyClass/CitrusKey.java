package com.outgo.keyClass;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
public class CitrusKey {
	//live kyes 
		public static String accessKey="O8458F15SBX7J5M013C4";
		public static String vanityUrl="outgolive";
		public static String formPostUrl = "https://checkout.citruspay.com/ssl/checkout/outgolive";
	  	public static String secret_key = "92ab9b8fe78fe531fee507ecd5cc96c9ffbcde1b";	  
	  	public static String returnURL = "https://smartbizapi.deazzle.in/";	  
	  	//public static String returnURL = "http://localhost:8080/outgo/";
	  	//public static String returnURL = "https://smartbiztest.outgo.co/";
	  	public static String notifyUrl="https://smartbizapi.deazzle.in/";
	  	public static String currency="INR";
	  	
	  
			
	//Testing Keys	LIVE TEST
	
		/*  public static String  accessKey="TP7WOPWQBZ6352K35UXN";
			public  static String  vanityUrl="outgopg";
			public static String formPostUrl = "https://sandbox.citruspay.com/sslperf/outgopg"; 
			public static  String secret_key = "cfcb320fefb096c625c8f89310cba8a2d51e1d68"; 
			public static String returnURL = "http://payapi.outgo.co/";
			public static String notifyUrl="http://payapi.outgo.co/";
			public static String currency="INR";
		 */

	//Testing Keys 	
		
		/*public static String  accessKey="TP7WOPWQBZ6352K35UXN";
		public  static String  vanityUrl="outgopg";
		public static String formPostUrl = "https://sandbox.citruspay.com/sslperf/outgopg"; 
		public static  String secret_key = "cfcb320fefb096c625c8f89310cba8a2d51e1d68"; 
		public static String returnURL = "http://192.168.0.106:8080/webApi/";
		public static String notifyUrl="http://192.168.0.106:8080/webApi/";
		public static String currency="INR";*/
	
		public static String  securitySignature(String  orderAmount,String  merchantTxnId ) {
				 
				 String data = vanityUrl + orderAmount + merchantTxnId + currency;
					javax.crypto.Mac mac;
					String securitySignature = null;
					try {
						mac = javax.crypto.Mac.getInstance("HmacSHA1");
						mac.init(new javax.crypto.spec.SecretKeySpec(secret_key.getBytes(), "HmacSHA1"));
						byte[] hexBytes = new org.apache.commons.codec.binary.Hex().encode(mac.doFinal(data.getBytes()));
						securitySignature = new String(hexBytes, "UTF-8");
						
						 return securitySignature;
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
						
					} catch (InvalidKeyException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				 
				 
				// TODO Auto-generated method stub

			}
			

}
