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
@Table(name="Package_Master")
public class PackageMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long package_id;
	private String package_name;
	private double package_price;
	private String package_desc;
	boolean status;
	public long getPackage_id() {
		return package_id;
	}
	public void setPackage_id(long package_id) {
		this.package_id = package_id;
	}
	public String getPackage_name() {
		return package_name;
	}
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}
	public double getPackage_price() {
		return package_price;
	}
	public void setPackage_price(double package_price) {
		this.package_price = package_price;
	}
	public String getPackage_desc() {
		return package_desc;
	}
	public void setPackage_desc(String package_desc) {
		this.package_desc = package_desc;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
}
