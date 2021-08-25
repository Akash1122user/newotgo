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
@Table(name="Expense_Categories")
public class ExpenseCategories {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long expence_cat_id;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	long regi_id;
	String category;
	String category_type;
	boolean status;
	public long getExpence_cat_id() {
		return expence_cat_id;
	}
	public void setExpence_cat_id(long expence_cat_id) {
		this.expence_cat_id = expence_cat_id;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory_type() {
		return category_type;
	}
	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
