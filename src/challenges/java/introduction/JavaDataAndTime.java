package challenges.java.introduction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;


public class JavaDataAndTime {
	private static final String[] DAYS_ARRAY ={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	public static void main(String[] args) throws IOException, ParseException {
		InputStream inputStream = JavaDataAndTime.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		File file = new File(properties.getProperty("input.path") + "java_date_and_time.txt");
		Scanner in = new Scanner(file);
		// Scanner in = new Scanner(System.in);
		String dateStr = in.nextLine();
		DateFormat dateFormat = new SimpleDateFormat("MM dd yyyy");
		Date parse = dateFormat.parse(dateStr);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parse);
		System.out.println(DAYS_ARRAY[calendar.get(Calendar.DAY_OF_WEEK)-1].toUpperCase());
		in.close();
	}
}
