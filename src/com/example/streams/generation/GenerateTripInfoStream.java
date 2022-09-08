package com.example.streams.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.example.streams.generation.TripInfo.Coordinate;

public class GenerateTripInfoStream {
	public static void main(String[] args) throws InterruptedException, IOException {
		File file = new File("trip-info.json");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		while (true) {

			int recordsCount = new Random().nextInt(15);
			for (int i = 0; i <= recordsCount; i++) {
				TripInfo tripInfo = new TripInfo();
				Map<String, String> coords = RandomDataGenUtility.randomLonLat(12, 14, 80, 82);

				Coordinate p1 = new Coordinate();
				p1.setLat(Double.parseDouble(coords.get("J")));
				p1.setLon(Double.parseDouble(coords.get("W")));

				tripInfo.setPickupPoint(p1);

				coords = RandomDataGenUtility.randomLonLat(10, 12, 77, 80);

				Coordinate p2 = new Coordinate();
				p2.setLat(Double.parseDouble(coords.get("J")));
				p2.setLon(Double.parseDouble(coords.get("W")));

				tripInfo.setDropPoint(p2);
				tripInfo.setSearchId(UUID.randomUUID().toString());

				String[] typeOfVehicle = { "Two-Wheeler", "Auto", "Mini", "Sedan", "SUV" };
				tripInfo.setTypeOfVehicle(RandomDataGenUtility.randomElement(typeOfVehicle));

				String[] paymentMethod = { "cash", "gpay", "paytm", "phone-pe", "post-paid" };
				tripInfo.setPaymentMethod(RandomDataGenUtility.randomElement(paymentMethod));

				String[] passengers = { "Ajay", "Bala", "Cyan", "Dinesh", "Ezhil" };
				tripInfo.setPrimaryPassangerName(RandomDataGenUtility.randomElement(passengers));

				tripInfo.setPrimaryPassangerContact(RandomDataGenUtility.randomPhoneno());

				tripInfo.setEstimatedPrice(RandomDataGenUtility.randomBetween(100, 876));

				bw.write(tripInfo.toString()+"\n");
				
			}
			
			bw.flush();
			Thread.sleep(1000);
			System.out.println("written "+recordsCount +" to the file.");
		}
		
	}
}
