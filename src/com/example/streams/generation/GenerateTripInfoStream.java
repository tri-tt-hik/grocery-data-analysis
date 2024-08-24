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
				tripInfo.setproductId(UUID.randomUUID().toString());

				String[] groceryStoreName = { "Chera Stores" , "Grace" , "Saravana Stores" , "Nilgris" , "Pandian Stores" , "Chola Stores" };
				tripInfo.setgroceryStoreName(RandomDataGenUtility.randomElement(groceryStoreName));



				String[] productname = { "Colgate", "Harpic", "Milk", "Flour", "Chicken" };
				tripInfo.setproductName(RandomDataGenUtility.randomElement(productname));

				tripInfo.setquantity(RandomDataGenUtility.randomIntBetween(1, 15));

				tripInfo.setEstimatedPrice(RandomDataGenUtility.randomBetween(100, 876));

				TestKafkaProducer.sendDataToKafka("grocery", tripInfo.toString(), tripInfo.getproductId());

				bw.write(tripInfo.toString()+"\n");
				
			}
			
			bw.flush();
			Thread.sleep(1000);
			System.out.println("written "+recordsCount +" to the file.");
		}
		
	}
}
