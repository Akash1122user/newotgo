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
 *
 */
@Entity
@Table(name="Subscription_Master")
public class Subscription {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	Date updateDate;
	String subscriptionId;
	String planId;
	String CustomerId;
	String nextDueOn;
	String createdAt;
	String status;
	String total_count;
	String start_at;
	String charge_at;
	String orderId;
	String payoOrderId;
	String international;
	String payId;
	String amount;
	String refund_status;
	String captured;
	
	String payStatus;
	boolean customer_notify;
	@Column(name="merchant_id",  nullable=false)
	long merchantId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getNextDueOn() {
		return nextDueOn;
	}
	public void setNextDueOn(String nextDueOn) {
		this.nextDueOn = nextDueOn;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotal_count() {
		return total_count;
	}
	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}
	public String getStart_at() {
		return start_at;
	}
	public void setStart_at(String start_at) {
		this.start_at = start_at;
	}
	public String getCharge_at() {
		return charge_at;
	}
	public void setCharge_at(String charge_at) {
		this.charge_at = charge_at;
	}
	public boolean isCustomer_notify() {
		return customer_notify;
	}
	public void setCustomer_notify(boolean customer_notify) {
		this.customer_notify = customer_notify;
	}
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getInternational() {
		return international;
	}
	public void setInternational(String international) {
		this.international = international;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRefund_status() {
		return refund_status;
	}
	public void setRefund_status(String refund_status) {
		this.refund_status = refund_status;
	}
	public String getCaptured() {
		return captured;
	}
	public void setCaptured(String captured) {
		this.captured = captured;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getPayoOrderId() {
		return payoOrderId;
	}
	public void setPayoOrderId(String payoOrderId) {
		this.payoOrderId = payoOrderId;
	}
	
	
}
