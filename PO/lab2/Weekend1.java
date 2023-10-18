package lab2;

import java.util.Date;

public class Weekend1 {

	public static void main(String[] args) {
		Date date = new Date();
		int now_date = date.getDay();
		
		switch (now_date) {
		
		case 1:
			System.out.println("Dziś jest Poniedziałek");
			break; 
		case 2:
			System.out.println("Dziś jest Wtorek");
			break;
		case 3:
			System.out.println("Dziś jest Środa");
			break;
		case 4:
			System.out.println("Dziś jest Czwartek");
			break;
		case 5:
			System.out.println("Dziś jest Piątek");
			break;
		default:
			System.out.println("Dziś mamy weekend!");
		}
	}

}
