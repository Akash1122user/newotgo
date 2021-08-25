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

import org.apache.poi.hssf.record.formula.functions.False;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Amol Delmade
 *
 */
@Entity
@Table(name="Transaction_Master")
public class TransactionMaster {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	long transaction_id;
	@Column(name="transaction_order_id", unique=true, nullable=false)
	private String transaction_order_id;
	@Column(name="transaction_mode",  nullable=false)
	private String transaction_mode;//WEband App

	private String transaction_type;//Online Offline
	private boolean transaction_payout;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date transaction_created_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date transaction_update_date;
	private String transaction_Release_date;
	
	private String transaction_release_code;
	@Column(name="transaction_payment_gatway_name",  nullable=false)
	private String transaction_payment_gatway_name;
	private double transaction_realease_amount;
	@Column(name="transaction_amount",  nullable=false)
	private double transaction_amount;
	private String transaction_expire_date;
	private String transaction_renew_date;
	private String transaction_payment_response;
	private String transaction_status;
	private String transaction_payment_mode;
	private boolean transaction_active_status;

	long receipt_no;
 	
	long merchant_service_id;
	@Column(name="merchant_id",  nullable=false)
	long merchant_id;
	@Column(name="ref_id",  nullable=false)
	private long ref_id;
	
	@Column(name="ref_table",  nullable=false)
	private String ref_table;
	
	boolean landlineInvoice;
	
	private String customer_plan_name;//FK
	private String customer_email;
	private String customer_userId;
	@Column(name="customer_mobile",  nullable=false)
	private String customer_mobile;
	boolean status;
	
	
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getTransaction_order_id() {
		return transaction_order_id;
	}
	public void setTransaction_order_id(String transaction_order_id) {
		this.transaction_order_id = transaction_order_id;
	}
	public String getTransaction_mode() {
		return transaction_mode;
	}
	public void setTransaction_mode(String transaction_mode) {
		this.transaction_mode = transaction_mode;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	
	
	public boolean isTransaction_payout() {
		return transaction_payout;
	}
	public void setTransaction_payout(boolean transaction_payout) {
		this.transaction_payout = transaction_payout;
	}
	public Date getTransaction_created_date() {
		return transaction_created_date;
	}
	public void setTransaction_created_date(Date transaction_created_date) {
		this.transaction_created_date = transaction_created_date;
	}
	public Date getTransaction_update_date() {
		return transaction_update_date;
	}
	public void setTransaction_update_date(Date transaction_update_date) {
		this.transaction_update_date = transaction_update_date;
	}
	public String getTransaction_release_code() {
		return transaction_release_code;
	}
	public void setTransaction_release_code(String transaction_release_code) {
		this.transaction_release_code = transaction_release_code;
	}
	public String getTransaction_payment_gatway_name() {
		return transaction_payment_gatway_name;
	}
	public void setTransaction_payment_gatway_name(String transaction_payment_gatway_name) {
		this.transaction_payment_gatway_name = transaction_payment_gatway_name;
	}
	public double getTransaction_realease_amount() {
		return transaction_realease_amount;
	}
	public void setTransaction_realease_amount(double transaction_realease_amount) {
		this.transaction_realease_amount = transaction_realease_amount;
	}
	public String getTransaction_expire_date() {
		return transaction_expire_date;
	}
	public void setTransaction_expire_date(String transaction_expire_date) {
		this.transaction_expire_date = transaction_expire_date;
	}
	public String getTransaction_renew_date() {
		return transaction_renew_date;
	}
	public void setTransaction_renew_date(String transaction_renew_date) {
		this.transaction_renew_date = transaction_renew_date;
	}
	public String getTransaction_payment_response() {
		return transaction_payment_response;
	}
	public void setTransaction_payment_response(String transaction_payment_response) {
		this.transaction_payment_response = transaction_payment_response;
	}
	public String getTransaction_status() {
		return transaction_status;
	}
	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}
	public String getTransaction_payment_mode() {
		return transaction_payment_mode;
	}
	public void setTransaction_payment_mode(String transaction_payment_mode) {
		this.transaction_payment_mode = transaction_payment_mode;
	}
	
	
	public boolean isTransaction_active_status() {
		return transaction_active_status;
	}
	public void setTransaction_active_status(boolean transaction_active_status) {
		this.transaction_active_status = transaction_active_status;
	}
	public long getMerchant_service_id() {
		return merchant_service_id;
	}
	public void setMerchant_service_id(long merchant_service_id) {
		this.merchant_service_id = merchant_service_id;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public long getRef_id() {
		return ref_id;
	}
	public void setRef_id(long ref_id) {
		this.ref_id = ref_id;
	}
	public String getCustomer_plan_name() {
		return customer_plan_name;
	}
	public void setCustomer_plan_name(String customer_plan_name) {
		this.customer_plan_name = customer_plan_name;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_mobile() {
		return customer_mobile;
	}
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getRef_table() {
		return ref_table;
	}
	public void setRef_table(String ref_table) {
		this.ref_table = ref_table;
	}
	
	public String getTransaction_Release_date() {
		return transaction_Release_date;
	}
	public void setTransaction_Release_date(String transaction_Release_date) {
		this.transaction_Release_date = transaction_Release_date;
	}
	public String getCustomer_userId() {
		return customer_userId;
	}
	public void setCustomer_userId(String customer_userId) {
		this.customer_userId = customer_userId;
	}
	
	
	
	public String marketplaceTxId;
	public String getMarketplaceTxId() {
		return marketplaceTxId;
	}
	public void setMarketplaceTxId(String marketplaceTxId) {
		this.marketplaceTxId = marketplaceTxId;
	}
	public long getReceipt_no() {
		return receipt_no;
	}
	public void setReceipt_no(long receipt_no) {
		this.receipt_no = receipt_no;
	}
	public boolean isLandlineInvoice() {
		return landlineInvoice;
	}
	public void setLandlineInvoice(boolean landlineInvoice) {
		this.landlineInvoice = landlineInvoice;
	}
	
	
	
	
	
}
