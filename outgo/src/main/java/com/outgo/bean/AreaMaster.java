package com.outgo.bean;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Area_Master")

public class AreaMaster  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	long area_id;
	private String area_name;
	long city_id;
	//long sub_area_id;
	boolean status;
	public long getArea_id() {
		return area_id;
	}
	public void setArea_id(long area_id) {
		this.area_id = area_id;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public long getCity_id() {
		return city_id;
	}
	public void setCity_id(long city_id) {
		this.city_id = city_id;
	}
/*	public long getSub_area_id() {
		return sub_area_id;
	}
	public void setSub_area_id(long sub_area_id) {
		this.sub_area_id = sub_area_id;
	}
*/	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
