package com.service.formulaone.formulaone.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"rank",
"nationality",
"victories"
})
public class CustomResponse {

	@JsonProperty("rank")
	private int rank;
	@JsonProperty("nationality")
	private String nationality;
	@JsonProperty("victories")
	private int victories;

	public CustomResponse() {
		super();
	}

	public CustomResponse(int rank, String nationality, int victories) {
		super();
		this.rank = rank;
		this.nationality = nationality;
		this.victories = victories;
	}

	@JsonProperty("rank")
	public int getRank() {
		return rank;
	}

	@JsonProperty("rank")
	public void setRank(int i) {
		this.rank = i;
	}

	@JsonProperty("nationality")
	public String getNationality() {
		return nationality;
	}

	@JsonProperty("nationality")
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@JsonProperty("victories")
	public int getVictories() {
		return victories;
	}

	@JsonProperty("victories")
	public void setVictories(int victories) {
		this.victories = victories;
	}

}
