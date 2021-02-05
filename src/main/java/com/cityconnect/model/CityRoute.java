package com.cityconnect.model;

public class CityRoute {
	String origin;
	String destination;
	public CityRoute(String origin, String destination){
		this.destination=destination;
		this.origin=origin;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

}
