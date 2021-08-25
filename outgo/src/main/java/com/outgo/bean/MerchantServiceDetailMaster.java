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
@Table(name="Merchant_Service_Detail_Master")
public class MerchantServiceDetailMaster {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long merchant_service_id;
	long service_code;
	long tax_id;
	long service_area_id;//FK area Master
	long merchant_id;//Fk Merchant Master
	long address_id;//FK Address Master
	long bank_id;//FK Bank Master
	long contact_id;//FK Contact Master
	private String merchant_business_name;
	private String merchant_service_logo;
	private String merchant_terms_conditions;
	boolean status;
	
	
	public long getMerchant_service_id() {
		return merchant_service_id;
	}
	public void setMerchant_service_id(long merchant_service_id) {
		this.merchant_service_id = merchant_service_id;
	}
	public long getService_code() {
		return service_code;
	}
	public void setService_code(long service_code) {
		this.service_code = service_code;
	}
	public long getService_area_id() {
		return service_area_id;
	}
	public void setService_area_id(long service_area_id) {
		this.service_area_id = service_area_id;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	public long getBank_id() {
		return bank_id;
	}
	public void setBank_id(long bank_id) {
		this.bank_id = bank_id;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getTax_id() {
		return tax_id;
	}
	public void setTax_id(long tax_id) {
		this.tax_id = tax_id;
	}
	public long getContact_id() {
		return contact_id;
	}
	public void setContact_id(long contact_id) {
		this.contact_id = contact_id;
	}
	
	
	
}
