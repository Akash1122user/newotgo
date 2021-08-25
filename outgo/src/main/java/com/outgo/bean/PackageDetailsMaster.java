/**
 * 
 */
package com.outgo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Package_Details_Master")
public class PackageDetailsMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long package_detl_id;
	long package_id;
	long merchant_id;
	long merchant_email_id;//Fk merchant_email_master
	long sms_id;//FK SMS Master
	boolean cash_model;
	boolean status;
	public long getPackage_detl_id() {
		return package_detl_id;
	}
	public void setPackage_detl_id(long package_detl_id) {
		this.package_detl_id = package_detl_id;
	}
	public long getPackage_id() {
		return package_id;
	}
	public void setPackage_id(long package_id) {
		this.package_id = package_id;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public long getMerchant_email_id() {
		return merchant_email_id;
	}
	public void setMerchant_email_id(long merchant_email_id) {
		this.merchant_email_id = merchant_email_id;
	}
	public long getSms_id() {
		return sms_id;
	}
	public void setSms_id(long sms_id) {
		this.sms_id = sms_id;
	}
	public boolean isCash_model() {
		return cash_model;
	}
	public void setCash_model(boolean cash_model) {
		this.cash_model = cash_model;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
	
}
