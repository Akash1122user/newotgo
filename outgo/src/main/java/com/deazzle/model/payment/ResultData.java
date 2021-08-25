package com.deazzle.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultData {
	 public String object_id;
		@JsonProperty("object_id")

		public String getObject_id() {
			return object_id;
		}
		@JsonProperty("object_id")

		public void setObject_id(String object_id) {
			this.object_id = object_id;
		}
}
