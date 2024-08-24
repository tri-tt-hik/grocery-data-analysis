package com.example.streams.generation;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import com.example.streams.generation.TripInfo.Coordinate;

public class GenerateTripInfoStreamToKafka {
	public static void main(String[] args) throws InterruptedException, IOException {
		while (true) {

			int recordsCount = RandomDataGenUtility.randomIntBetween(4, 15);
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

			}
			System.out.println(recordsCount + " records Sent to Kafka.");
			Thread.sleep(5000);
		}

	}
}
