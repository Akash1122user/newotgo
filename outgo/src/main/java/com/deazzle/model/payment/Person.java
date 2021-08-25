package com.deazzle.model.payment;


import com.fasterxml.jackson.annotation.*;

public class Person {
    private long[] phoneNumber;    
    @JsonProperty("phone_number")
    public long[] getPhoneNumber() { return phoneNumber; }
    @JsonProperty("phone_number")
    public void setPhoneNumber(long[] value) { this.phoneNumber = value; }
    
    String[] name;
    String[] email;
    String http_referrer="outgo";
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("name")
	public String[] getName() {
		return name;
	}
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("name")
	public void setName(String[] name) {
		this.name = name;
	}
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("email")
	public String[] getEmail() {
		return email;
	}
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("email")
	public void setEmail(String[] email) {
		this.email = email;
	}
    @JsonProperty("http_referrer")
		public String getHttp_referrer() {
		return http_referrer;
	}
	 @JsonProperty("http_referrer")
			public void setHttp_referrer(String http_referrer) {
		this.http_referrer = http_referrer;
	}
    
    
    
    
}

