package com.deazzle.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultData {

    private AuthorizationInfo Authorization_Info;

    @JsonProperty("Authorization_Info")
    public AuthorizationInfo getAuthorization_Info() { return Authorization_Info; }
    @JsonProperty("Authorization_Info")
    public void setAuthorization_Info(AuthorizationInfo value) { this.Authorization_Info = value; }
	
	
	
}
