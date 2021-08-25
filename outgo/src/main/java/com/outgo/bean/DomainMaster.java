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
@Table(name="Domain_Master")
public class DomainMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long domain_id;
	long merchant_id;
	private String domain_URL;
	private String domain_expire_date;
	private String domain_renew_date;
	boolean status;
	public long getDomain_id() {
		return domain_id;
	}
	public void setDomain_id(long domain_id) {
		this.domain_id = domain_id;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getDomain_URL() {
		return domain_URL;
	}
	public void setDomain_URL(String domain_URL) {
		this.domain_URL = domain_URL;
	}
	public String getDomain_expire_date() {
		return domain_expire_date;
	}
	public void setDomain_expire_date(String domain_expire_date) {
		this.domain_expire_date = domain_expire_date;
	}
	public String getDomain_renew_date() {
		return domain_renew_date;
	}
	public void setDomain_renew_date(String domain_renew_date) {
		this.domain_renew_date = domain_renew_date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
