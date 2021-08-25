package com.deazzle.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Receipt {

	
	long amount_received;
	String status;
	String receipt_description;
	String receipt_date;
	String payment_mode;
	String http_referrer="outgo";
	String Payment_Ref_Id;
	
    @JsonProperty("amount_received")
	public long getAmount_received() {
		return amount_received;
	}
    @JsonProperty("amount_received")
	public void setAmount_received(long amount_received) {
		this.amount_received = amount_received;
	}
    @JsonProperty("status")
	public String getStatus() {
		return status;
	}
    @JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
    @JsonProperty("receipt_description")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
	public String getReceipt_description() {
		return receipt_description;
	}
    @JsonProperty("receipt_description")
    @JsonInclude(JsonInclude.Include.NON_NULL) 

	public void setReceipt_description(String receipt_description) {
		this.receipt_description = receipt_description;
	}
    @JsonProperty("receipt_date")
	public String getReceipt_date() {
		return receipt_date;
	}
    @JsonProperty("receipt_date")
    public void setReceipt_date(String receipt_date) {
		this.receipt_date = receipt_date;

	}
    @JsonProperty("payment_mode")
    public String getPayment_mode() {
		return payment_mode;
	}
    @JsonProperty("payment_mode")
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
    @JsonProperty("http_referrer")
	public String getHttp_referrer() {
		return http_referrer;
	}
    @JsonProperty("http_referrer")
	public void setHttp_referrer(String http_referrer) {
		this.http_referrer = http_referrer;
	}
    @JsonProperty("Payment_Ref_Id")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
	public String getPayment_Ref_Id() {
		return Payment_Ref_Id;
	}
    @JsonProperty("payment_Ref_Id")
    @JsonInclude(JsonInclude.Include.NON_NULL) 

	public void setPayment_Ref_Id(String payment_Ref_Id) {
		Payment_Ref_Id = payment_Ref_Id;
	}
	
	
	
	
	
	
}
