/**
 * 
 */
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

/**
 * @author Amol Delmade
 *	class: Bank Details for Merchant  
 */
@Entity
@Table(name="Bank_Master")
public class BankMaster  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	long bank_id;
	long merchant_id;
	@Column(name="bank_name", nullable=false)
	private String bank_name;
	@Column(name="bank_account_number", nullable=false)
	private String bank_account_number;
	@Column(name="bank_ifsc_code", nullable=false)
	private String bank_ifsc_code;
	private String bank_account_name;
	
	boolean bank_verify;
	private String bank_submit_document;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate")
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifyDate")
	private Date modifyDate;
	
	boolean status;
	public long getBank_id() {
		return bank_id;
	}
	public void setBank_id(long bank_id) {
		this.bank_id = bank_id;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
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
	public boolean isBank_verify() {
		return bank_verify;
	}
	public void setBank_verify(boolean bank_verify) {
		this.bank_verify = bank_verify;
	}
	public String getBank_submit_document() {
		return bank_submit_document;
	}
	public void setBank_submit_document(String bank_submit_document) {
		this.bank_submit_document = bank_submit_document;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getBank_account_name() {
		return bank_account_name;
	}
	public void setBank_account_name(String bank_account_name) {
		this.bank_account_name = bank_account_name;
	}
	
	
}
