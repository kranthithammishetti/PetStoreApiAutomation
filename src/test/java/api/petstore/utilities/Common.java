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
		Random random = new Random();
		int number = random.nextInt(origin, toNum);
		return number;
	}
}
