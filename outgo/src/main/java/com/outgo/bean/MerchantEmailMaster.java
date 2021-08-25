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
@Table(name="Merchant_Email_Master")
public class MerchantEmailMaster {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long email_id;
	long merchant_id;
	private String host_email_id;
	int port_number;
	private String host;
	private String password;
	boolean status;
	public long getEmail_id() {
		return email_id;
	}
	public void setEmail_id(long email_id) {
		this.email_id = email_id;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getHost_email_id() {
		return host_email_id;
	}
	public void setHost_email_id(String host_email_id) {
		this.host_email_id = host_email_id;
	}
	public int getPort_number() {
		return port_number;
	}
	public void setPort_number(int port_number) {
		this.port_number = port_number;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
