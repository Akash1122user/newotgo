
package com.outgo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address_Master")

public class AddressMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long address_id;
	long merchantId;
	long area_id;
	private String address_desc;
	long pin_code;
	boolean status;
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	
	public long getArea_id() {
		return area_id;
	}
	public void setArea_id(long area_id) {
		this.area_id = area_id;
	}
	public String getAddress_desc() {
		return address_desc;
	}
	public void setAddress_desc(String address_desc) {
		this.address_desc = address_desc;
	}
	
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}
	public long getPin_code() {
		return pin_code;
	}
	public void setPin_code(long pin_code) {
		this.pin_code = pin_code;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
