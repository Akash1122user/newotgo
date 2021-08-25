package com.deazzle.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

	String ResultCode;
	Object ResultData;
	
	@JsonProperty("ResultCode")
	public String getResultCode() {
		return ResultCode;
	}

	@JsonProperty("ResultCode")
	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}
	@JsonProperty("ResultData")
	public Object getResultData() {
		return ResultData;
	}
	@JsonProperty("ResultData")
	public void setResultData(Object resultData) {
		ResultData = resultData;
	}
	

}
