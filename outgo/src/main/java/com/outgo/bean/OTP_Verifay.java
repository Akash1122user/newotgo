package com.outgo.bean;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OTP_Verifay")
public class OTP_Verifay {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="mobileNo",  nullable=false)
	private String mobileNo;
	
	@Column(name="OTP", nullable=false)
	private String OTP;

	@Column(name="Create_Date", nullable=false)
	private String CreateDate;
	

	@Column(name="Update_Date", nullable=false)
	private String UpdateDate;

	@Column(name="status", nullable=false)
	private boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}

	public String getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}



	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

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
			otp[i] =
			numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}
	
}



