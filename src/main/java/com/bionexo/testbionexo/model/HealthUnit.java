package com.bionexo.testbionexo.model;

import static java.util.Optional.ofNullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthUnit {
	
	@JsonProperty(required = true)
	private Integer id;

	@JsonProperty(required = true)
	private String name;
	
	@JsonProperty(required = true)
	private String address;
	
	@JsonProperty(required = true)
	private String city;
	
	@JsonProperty(required = true)
	private String phone;
	
	@JsonProperty(required = true)
	private Score score;

	@JsonProperty(required = true)
	private Geocode geocode;
	
	
	public HealthUnit(Integer id, String name, String address, String city, String phone, Score score,
			Geocode geocode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.score = score;
		this.geocode = geocode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Geocode getGeocode() {
		return geocode;
	}

	public void setGeocode(Geocode geocode) {
		this.geocode = geocode;
	}
	
	

}
