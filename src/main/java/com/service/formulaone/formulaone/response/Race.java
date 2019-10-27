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
@JsonPropertyOrder({ "season", "round", "url", "raceName", "Circuit", "date", "time", "PitStops" })
public class Race {
	@JsonProperty("season")
	private String season;
	@JsonProperty("round")
	private String round;
	@JsonProperty("url")
	private String url;
	@JsonProperty("raceName")
	private String raceName;
	@JsonProperty("Circuit")
	private Circuit circuit;
	@JsonProperty("date")
	private String date;
	@JsonProperty("time")
	private String time;
	@JsonProperty("PitStops")
	private List<PitStop> pitStops = null;
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

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("raceName")
	public String getRaceName() {
		return raceName;
	}

	@JsonProperty("raceName")
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	@JsonProperty("Circuit")
	public Circuit getCircuit() {
		return circuit;
	}

	@JsonProperty("Circuit")
	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("time")
	public String getTime() {
		return time;
	}

	@JsonProperty("time")
	public void setTime(String time) {
		this.time = time;
	}

	@JsonProperty("PitStops")
	public List<PitStop> getPitStops() {
		return pitStops;
	}

	@JsonProperty("PitStops")
	public void setPitStops(List<PitStop> pitStops) {
		this.pitStops = pitStops;
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
