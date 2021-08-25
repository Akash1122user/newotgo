package com.deazzle.model.login;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.deazzle.api.AESEncryption;

public class Registration {

	
	private long username;
    private String[] email;
    private String f_name;
    private String l_name;
    private String gender;
    private String[] name;
    private long[] phone_number;
    private String http_referrer;
  //  private String password;
 
	public static char[] OTP(int len)
	{
		System.out.println("Generating OTP using random() : ");
		System.out.print("You OTP is : ");

		// Using numeric values
		String numbers = "0123456789";

		// Using random method
		Random rndm_method = new Random();

		char[] otp = new char[len];

		for (int i = 0; i < len; i++)
		{
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			otp[i] =
			numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}

	public long getUsername() {
		return username;
	}

	public void setUsername(long username) {
		this.username = username;
	}

	public String[] getEmail() {
		return email;
	}

	public void setEmail(String[] email) {
		this.email = email;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public long[] getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long[] phone_number) {
		this.phone_number = phone_number;
	}

	public String getHttp_referrer() {
		return http_referrer;
	}

	public void setHttp_referrer(String http_referrer) {
		this.http_referrer = http_referrer;
	}

	/*public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
*/
	public Registration(long username, String email, String f_name, String l_name, String gender, String name,
			long phone_number, String http_referrer) {
		super();
		
		long mobile[]= {phone_number};
		//String e[]= {email};
		String n[]= {name};
		this.username = username;
		try {
			
			String s[]=name.split(" ");
			f_name=s[0];
			l_name=s[1];	
			
		}catch (NullPointerException e) {
			// TODO: handle exception
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		
		//this.email = e;
		this.f_name = f_name;
		this.l_name = l_name;
		this.gender = gender;
		this.name = n;
		this.phone_number = mobile;
		this.http_referrer = http_referrer;
		
		
	}
    
	
	
	
}