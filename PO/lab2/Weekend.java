package lab2;

import java.util.Date;

public class Weekend {

	public static void main(String[] args) {
		Date date = new Date();
		int now_date = date.getDay();
		if (0 < now_date && now_date < 6) {
			System.out.println("Do weekendu pozostało: " + (6 - now_date) + " dni");
		}
		else {
			System.out.println("Mamy weekend!");
		}
			
	}

}
