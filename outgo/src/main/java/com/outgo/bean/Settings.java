package com.outgo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Settings")
public class Settings {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long setting_Id;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	@Column(name="merchant_id",  nullable=false)
	long merchant_id;
	
	private boolean auto_expiration_notification;
	private boolean welcome_customer_notification;
	private boolean display_gstin_in_receipt;
	private boolean display_gstin_calaculate_in_receipt;
	private boolean terms_conditions;
	private boolean pancard_display;
	private boolean message_register;
	private boolean message_closed;
	private boolean message_assigned;
	private boolean send_link_sms;
	
	
	private boolean taxGstType;
	private boolean invoice_email;

	@Column(name="recipt",nullable=false)
	boolean recipt;
	public boolean isRecipt() {
		return recipt;
	}
	public void setRecipt(boolean recipt) {
		this.recipt = recipt;
	}
	
	public boolean isInvoice_email() {
		return invoice_email;
	}
	public void setInvoice_email(boolean invoice_email) {
		this.invoice_email = invoice_email;
	}
	public long getSetting_Id() {
		return setting_Id;
	}
	public void setSetting_Id(long setting_Id) {
		this.setting_Id = setting_Id;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public boolean isAuto_expiration_notification() {
		return auto_expiration_notification;
	}
	public void setAuto_expiration_notification(boolean auto_expiration_notification) {
		this.auto_expiration_notification = auto_expiration_notification;
	}
	public boolean isWelcome_customer_notification() {
		return welcome_customer_notification;
	}
	public void setWelcome_customer_notification(boolean welcome_customer_notification) {
		this.welcome_customer_notification = welcome_customer_notification;
	}
	public boolean isDisplay_gstin_in_receipt() {
		return display_gstin_in_receipt;
	}
	public void setDisplay_gstin_in_receipt(boolean display_gstin_in_receipt) {
		this.display_gstin_in_receipt = display_gstin_in_receipt;
	}
	public boolean isDisplay_gstin_calaculate_in_receipt() {
		return display_gstin_calaculate_in_receipt;
	}
	public void setDisplay_gstin_calaculate_in_receipt(boolean display_gstin_calaculate_in_receipt) {
		this.display_gstin_calaculate_in_receipt = display_gstin_calaculate_in_receipt;
	}
	public boolean isTerms_conditions() {
		return terms_conditions;
	}
	public void setTerms_conditions(boolean terms_conditions) {
		this.terms_conditions = terms_conditions;
	}
	public boolean isPancard_display() {
		return pancard_display;
	}
	public void setPancard_display(boolean pancard_display) {
		this.pancard_display = pancard_display;
	}
	public boolean isMessage_register() {
		return message_register;
	}
	public void setMessage_register(boolean message_register) {
		this.message_register = message_register;
	}
	public boolean isMessage_closed() {
		return message_closed;
	}
	public void setMessage_closed(boolean message_closed) {
		this.message_closed = message_closed;
	}
	public boolean isMessage_assigned() {
		return message_assigned;
	}
	public void setMessage_assigned(boolean message_assigned) {
		this.message_assigned = message_assigned;
	}
	public boolean isSend_link_sms() {
		return send_link_sms;
	}
	public void setSend_link_sms(boolean send_link_sms) {
		this.send_link_sms = send_link_sms;
	}
	public boolean isTaxGstType() {
		return taxGstType;
	}
	public void setTaxGstType(boolean taxGstType) {
		this.taxGstType = taxGstType;
	}
	
	
	
	

}
