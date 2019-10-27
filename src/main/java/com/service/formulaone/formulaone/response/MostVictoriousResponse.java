package com.service.formulaone.formulaone.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*@Value*/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "lstMostVictorious" })
public class MostVictoriousResponse {

	@JsonProperty("lstMostVictorious")
	private List<CustomResponse> lstMostVictorious = null;

	public MostVictoriousResponse() {
		super();
	}

	public MostVictoriousResponse(List<CustomResponse> lstMostVictorious) {
		super();
		this.lstMostVictorious = lstMostVictorious;
	}

	@JsonProperty("lstMostVictorious")
	public List<CustomResponse> getLstMostVictorious() {
		return lstMostVictorious;
	}

	@JsonProperty("lstMostVictorious")

	public void setLstMostVictorious(List<CustomResponse> lstMostVictorious) {
		this.lstMostVictorious = lstMostVictorious;
	}

}
