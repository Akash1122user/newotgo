package com.outgo.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Merchant_Payment_keys")
public class Merchant_Payment_keys {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public long keyId;
	public String access_key;
	public String merchant_key;
	public String merchant_key_url;
	public String form_method;
	
	public String return_url;
	public long count;
	public String acount_status;
	
	private boolean registerpay;
	private boolean attachment;
	private boolean auto_renual;
	
	
	
	
	
	
	public boolean isRegisterpay() {
		return registerpay;
	}
	public void setRegisterpay(boolean registerpay) {
		this.registerpay = registerpay;
	}
	public boolean isAttachment() {
		return attachment;
	}
	public void setAttachment(boolean attachment) {
		this.attachment = attachment;
	}
	public boolean isAuto_renual() {
		return auto_renual;
	}
	public void setAuto_renual(boolean auto_renual) {
		this.auto_renual = auto_renual;
	}
	public String getAccess_key() {
		return access_key;
	}
	public void setAccess_key(String access_key) {
		this.access_key = access_key;
	}
	public String getMerchant_key() {
		return merchant_key;
	}
	public void setMerchant_key(String merchant_key) {
		this.merchant_key = merchant_key;
	}
	public String getMerchant_key_url() {
		return merchant_key_url;
	}
	public void setMerchant_key_url(String merchant_key_url) {
		this.merchant_key_url = merchant_key_url;
	}
	public String getReturn_url() {
		return return_url;
	}
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getAcount_status() {
		return acount_status;
	}
	public void setAcount_status(String acount_status) {
		this.acount_status = acount_status;
	}
	public long getKeyId() {
		return keyId;
	}
	public void setKeyId(long keyId) {
		this.keyId = keyId;
	}
	public String getForm_method() {
		return form_method;
	}
	public void setForm_method(String form_method) {
		this.form_method = form_method;
	}
	
	
	

	/*18 July 2018 Integration multiple Payment Getway */
	public String getway;
	public String getway_keys;






	public String getGetway() {
		return getway;
	}
	public void setGetway(String getway) {
		this.getway = getway;
	}
	public String getGetway_keys() {
		return getway_keys;
	}
	public void setGetway_keys(String getway_keys) {
		this.getway_keys = getway_keys;
	}
	
	
	
}
