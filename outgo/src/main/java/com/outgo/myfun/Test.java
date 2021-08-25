package com.outgo.myfun;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.Message;

import com.deazzle.api.AESEncryption;
import com.outgo.messages.Link;

public class Test {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		//String message="You have received a payment of Rs. 1886.0 from: Pradeep Shukla, userid :9926904508 , plan :16Mbps_30Days_Unlimited ,contact no. : 9926904508. Thx. deAzzle";
		//MyFunction.sendSMS("9764124609", message, Link.SELF_SMS_LINK);

		
		String en=AESEncryption.encrypt("oxfordaccessASguestUserobl");
		
		System.out.println(en);
	}

}
