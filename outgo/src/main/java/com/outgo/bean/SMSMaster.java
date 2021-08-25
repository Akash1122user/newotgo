package com.outgo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SMS_MASTER")
public class SMSMaster {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)

	long sms_id;
	@Column(name="sms_URL", nullable=false)
	private String sms_URL;
	@Column(name="merchant_id", nullable=false)
	long merchant_id;
	
	long smsLimit;
	long smsCount;

	private String sms_balance_URL;
	
	boolean status;
	
	
	public long getSms_id() {
		return sms_id;
	}
	public void setSms_id(long sms_id) {
		this.sms_id = sms_id;
	}
	public String getSms_URL() {
		return sms_URL;
	}
	public void setSms_URL(String sms_URL) {
		this.sms_URL = sms_URL;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getSms_balance_URL() {
		return sms_balance_URL;
	}
	public void setSms_balance_URL(String sms_balance_URL) {
		this.sms_balance_URL = sms_balance_URL;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getSmsLimit() {
		return smsLimit;
	}
	public void setSmsLimit(long smsLimit) {
		this.smsLimit = smsLimit;
	}
	public long getSmsCount() {
		return smsCount;
	}
	public void setSmsCount(long smsCount) {
		this.smsCount = smsCount;
	}
	
}
