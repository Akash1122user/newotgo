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
@Table(name="Plan_Master")
public class PlanMaster {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long plan_id;
	long merchant_id;
	private String service_code;
	double plan_amount;
	private String plan_name;
	int plan_validity;
	private String plan_limit;
	private String plan_after_limit;
	private String plan_type;
	private String plan_speed;
	boolean status;
	public long getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(long plan_id) {
		this.plan_id = plan_id;
	}
	public long getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(long merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getService_code() {
		return service_code;
	}
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	public double getPlan_amount() {
		return plan_amount;
	}
	public void setPlan_amount(double plan_amount) {
		this.plan_amount = plan_amount;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public int getPlan_validity() {
		return plan_validity;
	}
	public void setPlan_validity(int plan_validity) {
		this.plan_validity = plan_validity;
	}
	public String getPlan_limit() {
		return plan_limit;
	}
	public void setPlan_limit(String plan_limit) {
		this.plan_limit = plan_limit;
	}
	public String getPlan_after_limit() {
		return plan_after_limit;
	}
	public void setPlan_after_limit(String plan_after_limit) {
		this.plan_after_limit = plan_after_limit;
	}
	public String getPlan_type() {
		return plan_type;
	}
	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}
	public String getPlan_speed() {
		return plan_speed;
	}
	public void setPlan_speed(String plan_speed) {
		this.plan_speed = plan_speed;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
	
}
