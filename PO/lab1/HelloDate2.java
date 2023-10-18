import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloDate2 {

	public static void main(String[] args) {
		LocalDate date_now =  LocalDate.now();
		LocalTime time_now = LocalTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
		
		String date = date_now.format(formatter);
		String time = time_now.format(formatter2);
		
		System.out.println("Witaj, Teraz jest: " + date + " " +  time);
	}

}
