/**
 * 
 */
package com.outgo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Amol Delmade
 *
 */
@Entity
@Table(name="Non_Register_Customer")
public class OtherCustomerRegisterMaster {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	long other_cust_id;
	private String other_cust_name;
	private String other_cust_email;
	private String other_cust_mobile;
	private String other_cust_address;
	boolean status;
	public long getOther_cust_id() {
		return other_cust_id;
	}
	public void setOther_cust_id(long other_cust_id) {
		this.other_cust_id = other_cust_id;
	}
	public String getOther_cust_name() {
		return other_cust_name;
	}
	public void setOther_cust_name(String other_cust_name) {
		this.other_cust_name = other_cust_name;
	}
	public String getOther_cust_email() {
		return other_cust_email;
	}
	public void setOther_cust_email(String other_cust_email) {
		this.other_cust_email = other_cust_email;
	}
	public String getOther_cust_mobile() {
		return other_cust_mobile;
	}
	public void setOther_cust_mobile(String other_cust_mobile) {
		this.other_cust_mobile = other_cust_mobile;
	}
	public String getOther_cust_address() {
		return other_cust_address;
	}
	public void setOther_cust_address(String other_cust_address) {
		this.other_cust_address = other_cust_address;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
