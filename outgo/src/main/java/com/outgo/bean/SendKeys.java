package com.outgo.bean;

public class SendKeys {
	public   String vanityUrl;
	public  String formPostUrl; 
	public  String returnURL;
	public  String notifyUrl;
	public  String currency;
	public String securitySignature;
	public String mobile;
	public String email;
	public  String name;
	public String merchantTxnId;
	public String address;
	public double amount;
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	public String getVanityUrl() {
		return vanityUrl;
	}
	public void setVanityUrl(String vanityUrl) {
		this.vanityUrl = vanityUrl;
	}
	public String getFormPostUrl() {
		return formPostUrl;
	}
	public void setFormPostUrl(String formPostUrl) {
		this.formPostUrl = formPostUrl;
	}
	public String getReturnURL() {
		return returnURL;
	}
	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSecuritySignature() {
		return securitySignature;
	}
	public void setSecuritySignature(String securitySignature) {
		this.securitySignature = securitySignature;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMerchantTxnId() {
		return merchantTxnId;
	}
	public void setMerchantTxnId(String merchantTxnId) {
		this.merchantTxnId = merchantTxnId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
