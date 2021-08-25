package com.deazzle.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationInfo {
	private String access_token;
    private String scope;
    private String token_type;
    private long expires_in;
    private String refresh_token;

    @JsonProperty("access_token")
    public String getAccess_token() { return access_token; }
    @JsonProperty("access_token")
    public void setAccess_token(String value) { this.access_token = value; }

    @JsonProperty("scope")
    public String getScope() { return scope; }
    @JsonProperty("scope")
    public void setScope(String value) { this.scope = value; }

    @JsonProperty("token_type")
    public String getToken_type() { return token_type; }
    @JsonProperty("token_type")
    public void setToken_type(String value) { this.token_type = value; }

    @JsonProperty("expires_in")
    public long getExpires_in() { return expires_in; }
    @JsonProperty("expires_in")
    public void setExpires_in(long value) { this.expires_in = value; }

    @JsonProperty("refresh_token")
    public String getRefresh_token() { return refresh_token; }
    @JsonProperty("refresh_token")
    public void setRefresh_token(String value) { this.refresh_token = value; }
}
