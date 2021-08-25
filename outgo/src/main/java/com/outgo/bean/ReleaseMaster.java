/**
 * 
 */
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
@Table(name="Release_Master")
public class ReleaseMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long release_id;
	long release_code;
	double release_amount;
	double release_total_amount;
	double release_self_amount;
	double release_pg_amount;
	private String release_pg_mode;
	private String release_payout_ref_no_desc;
	private String release_name;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)

	private Date release_date;
	private Date release_payout_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_payout_date;
	int release_flag;
	boolean status;
	public long getRelease_id() {
		return release_id;
	}
	public void setRelease_id(long release_id) {
		this.release_id = release_id;
	}
	public long getRelease_code() {
		return release_code;
	}
	public void setRelease_code(long release_code) {
		this.release_code = release_code;
	}
	public double getRelease_amount() {
		return release_amount;
	}
	public void setRelease_amount(double release_amount) {
		this.release_amount = release_amount;
	}
	public double getRelease_total_amount() {
		return release_total_amount;
	}
	public void setRelease_total_amount(double release_total_amount) {
		this.release_total_amount = release_total_amount;
	}
	public double getRelease_self_amount() {
		return release_self_amount;
	}
	public void setRelease_self_amount(double release_self_amount) {
		this.release_self_amount = release_self_amount;
	}
	public double getRelease_pg_amount() {
		return release_pg_amount;
	}
	public void setRelease_pg_amount(double release_pg_amount) {
		this.release_pg_amount = release_pg_amount;
	}
	public String getRelease_pg_mode() {
		return release_pg_mode;
	}
	public void setRelease_pg_mode(String release_pg_mode) {
		this.release_pg_mode = release_pg_mode;
	}
	public String getRelease_payout_ref_no_desc() {
		return release_payout_ref_no_desc;
	}
	public void setRelease_payout_ref_no_desc(String release_payout_ref_no_desc) {
		this.release_payout_ref_no_desc = release_payout_ref_no_desc;
	}
	public String getRelease_name() {
		return release_name;
	}
	public void setRelease_name(String release_name) {
		this.release_name = release_name;
	}
	
	public int getRelease_flag() {
		return release_flag;
	}
	public void setRelease_flag(int release_flag) {
		this.release_flag = release_flag;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public Date getRelease_payout_date() {
		return release_payout_date;
	}
	public void setRelease_payout_date(Date release_payout_date) {
		this.release_payout_date = release_payout_date;
	}
	public Date getUpdate_payout_date() {
		return update_payout_date;
	}
	public void setUpdate_payout_date(Date update_payout_date) {
		this.update_payout_date = update_payout_date;
	}
	
	
}
