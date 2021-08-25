package com.deazzle.model.payment;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Payment {
    private From from;
    private To to;
    private PaymentClass payment;
    private Receipt receipt;

    @JsonProperty("from")
    public From getFrom() { return from; }
    @JsonProperty("from")
    public void setFrom(From value) { this.from = value; }

    @JsonProperty("to")
    public To getTo() { return to; }
    @JsonProperty("to")
    public void setTo(To value) { this.to = value; }

    @JsonProperty("payment")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    public PaymentClass getPayment() { return payment; }
    @JsonProperty("payment")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    public void setPayment(PaymentClass value) { this.payment = value; }
    
    @JsonProperty("receipt")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    
	public Receipt getReceipt() {
		return receipt;
	}
    @JsonProperty("receipt")
    @JsonInclude(JsonInclude.Include.NON_NULL) 

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
    
    
    
    
}
