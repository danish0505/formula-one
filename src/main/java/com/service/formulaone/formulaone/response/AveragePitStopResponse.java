package com.service.formulaone.formulaone.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "res" })
public class AveragePitStopResponse {
	@JsonProperty("res")
	private List<CustomAverageTimeResponse> res = null;
	
	public AveragePitStopResponse(){
		super();
	}

	public AveragePitStopResponse(List<CustomAverageTimeResponse> res) {
		super();
		this.res = res;
	}

	@JsonProperty("res")
	public List<CustomAverageTimeResponse> getRes() {
		return res;
	}

	@JsonProperty("res")
	public void setRes(List<CustomAverageTimeResponse> res) {
		this.res = res;
	}

}
