package com.outgo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Merchant_Customer_Master")
public class MerchantCustomerMaster {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	long merchant_customer_id;
	long merchant_id;
	private String merchant_customer_name;
	private String merchant_customer_mobile;
	private String merchant_customer_email;
	public String getMerchant_customer_email() {
		return merchant_customer_email;
	}
	public void setMerchant_customer_email(String merchant_customer_email) {
		this.merchant_customer_email = merchant_customer_email;
	}
	private String merchant_customer_plan;
	long merchant_service_id;
	private String merchant_customer_password;
	private String merchant_customer_address;
	private String merchant_customer_plan_expire_date;
	private String merchant_customer_plan_renew_date;
	private String merchant_customer_user_id;
	
	private String gstno;
	
	private double fine_amount;
	@Transient
	private double final_amount;
	@Transient
	private double gst_amount;
	
	//private double
	private double monthly_rent;
	private double pending_amount;
	private String due_date;
	
	private boolean payment_status;
	String created_Date;
	
	public String getCreated_Date() {
		return created_Date;
	}
	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}
	public boolean isAlreadyTransaction() {
		return alreadyTransaction;
	}
	public void setAlreadyTransaction(boolean alreadyTransaction) {
		this.alreadyTransaction = alreadyTransaction;
	}
	@Transient
	private boolean alreadyTransaction;
	
	public double getGst_amount() {
		return gst_amount;
	}
	public void setGst_amount(double gst_amount) {
		this.gst_amount = gst_amount;
	}
	public double getMonthly_rent() {
		return monthly_rent;
	}
	public void setMonthly_rent(double monthly_rent) {
		this.monthly_rent = monthly_rent;
	}
	public double getPending_amount() {
		return pending_amount;
	}
	public void setPending_amount(double pending_amount) {
		this.pending_amount = pending_amount;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	private double merchant_customer_amount;
	public double getFine_amount() {
		return fine_amount;
	}
	public void setFine_amount(double fine_amount) {
		this.fine_amount = fine_amount;
	}
	public double getFinal_amount() {
		return final_amount;
	}
	public void setFinal_amount(double final_amount) {
		this.final_amount = final_amount;
	}
	private String merchant_customer_description;
	boolean status;
	public long getMerchant_customer_id() {
		return merchant_customer_id;
	}
	public void setMerchant_customer_id(long merchant_customer_id) {
		this.merchant_customer_id = merchant_customer_id;
	}
	public String getMerchant_customer_name() {
		return merchant_customer_name;
	}
	public void setMerchant_customer_name(String merchant_customer_name) {
		this.merchant_customer_name = merchant_customer_name;
	}
	public String getMerchant_customer_mobile() {
		return merchant_customer_mobile;
	}
	public void setMerchant_customer_mobile(String merchant_customer_mobile) {
		this.merchant_customer_mobile = merchant_customer_mobile;
	}
	public String getMerchant_customer_plan() {
		return merchant_customer_plan;
	}
	public void setMerchant_customer_plan(String merchant_customer_plan) {
		this.merchant_customer_plan = merchant_customer_plan;
	}
	public long getMerchant_service_id() {
		return merchant_service_id;
	}
	public void setMerchant_service_id(long merchant_service_id) {
		this.merchant_service_id = merchant_service_id;
	}
	public String getMerchant_customer_password() {
		return merchant_customer_password;
	}
	public void setMerchant_customer_password(String merchant_customer_password) {
		this.merchant_customer_password = merchant_customer_password;
	}
	public String getMerchant_customer_address() {
		return merchant_customer_address;
	}
	public void setMerchant_customer_address(String merchant_customer_address) {
		this.merchant_customer_address = merchant_customer_address;
	}
	public String getMerchant_customer_plan_expire_date() {
		return merchant_customer_plan_expire_date;
	}
	public void setMerchant_customer_plan_expire_date(String merchant_customer_plan_expire_date) {
		this.merchant_customer_plan_expire_date = merchant_customer_plan_expire_date;
	}
	public String getMerchant_customer_plan_renew_date() {
		return merchant_customer_plan_renew_date;
	}
	public void setMerchant_customer_plan_renew_date(String merchant_customer_plan_renew_date) {
		this.merchant_customer_plan_renew_date = merchant_customer_plan_renew_date;
	}
	public String getMerchant_customer_user_id() {
		return merchant_customer_user_id;
	}
	public void setMerchant_customer_user_id(String merchant_customer_user_id) {
		this.merchant_customer_user_id = merchant_customer_user_id;
	}
	public double getMerchant_customer_amount() {
		return merchant_customer_amount;
	}
	public void setMerchant_customer_amount(double merchant_customer_amount) {
		this.merchant_customer_amount = merchant_customer_amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getMerchant_customer_description() {
		return merchant_customer_description;
	}
	public void setMerchant_customer_description(String merchant_customer_description) {
		this.merchant_customer_description = merchant_customer_description;
	}
	public String getGstno() {
		return gstno;
	}
	public void setGstno(String gstno) {
		this.gstno = gstno;
	}
	public boolean isPayment_status() {
		return payment_status;
	}
	public void setPayment_status(boolean payment_status) {
		this.payment_status = payment_status;
	}
	
	
	
	
	
	
	
	
}
