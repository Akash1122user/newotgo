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
@Table(name="Tax_Master")
public class TaxMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long tax_id;
	long merchant_id;
	private String pan_number;
	private String name_of_pan_card;
	private String registred_address;
	private String pin_code;
	private String gstn_number;
	private String gst_tax;
	private boolean verifyTax;
	private boolean Business_Registered_GST;
	private String doc;

	long state_id;
	boolean status;
	public long getTax_id() {
		return tax_id;
	}
	public void setTax_id(long tax_id) {
		this.tax_id = tax_id;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
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
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
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
	public long getState_id() {
		return state_id;
	}
	public void setState_id(long state_id) {
		this.state_id = state_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isVerifyTax() {
		return verifyTax;
	}
	public void setVerifyTax(boolean verifyTax) {
		this.verifyTax = verifyTax;
	}
	public boolean isBusiness_Registered_GST() {
		return Business_Registered_GST;
	}
	public void setBusiness_Registered_GST(boolean business_Registered_GST) {
		Business_Registered_GST = business_Registered_GST;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	
}
