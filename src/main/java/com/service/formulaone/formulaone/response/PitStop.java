package com.service.formulaone.formulaone.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "driverId", "lap", "stop", "time", "duration" })
public class PitStop {
	@JsonProperty("driverId")
	private String driverId;
	@JsonProperty("lap")
	private String lap;
	@JsonProperty("stop")
	private String stop;
	@JsonProperty("time")
	private String time;
	@JsonProperty("duration")
	private String duration;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("driverId")
	public String getDriverId() {
		return driverId;
	}

	@JsonProperty("driverId")
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	@JsonProperty("lap")
	public String getLap() {
		return lap;
	}

	@JsonProperty("lap")
	public void setLap(String lap) {
		this.lap = lap;
	}

	@JsonProperty("stop")
	public String getStop() {
		return stop;
	}

	@JsonProperty("stop")
	public void setStop(String stop) {
		this.stop = stop;
	}

	@JsonProperty("time")
	public String getTime() {
		return time;
	}

	@JsonProperty("time")
	public void setTime(String time) {
		this.time = time;
	}

	@JsonProperty("duration")
	public String getDuration() {
		return duration;
	}

	@JsonProperty("duration")
	public void setDuration(String duration) {
		this.duration = duration;
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
