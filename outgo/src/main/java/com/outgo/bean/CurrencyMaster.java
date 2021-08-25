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
@Table(name="Currency_Master")
public class CurrencyMaster  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long currency_id;
	private String currency_name;
	private String currency_symbol;
	private String country;
	private String codeA;
	private String 	codeN;
	private String fafaIcon;
	private String htmlcode;
	boolean status;
	public long getCurrency_id() {
		return currency_id;
	}
	public void setCurrency_id(long currency_id) {
		this.currency_id = currency_id;
	}
	public String getCurrency_name() {
		return currency_name;
	}
	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCurrency_symbol() {
		return currency_symbol;
	}
	public void setCurrency_symbol(String currency_symbol) {
		this.currency_symbol = currency_symbol;
	}
	public String getCodeA() {
		return codeA;
	}
	public void setCodeA(String codeA) {
		this.codeA = codeA;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCodeN() {
		return codeN;
	}
	public void setCodeN(String codeN) {
		this.codeN = codeN;
	}
	public String getFafaIcon() {
		return fafaIcon;
	}
	public void setFafaIcon(String fafaIcon) {
		this.fafaIcon = fafaIcon;
	}
	public String getHtmlcode() {
		return htmlcode;
	}
	public void setHtmlcode(String htmlcode) {
		this.htmlcode = htmlcode;
	}
	
}
