package com.deazzle.model.payment;


import com.fasterxml.jackson.annotation.*;

public class Business {
    private String objectID;
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("object_id")
    public String getObjectID() { return objectID; }
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("object_id")
    public void setObjectID(String value) { this.objectID = value; }
    
    private long[] phoneNumber;    
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("phone_number")
    public long[] getPhoneNumber() { return phoneNumber; }
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("phone_number")
    public void setPhoneNumber(long[] value) { this.phoneNumber = value; }

}
