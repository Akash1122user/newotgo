package com.outgo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Contact_login")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="mobileNo", unique=true, nullable=false)
	private String mobileNo;
	
	@Column(name="password", nullable=false)
	private String password;
	
	private String token;
	private String employeeName;


	@Column(name="email", nullable=false)
	private String email;

	@Column(name="merchantId", nullable=false)
	private long merchantId;

	
	@Column(name="STATE", nullable=false)
	private String state=State.ACTIVE.getState();
	
	boolean verify_mobile;
	boolean verify_email;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "AssignRole", 
             joinColumns = { @JoinColumn(name = "Contact_Id") }, 
             inverseJoinColumns = { @JoinColumn(name = "User_Role") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		long result = 1;
		result = prime * result + id;
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		return (int)result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}

	public boolean isVerify_mobile() {
		return verify_mobile;
	}

	public void setVerify_mobile(boolean verify_mobile) {
		this.verify_mobile = verify_mobile;
	}

	public boolean isVerify_email() {
		return verify_email;
	}

	public void setVerify_email(boolean verify_email) {
		this.verify_email = verify_email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", merchantId=" + merchantId 
				+ ", email=" + email + ", state=" + state + ", verify_mobile="+verify_mobile+" , verify_email="+verify_email+", userProfiles=" + userProfiles +"]";
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}
