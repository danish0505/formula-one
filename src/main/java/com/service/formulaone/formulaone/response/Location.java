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
@JsonPropertyOrder({
"lat",
"long",
"locality",
"country"
})
public class Location {
	@JsonProperty("lat")
	private String lat;
	@JsonProperty("long")
	private String _long;
	@JsonProperty("locality")
	private String locality;
	@JsonProperty("country")
	private String country;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("lat")
	public String getLat() {
	return lat;
	}

	@JsonProperty("lat")
	public void setLat(String lat) {
	this.lat = lat;
	}

	@JsonProperty("long")
	public String getLong() {
	return _long;
	}

	@JsonProperty("long")
	public void setLong(String _long) {
	this._long = _long;
	}

	@JsonProperty("locality")
	public String getLocality() {
	return locality;
	}

	@JsonProperty("locality")
	public void setLocality(String locality) {
	this.locality = locality;
	}

	@JsonProperty("country")
	public String getCountry() {
	return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
	this.country = country;
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
