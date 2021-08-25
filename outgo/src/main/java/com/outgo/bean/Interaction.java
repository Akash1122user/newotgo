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

/**
 * @author Amol Delmade
 *	class: Interaction Details  
 */
@Entity
@Table(name="Interaction")
public class Interaction {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long interaction_Id;
	
	String mobile;
	String email;
	String name;
	long merchantId;
	long serviceId;
	String description;
	long ref_Id;
	String ref_teb;
	String  interaction;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date interaction_date;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date interaction_update_date;
	public long getInteraction_Id() {
		return interaction_Id;
	}
	public void setInteraction_Id(long interaction_Id) {
		this.interaction_Id = interaction_Id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getRef_Id() {
		return ref_Id;
	}
	public void setRef_Id(long ref_Id) {
		this.ref_Id = ref_Id;
	}
	public String getRef_teb() {
		return ref_teb;
	}
	public void setRef_teb(String ref_teb) {
		this.ref_teb = ref_teb;
	}
	public String getInteraction() {
		return interaction;
	}
	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}
	public Date getInteraction_date() {
		return interaction_date;
	}
	public void setInteraction_date(Date interaction_date) {
		this.interaction_date = interaction_date;
	}
	public Date getInteraction_update_date() {
		return interaction_update_date;
	}
	public void setInteraction_update_date(Date interaction_update_date) {
		this.interaction_update_date = interaction_update_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
