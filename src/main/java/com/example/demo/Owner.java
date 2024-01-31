package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String city;
	
	@OneToOne
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "id", "name","city", "owner" })
	private Car car;

	public Owner(int id, String name, String city, Car car) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.car = car;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", city=" + city + ", car=" + car + "]";
	}
	
	
	

}
