/**
 * 
 */
package com.outgo.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sub_Area_Master")
public class SubAreaMaster implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long sub_area_id;
	long city_id;
	private String sub_area_name;
	boolean status;
	public long getSub_area_id() {
		return sub_area_id;
	}
	public void setSub_area_id(long sub_area_id) {
		this.sub_area_id = sub_area_id;
	}
	public long getCity_id() {
		return city_id;
	}
	public void setCity_id(long city_id) {
		this.city_id = city_id;
	}
	public String getSub_area_name() {
		return sub_area_name;
	}
	public void setSub_area_name(String sub_area_name) {
		this.sub_area_name = sub_area_name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
