package com.service.formulaone.formulaone.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"season",
"round",
"ConstructorStandings"
})
public class StandingsList {
	@JsonProperty("season")
	private String season;
	@JsonProperty("round")
	private String round;
	@JsonProperty("ConstructorStandings")
	private List<ConstructorStanding> constructorStandings = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("season")
	public String getSeason() {
	return season;
	}

	@JsonProperty("season")
	public void setSeason(String season) {
	this.season = season;
	}

	@JsonProperty("round")
	public String getRound() {
	return round;
	}

	@JsonProperty("round")
	public void setRound(String round) {
	this.round = round;
	}

	@JsonProperty("ConstructorStandings")
	public List<ConstructorStanding> getConstructorStandings() {
	return constructorStandings;
	}

	@JsonProperty("ConstructorStandings")
	public void setConstructorStandings(List<ConstructorStanding> constructorStandings) {
	this.constructorStandings = constructorStandings;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}


}
