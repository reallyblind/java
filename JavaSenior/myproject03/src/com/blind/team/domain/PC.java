package com.blind.team.domain;

public class PC implements Equipment{

	private String model;
	private String display;
	
	
	public PC() {
		super();
	}


	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getDisplay() {
		return display;
	}


	public void setDisplay(String display) {
		this.display = display;
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "(" + display + ")";
	}
	
}
