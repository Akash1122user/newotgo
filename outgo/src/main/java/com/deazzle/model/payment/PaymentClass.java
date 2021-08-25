package com.deazzle.model.payment;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class PaymentClass {
    private String date;
    private long amountPaid;
    private String paymentMode="";
    private String paymentSource="";
    private String paymentStatus;
    private String[] serviceName;
    private String paymentDescription="";
    private String transactionID="";
    private String paymentDate="";
    private String httpReferrer="";
    private String payuID="";
    private String gateway="";
    private String refID;
    private String outgo_customer_user_id;
    private String transaction_expire_date ;
    private String transaction_renew_date;

    @JsonProperty("date")
    public String getDate() { return date; }
    @JsonProperty("date")
    public void setDate(String value) { this.date = value; }

    @JsonProperty("amount_paid")
    public long getAmountPaid() { return amountPaid; }
    @JsonProperty("amount_paid")
    public void setAmountPaid(long value) { this.amountPaid = value; }

    @JsonProperty("payment_mode")
    public String getPaymentMode() { return paymentMode; }
    @JsonProperty("payment_mode")
    public void setPaymentMode(String value) { this.paymentMode = value; }

    @JsonProperty("payment_source")
    public String getPaymentSource() { return paymentSource; }
    @JsonProperty("payment_source")
    public void setPaymentSource(String value) { this.paymentSource = value; }

    @JsonProperty("payment_status")
    public String getPaymentStatus() { return paymentStatus; }
    @JsonProperty("payment_status")
    public void setPaymentStatus(String value) { this.paymentStatus = value; }

    @JsonProperty("service_name")
    public String[] getServiceName() { return serviceName; }
    @JsonProperty("service_name")
    public void setServiceName(String[] value) { this.serviceName = value; }

    @JsonProperty("payment_description")
    public String getPaymentDescription() { return paymentDescription; }
    @JsonProperty("payment_description")
    public void setPaymentDescription(String value) { this.paymentDescription = value; }

    @JsonProperty("transaction_id")
    public String getTransactionID() { return transactionID; }
    @JsonProperty("transaction_id")
    public void setTransactionID(String value) { this.transactionID = value; }

    @JsonProperty("payment_date")
    public String getPaymentDate() { return paymentDate; }
    @JsonProperty("payment_date")
    public void setPaymentDate(String value) { this.paymentDate = value; }

    @JsonProperty("http_referrer")
    public String getHTTPReferrer() { return httpReferrer; }
    @JsonProperty("http_referrer")
    public void setHTTPReferrer(String value) { this.httpReferrer = value; }

    @JsonProperty("PayuId")
    public String getPayuID() { return payuID; }
    @JsonProperty("PayuId")
    public void setPayuID(String value) { this.payuID = value; }

    @JsonProperty("gateway")
    public String getGateway() { return gateway; }
    @JsonProperty("gateway")
    public void setGateway(String value) { this.gateway = value; }
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("ref_id")
    public String getRefID() { return refID; }
    @JsonProperty("ref_id")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    public void setRefID(String value) { this.refID = value; }
	public String getHttpReferrer() {
		return httpReferrer;
	}
	public void setHttpReferrer(String httpReferrer) {
		this.httpReferrer = httpReferrer;
	}
    @JsonProperty("outgo_customer_user_id")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
	public String getOutgo_customer_user_id() {
		return outgo_customer_user_id;
	}
    @JsonProperty("outgo_customer_user_id")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
	public void setOutgo_customer_user_id(String outgo_customer_user_id) {
		this.outgo_customer_user_id = outgo_customer_user_id;
	}
    @JsonProperty("transaction_expire_date")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    public String getTransaction_expire_date() {
		return transaction_expire_date;
	}
    @JsonProperty("transaction_expire_date")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
	public void setTransaction_expire_date(String transaction_expire_date) {
		this.transaction_expire_date = transaction_expire_date;
	}
    @JsonProperty("transaction_renew_date")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
	public String getTransaction_renew_date() {
		return transaction_renew_date;
	}
    @JsonProperty("transaction_renew_date")
    @JsonInclude(JsonInclude.Include.NON_NULL) 
	public void setTransaction_renew_date(String transaction_renew_date) {
		this.transaction_renew_date = transaction_renew_date;
	}
    
    
    
}
