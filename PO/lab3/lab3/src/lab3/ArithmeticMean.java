package lab3;

public class ArithmeticMean {

	public static void main(String[] args) {
		int liczbaDanych = args.length;
		
		if (liczbaDanych == 0) {
			System.out.println("Brak przekazanych wartości!");
		}
		else if (liczbaDanych == 1) {
			System.out.println("Przekazano tylko jedną wartość: " + args[0]);
		}
		
		else {
			int suma = 0;
			for (int i = 0; i < liczbaDanych; i++) {
				suma += Integer.parseInt(args[i]);
			}
			
			int srednia = suma / liczbaDanych;
			int reszta = suma % liczbaDanych;
			
			if (reszta != 0) {
				System.out.println("Średnia: " + srednia + " reszta: " + reszta);
			}
			else {
				System.out.println("Średnia wynosi: " + srednia);
			}
		}
			
	}
	
}
