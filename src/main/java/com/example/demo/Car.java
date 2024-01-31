package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String model;
	
	@OneToOne
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "id", "model","car" })
	private Owner owner;
	
	public Car(int id, String model) {
		super();
		this.id = id;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + "]";
	}
	
	
	

}
