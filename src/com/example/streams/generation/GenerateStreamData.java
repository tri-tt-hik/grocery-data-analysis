package com.example.streams.generation;

import java.util.Map;

public class GenerateStreamData {
	public static void main(String[] args) {
		Map<String, String> coords = RandomDataGenUtility
				.randomLonLat(12, 14, 80, 82);
		System.out.println(coords.get("J")+","+coords.get("W"));
		
		String[] paymentMethod = {"cash", "gpay", "paytm", 
				"phone-pe", "post-paid"};
		System.out.println(RandomDataGenUtility.randomElement(paymentMethod));
		
		String[] typeOfVehicle =  {"Two-Wheeler", "Auto", "Mini", "Sedan", "SUV"};
		System.out.println(RandomDataGenUtility.randomElement(typeOfVehicle));
		
		String[] passengers = {"Ajay", "Bala", "Cyan", "Dinesh", "Ezhil" };
		System.out.println(RandomDataGenUtility.randomElement(passengers));
		
		System.out.println(RandomDataGenUtility.randomPhoneno());
		
		System.out.println("Price" + RandomDataGenUtility.randomBetween(100, 876));
	}
	
}
