package com.deazzle.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PaymentResponesList {

	
	
	
	 @SerializedName("ResultData")
	    @Expose
	 private PaymnetData[] ResultData;

	    private String ResultCode;

	    public PaymnetData[] getResultData ()
	    {
	        return ResultData;
	    }

	    public void setResultData (PaymnetData[] ResultData)
	    {
	        this.ResultData = ResultData;
	    }

	    public String getResultCode ()
	    {
	        return ResultCode;
	    }

	    public void setResultCode (String ResultCode)
	    {
	        this.ResultCode = ResultCode;
	    }
}
