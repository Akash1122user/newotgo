package com.deazzle.model.easebuzzkeys;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class EaseBuzz {
    private String objectID;
    private String mobileNo;
    private String subMerchantID;

    @JsonProperty("objectId")
    public String getObjectID() { return objectID; }
    @JsonProperty("objectId")
    public void setObjectID(String value) { this.objectID = value; }

    @JsonProperty("mobileNo")
    public String getMobileNo() { return mobileNo; }
    @JsonProperty("mobileNo")
    public void setMobileNo(String value) { this.mobileNo = value; }

    @JsonProperty("subMerchantId")
    public String getSubMerchantID() { return subMerchantID; }
    @JsonProperty("subMerchantId")
    public void setSubMerchantID(String value) { this.subMerchantID = value; }
}
