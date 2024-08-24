package com.example.streams.generation;

import com.google.gson.Gson;

public class TripInfo {

	private String productId;
	
	private String groceryStoreName;
	
	private String productName;
	
	private int quantity;
	private double estimatedPrice;
	
	
	public String getproductId() {
		return productId;
	}


	public void setproductId(String productId) {
		this.productId = productId;
	}

	public int getquantity() {
		return quantity;
	}


	public void setquantity(int quantity) {
		this.quantity =quantity;
	}

	public String getgroceryStoreName() {
		return groceryStoreName;
	}


	public void setgroceryStoreName(String groceryStoreName) {
		this.groceryStoreName = groceryStoreName;
	}

	public String getproductName() {
		return productName;
	}


	public void setproductName(String productName) {
		this.productName = productName;
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
