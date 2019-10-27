package com.service.formulaone.formulaone.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "rank", "constructorName", "averagePitStopTime", "fastestPitStopTime", "slowestPitStopTime" })
public class CustomAverageTimeResponse {

	@JsonProperty("rank")
	private int rank;
	@JsonProperty("constructorName")
	private String constructorName;
	@JsonProperty("averagePitStopTime")
	private String averagePitStopTime;
	@JsonProperty("fastestPitStopTime")
	private String fastestPitStopTime;
	@JsonProperty("slowestPitStopTime")
	private String slowestPitStopTime;

	public CustomAverageTimeResponse() {
		super();
	}

	public CustomAverageTimeResponse(int rank, String constructorName, String averagePitStopTime,
			String fastestPitStopTime, String slowestPitStopTime) {
		super();
		this.rank = rank;
		this.constructorName = constructorName;
		this.averagePitStopTime = averagePitStopTime;
		this.fastestPitStopTime = fastestPitStopTime;
		this.slowestPitStopTime = slowestPitStopTime;
	}

	@JsonProperty("rank")
	public int getRank() {
		return rank;
	}

	@JsonProperty("rank")
	public void setRank(int rank) {
		this.rank = rank;
	}

	@JsonProperty("constructorName")
	public String getConstructorName() {
		return constructorName;
	}

	@JsonProperty("constructorName")
	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}

	@JsonProperty("averagePitStopTime")
	public String getAveragePitStopTime() {
		return averagePitStopTime;
	}

	@JsonProperty("averagePitStopTime")
	public void setAveragePitStopTime(String averagePitStopTime) {
		this.averagePitStopTime = averagePitStopTime;
	}

	@JsonProperty("fastestPitStopTime")
	public String getFastestPitStopTime() {
		return fastestPitStopTime;
	}

	@JsonProperty("fastestPitStopTime")
	public void setFastestPitStopTime(String fastestPitStopTime) {
		this.fastestPitStopTime = fastestPitStopTime;
	}

	@JsonProperty("slowestPitStopTime")
	public String getSlowestPitStopTime() {
		return slowestPitStopTime;
	}

	@JsonProperty("slowestPitStopTime")
	public void setSlowestPitStopTime(String slowestPitStopTime) {
		this.slowestPitStopTime = slowestPitStopTime;
	}

}
