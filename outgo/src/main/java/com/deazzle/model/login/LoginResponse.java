package com.deazzle.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

	String ResultCode;
	ResultData ResultData;
	
	@JsonProperty("ResultCode")
	public String getResultCode() {
		return ResultCode;
	}

	@JsonProperty("ResultCode")
	public void setResultCode(String resultCode) {
		this.ResultCode = resultCode;
	}
	@JsonProperty("ResultData")
	public ResultData getResultData() {
		return ResultData;
	}
	@JsonProperty("ResultData")
	public void setResultData(ResultData resultData) {
		this.ResultData = resultData;
	}
	

}
