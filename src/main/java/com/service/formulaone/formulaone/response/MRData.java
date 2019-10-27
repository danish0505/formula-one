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
@JsonPropertyOrder({ "xmlns", "series", "url", "limit", "offset", "total", "StandingsTable" })
public class MRData {
	@JsonProperty("xmlns")
	private String xmlns;
	@JsonProperty("series")
	private String series;
	@JsonProperty("url")
	private String url;
	@JsonProperty("limit")
	private String limit;
	@JsonProperty("offset")
	private String offset;
	@JsonProperty("total")
	private String total;
	@JsonProperty("StandingsTable")
	private StandingsTable standingsTable;
	@JsonProperty("ConstructorTable")
	private ConstructorTable constructorTable;
	@JsonProperty("DriverTable")
	private DriverTable driverTable;
	@JsonProperty("RaceTable")
	private RaceTable raceTable;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("xmlns")
	public String getXmlns() {
		return xmlns;
	}

	@JsonProperty("xmlns")
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	@JsonProperty("series")
	public String getSeries() {
		return series;
	}

	@JsonProperty("series")
	public void setSeries(String series) {
		this.series = series;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("limit")
	public String getLimit() {
		return limit;
	}

	@JsonProperty("limit")
	public void setLimit(String limit) {
		this.limit = limit;
	}

	@JsonProperty("offset")
	public String getOffset() {
		return offset;
	}

	@JsonProperty("offset")
	public void setOffset(String offset) {
		this.offset = offset;
	}

	@JsonProperty("total")
	public String getTotal() {
		return total;
	}

	@JsonProperty("total")
	public void setTotal(String total) {
		this.total = total;
	}

	@JsonProperty("StandingsTable")
	public StandingsTable getStandingsTable() {
		return standingsTable;
	}

	@JsonProperty("StandingsTable")
	public void setStandingsTable(StandingsTable standingsTable) {
		this.standingsTable = standingsTable;
	}

	@JsonProperty("ConstructorTable")
	public ConstructorTable getConstructorTable() {
		return constructorTable;
	}

	@JsonProperty("ConstructorTable")
	public void setConstructorTable(ConstructorTable constructorTable) {
		this.constructorTable = constructorTable;
	}

	@JsonProperty("DriverTable")
	public DriverTable getDriverTable() {
		return driverTable;
	}

	@JsonProperty("DriverTable")
	public void setDriverTable(DriverTable driverTable) {
		this.driverTable = driverTable;
	}

	@JsonProperty("RaceTable")
	public RaceTable getRaceTable() {
		return raceTable;
	}

	@JsonProperty("RaceTable")
	public void setRaceTable(RaceTable raceTable) {
		this.raceTable = raceTable;
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
