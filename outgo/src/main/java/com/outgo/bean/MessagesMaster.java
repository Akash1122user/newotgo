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

@Entity
@Table(name="Messages_Master")
public class MessagesMaster {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	long msgId;
	@Column(name="merchant_id",  nullable=false)
	long merchantId;
	long employeeId;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date msg_create_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date msg_modify_date;
	@Column(name="merchant_service_id",  nullable=false)
	long merchant_service_id;
	@Column(name="msg_description",  nullable=false)
	private String msg_description;
	@Column(name="ref_id",  nullable=false)
	long ref_id;//FK Cust id,Other_id_mechant_id
	@Column(name="table_ref",  nullable=false)
	String table_ref;
	String mode;
	
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public long getRef_id() {
		return ref_id;
	}
	public void setRef_id(long ref_id) {
		this.ref_id = ref_id;
	}
	private String msg_status;
	@Column(name="type",  nullable=false)
	String type;
	boolean status;
	public long getMsgId() {
		return msgId;
	}
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}
	
	public Date getMsg_create_date() {
		return msg_create_date;
	}
	public void setMsg_create_date(Date msg_create_date) {
		this.msg_create_date = msg_create_date;
	}
	public Date getMsg_modify_date() {
		return msg_modify_date;
	}
	public void setMsg_modify_date(Date msg_modify_date) {
		this.msg_modify_date = msg_modify_date;
	}
	public long getMerchant_service_id() {
		return merchant_service_id;
	}
	public void setMerchant_service_id(long merchant_service_id) {
		this.merchant_service_id = merchant_service_id;
	}
	public String getMsg_description() {
		return msg_description;
	}
	public void setMsg_description(String msg_description) {
		this.msg_description = msg_description;
	}
	
	public String getTable_ref() {
		return table_ref;
	}
	public void setTable_ref(String table_ref) {
		this.table_ref = table_ref;
	}
	public String getMsg_status() {
		return msg_status;
	}
	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
