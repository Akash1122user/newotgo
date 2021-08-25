package com.outgo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Income_Master")
public class IncomeMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long income_id;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	
	String income_selectedDate;
	
	public String getIncome_selectedDate() {
		return income_selectedDate;
	}
	public void setIncome_selectedDate(String income_selectedDate) {
		this.income_selectedDate = income_selectedDate;
	}
	long regi_id;
	//long income_cat_id;
	String income_discription;
	boolean status;
	
	double income_amount;
	String income_category;
	
	public double getIncome_amount() {
		return income_amount;
	}
	public void setIncome_amount(double income_amount) {
		this.income_amount = income_amount;
	}
	public long getIncome_id() {
		return income_id;
	}
	public void setIncome_id(long income_id) {
		this.income_id = income_id;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public long getRegi_id() {
		return regi_id;
	}
	public void setRegi_id(long regi_id) {
		this.regi_id = regi_id;
	}
	
	public String getIncome_category() {
		return income_category;
	}
	public void setIncome_category(String income_category) {
		this.income_category = income_category;
	}
	/*public long getIncome_cat_id() {
		return income_cat_id;
	}
	public void setIncome_cat_id(long income_cat_id) {
		this.income_cat_id = income_cat_id;
	}*/
	public String getIncome_discription() {
		return income_discription;
	}
	public void setIncome_discription(String income_discription) {
		this.income_discription = income_discription;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
