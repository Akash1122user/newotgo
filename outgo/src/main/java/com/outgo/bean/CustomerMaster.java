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

@Entity
@Table(name="Customer_Master")
public class CustomerMaster {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	long customer_id;
	private String customer_name;
	private String customer_email;
	@Column(name="customer_mobile", unique=true, nullable=false)
	private String customer_mobile;
	@Column(name="customer_password",  nullable=false)
	private String customer_password;
	private boolean customer_verfiy_mobile;
	private boolean customer_verfiy_email;
	private long city_id;
	private String customer_token_id;
	private boolean status;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	
	
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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
	public boolean isCustomer_verfiy_mobile() {
		return customer_verfiy_mobile;
	}
	public void setCustomer_verfiy_mobile(boolean customer_verfiy_mobile) {
		this.customer_verfiy_mobile = customer_verfiy_mobile;
	}
	public boolean isCustomer_verfiy_email() {
		return customer_verfiy_email;
	}
	public void setCustomer_verfiy_email(boolean customer_verfiy_email) {
		this.customer_verfiy_email = customer_verfiy_email;
	}
	public long getCity_id() {
		return city_id;
	}
	public void setCity_id(long city_id) {
		this.city_id = city_id;
	}
	public String getCustomer_token_id() {
		return customer_token_id;
	}
	public void setCustomer_token_id(String customer_token_id) {
		this.customer_token_id = customer_token_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	
	
	
	
	
}
