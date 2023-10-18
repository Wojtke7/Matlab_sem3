package lab2;

import java.util.Calendar;

public class Weekend2 {
	
	private final static String months[] = {"Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota"};
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int now_date = calendar.get(Calendar.DAY_OF_WEEK);
		
		if (1 < now_date && now_date < 6) {
			System.out.println("Dziś " +  months[now_date - 1] + ", do weekendu pozostało " + (7 - now_date) + " dni.");
		}
		else if (now_date == 6) {
			System.out.println("Dziś " + months[now_date - 1] + ", do weekendu pozostał 1 dzień");
		}
		else {
			System.out.println("Mamy weekend!");
		}
	}
}
