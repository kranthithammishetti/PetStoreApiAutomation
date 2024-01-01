package api.petstore.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Common {
	public static String currentDateTimeWithHMS() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		LocalDateTime currentDateTime = LocalDateTime.now();
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}
}
