package com.example.streams.generation;

import com.google.gson.Gson;

public class TripInfo {

	private String searchId;
	private Coordinate pickupPoint;
	private Coordinate dropPoint;
	private String typeOfVehicle;
	private String paymentMethod;
	private String primaryPassangerName;
	private String primaryPassangerContact;
	private double estimatedPrice;
	
	
	public String getSearchId() {
		return searchId;
	}


	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}


	public Coordinate getPickupPoint() {
		return pickupPoint;
	}


	public void setPickupPoint(Coordinate pickupPoint) {
		this.pickupPoint = pickupPoint;
	}


	public Coordinate getDropPoint() {
		return dropPoint;
	}


	public void setDropPoint(Coordinate dropPoint) {
		this.dropPoint = dropPoint;
	}


	public String getTypeOfVehicle() {
		return typeOfVehicle;
	}


	public void setTypeOfVehicle(String typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getPrimaryPassangerName() {
		return primaryPassangerName;
	}


	public void setPrimaryPassangerName(String primaryPassangerName) {
		this.primaryPassangerName = primaryPassangerName;
	}


	public String getPrimaryPassangerContact() {
		return primaryPassangerContact;
	}


	public void setPrimaryPassangerContact(String primaryPassangerContact) {
		this.primaryPassangerContact = primaryPassangerContact;
	}


	public double getEstimatedPrice() {
		return estimatedPrice;
	}


	public void setEstimatedPrice(double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}


	@Override
	public String toString() {
		return new Gson().toJson(this);
	}


	public static class Coordinate{
		private double lon;
		private double lat;
		public double getLon() {
			return lon;
		}
		public void setLon(double lon) {
			this.lon = lon;
		}
		public double getLat() {
			return lat;
		}
		public void setLat(double lat) {
			this.lat = lat;
		}
		@Override
		public String toString() {
			return String.format("%s,%s", lat, lon);
		}
		
		
	}
}
