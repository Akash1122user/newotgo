package com.deazzle.model.payment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentResponse {


	String ResultCode;
	public List<ResultData> ResultData;
	
	@JsonProperty("ResultCode")
	public String getResultCode() {
		return ResultCode;
	}

	@JsonProperty("ResultCode")
	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}
	@JsonProperty("ResultData")
	public List<ResultData> getResultData() {
		return ResultData;
	}
	@JsonProperty("ResultData")
	public void setResultData(List<ResultData> resultData) {
		this.ResultData = resultData;
	}
	
}
