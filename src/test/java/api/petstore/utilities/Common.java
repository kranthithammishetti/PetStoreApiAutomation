package api.petstore.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Common {
	public static String currentDateTimeWithHMS() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		LocalDateTime currentDateTime = LocalDateTime.now();
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}

	public static int randomNumberBetween(int origin, int toNum) {

		// Create a Random object
		Random random = new Random();

		// Generate a random number within the specified range
		int randomNumber = random.nextInt(toNum - origin + 1) + origin;

		// Print the generated random number
		System.out.println("Random Number: " + randomNumber);

		return randomNumber;
	}

	// for testing
	/*
	 * public static void main(String[] args) { randomNumberBetween(1, 6); }
	 */

}
