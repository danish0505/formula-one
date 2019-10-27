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
@JsonPropertyOrder({ "season", "constructorId", "Drivers" })
public class DriverTable {
	@JsonProperty("season")
	private String season;
	@JsonProperty("constructorId")
	private String constructorId;
	@JsonProperty("Drivers")
	private List<Driver> drivers = null;
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

	@JsonProperty("constructorId")
	public String getConstructorId() {
		return constructorId;
	}

	@JsonProperty("constructorId")
	public void setConstructorId(String constructorId) {
		this.constructorId = constructorId;
	}

	@JsonProperty("Drivers")
	public List<Driver> getDrivers() {
		return drivers;
	}

	@JsonProperty("Drivers")
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
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
