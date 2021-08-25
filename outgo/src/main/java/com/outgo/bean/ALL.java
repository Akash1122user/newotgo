package com.outgo.bean;

import javax.persistence.Transient;

public class ALL {
	
	private String businessName;
	private String mobileNo;
	private String email;
	private String name;
	
	private String merchant_business_name;
	private String merchant_service_logo;
	private String merchant_terms_conditions;
	private String service_name;
	private String bank_name;
	private String bank_account_number;
	private String bank_ifsc_code;
	private String bank_account_name;
	private String address_desc;
	Object pin_code;
	private String merchant_key_url;
	
	Object transaction_id;
	
	
	String gstno;
	
	
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

	private String customer_mobile;
	
	
	
	public String getMerchant_key_url() {
		return merchant_key_url;
	}
	public void setMerchant_key_url(String merchant_key_url) {
		this.merchant_key_url = merchant_key_url;
	}
	public Object getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Object transaction_id) {
		this.transaction_id = transaction_id;
	}
	private String pan_number;
	private String name_of_pan_card;
	private String registred_address;
	
	private String gstn_number;
	private String gst_tax;
	private String area_name;
	private String merchant_customer_plan;
	Object merchant_customer_id;
	Object merchant_id;
	private String merchant_customer_name;
	private String merchant_customer_mobile;
	private String merchant_customer_email;
	Object merchant_service_id;
	private String merchant_customer_password;
	private String merchant_customer_address;
	private String merchant_customer_plan_expire_date;
	private String merchant_customer_plan_renew_date;
	private String merchant_customer_user_id;
	private Object merchant_customer_amount;
	private String merchant_customer_description;
	boolean status;
	private String expiry_date;
	boolean taxGstType;
	private String service;
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMerchant_business_name() {
		return merchant_business_name;
	}
	public void setMerchant_business_name(String merchant_business_name) {
		this.merchant_business_name = merchant_business_name;
	}
	public String getMerchant_service_logo() {
		return merchant_service_logo;
	}
	public void setMerchant_service_logo(String merchant_service_logo) {
		this.merchant_service_logo = merchant_service_logo;
	}
	public String getMerchant_terms_conditions() {
		return merchant_terms_conditions;
	}
	public void setMerchant_terms_conditions(String merchant_terms_conditions) {
		this.merchant_terms_conditions = merchant_terms_conditions;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_account_number() {
		return bank_account_number;
	}
	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
	}
	public String getBank_ifsc_code() {
		return bank_ifsc_code;
	}
	public void setBank_ifsc_code(String bank_ifsc_code) {
		this.bank_ifsc_code = bank_ifsc_code;
	}
	public String getBank_account_name() {
		return bank_account_name;
	}
	public void setBank_account_name(String bank_account_name) {
		this.bank_account_name = bank_account_name;
	}
	public String getAddress_desc() {
		return address_desc;
	}
	public void setAddress_desc(String address_desc) {
		this.address_desc = address_desc;
	}
	public Object getPin_code() {
		return pin_code;
	}
	public void setPin_code(Object pin_code) {
		this.pin_code = pin_code;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	public String getName_of_pan_card() {
		return name_of_pan_card;
	}
	public void setName_of_pan_card(String name_of_pan_card) {
		this.name_of_pan_card = name_of_pan_card;
	}
	public String getRegistred_address() {
		return registred_address;
	}
	public void setRegistred_address(String registred_address) {
		this.registred_address = registred_address;
	}
	public String getGstn_number() {
		return gstn_number;
	}
	public void setGstn_number(String gstn_number) {
		this.gstn_number = gstn_number;
	}
	public String getGst_tax() {
		return gst_tax;
	}
	public void setGst_tax(String gst_tax) {
		this.gst_tax = gst_tax;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getMerchant_customer_plan() {
		return merchant_customer_plan;
	}
	public void setMerchant_customer_plan(String merchant_customer_plan) {
		this.merchant_customer_plan = merchant_customer_plan;
	}
	public Object getMerchant_customer_id() {
		return merchant_customer_id;
	}
	public void setMerchant_customer_id(Object merchant_customer_id) {
		this.merchant_customer_id = merchant_customer_id;
	}
	public Object getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(Object merchant_id) {
		this.merchant_id = merchant_id;
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
	public String getMerchant_customer_email() {
		return merchant_customer_email;
	}
	public void setMerchant_customer_email(String merchant_customer_email) {
		this.merchant_customer_email = merchant_customer_email;
	}
	public Object getMerchant_service_id() {
		return merchant_service_id;
	}
	public void setMerchant_service_id(Object merchant_service_id) {
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
	public Object getMerchant_customer_amount() {
		return merchant_customer_amount;
	}
	public void setMerchant_customer_amount(Object merchant_customer_amount) {
		this.merchant_customer_amount = merchant_customer_amount;
	}
	public String getMerchant_customer_description() {
		return merchant_customer_description;
	}
	public void setMerchant_customer_description(String merchant_customer_description) {
		this.merchant_customer_description = merchant_customer_description;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCustomer_mobile() {
		return customer_mobile;
	}
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public boolean isTaxGstType() {
		return taxGstType;
	}
	public void setTaxGstType(boolean taxGstType) {
		this.taxGstType = taxGstType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGstno() {
		return gstno;
	}
	public void setGstno(String gstno) {
		this.gstno = gstno;
	}
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
	public boolean isPayment_status() {
		return payment_status;
	}
	public void setPayment_status(boolean payment_status) {
		this.payment_status = payment_status;
	}

	Object update_date;
Object created_Date;



public Object getUpdate_date() {
	return update_date;
}
public void setUpdate_date(Object update_date) {
	this.update_date = update_date;
}
public Object getCreated_Date() {
	return created_Date;
}
public void setCreated_Date(Object created_Date) {
	this.created_Date = created_Date;
}

String customer_email;



public String getCustomer_email() {
	return customer_email;
}
public void setCustomer_email(String customer_email) {
	this.customer_email = customer_email;
}


}
