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
"constructorStandings",
"StandingsLists"
})
public class StandingsTable  {

	@JsonProperty("season")
	private String season;
	@JsonProperty("constructorStandings")
	private String constructorStandings;
	@JsonProperty("StandingsLists")
	private List<StandingsList> standingsLists = null;
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

	@JsonProperty("constructorStandings")
	public String getConstructorStandings() {
	return constructorStandings;
	}

	@JsonProperty("constructorStandings")
	public void setConstructorStandings(String constructorStandings) {
	this.constructorStandings = constructorStandings;
	}

	@JsonProperty("StandingsLists")
	public List<StandingsList> getStandingsLists() {
	return standingsLists;
	}

	@JsonProperty("StandingsLists")
	public void setStandingsLists(List<StandingsList> standingsLists) {
	this.standingsLists = standingsLists;
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
