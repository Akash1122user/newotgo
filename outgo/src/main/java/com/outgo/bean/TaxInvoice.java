package com.outgo.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Amol Delmade
 * Tax Invoice Bean
 *
 */
@Entity
@Table(name="tax_invoice")
public class TaxInvoice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int invoiceId;
	 int regId;
	String custName;String custEmail;String custMobile;String custId;String custAddress;String amount;String gstId;
	String billNo;String billDueDate;String billDate;String billPeriod;String serviceCode;String serviceName;String SAC;


	public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


	public int getRegId() {
		return regId;
	}


	public void setRegId(int regId) {
		this.regId = regId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getCustEmail() {
		return custEmail;
	}


	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}


	public String getCustMobile() {
		return custMobile;
	}


	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}


	public String getCustId() {
		return custId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}


	public String getCustAddress() {
		return custAddress;
	}


	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getGstId() {
		return gstId;
	}


	public void setGstId(String gstId) {
		this.gstId = gstId;
	}


	public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public String getBillDueDate() {
		return billDueDate;
	}


	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}


	public String getBillDate() {
		return billDate;
	}


	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}


	public String getBillPeriod() {
		return billPeriod;
	}


	public void setBillPeriod(String billPeriod) {
		this.billPeriod = billPeriod;
	}


	public String getServiceCode() {
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public String getSAC() {
		return SAC;
	}


	public void setSAC(String sAC) {
		SAC = sAC;
	}
	
	
}
