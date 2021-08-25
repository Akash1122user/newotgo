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
@Table(name="Expence_Master")
public class ExpenceMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long expence_id;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	long regi_id;
	String expense_category;
	//long cat_id;
	String expense_discription;
	boolean status;
	String expense_selectedDate;
	double expense_amount;
	
	public String getExpense_category() {
		return expense_category;
	}
	public void setExpense_category(String expense_category) {
		this.expense_category = expense_category;
	}
	public double getExpense_amount() {
		return expense_amount;
	}
	public void setExpense_amount(double expense_amount) {
		this.expense_amount = expense_amount;
	}
	public long getExpence_id() {
		return expence_id;
	}
	public void setExpence_id(long expence_id) {
		this.expence_id = expence_id;
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
	/*public long getCat_id() {
		return cat_id;
	}
	public void setCat_id(long cat_id) {
		this.cat_id = cat_id;
	}*/
	
	public String getExpense_discription() {
		return expense_discription;
	}
	public void setExpense_discription(String expense_discription) {
		this.expense_discription = expense_discription;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getExpense_selectedDate() {
		return expense_selectedDate;
	}
	public void setExpense_selectedDate(String expense_selectedDate) {
		this.expense_selectedDate = expense_selectedDate;
	}
	
}
