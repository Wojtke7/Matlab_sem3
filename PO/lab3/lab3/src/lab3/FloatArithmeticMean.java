package lab3;

public class FloatArithmeticMean {

	public static void main(String[] args) {
		float liczbaDanych = args.length;
		
		if (liczbaDanych == 0) {
			System.out.println("Brak argumentów programu");
		}
		else if (liczbaDanych == 1) {
			System.out.println("Przekazano tylko jedną wartość: " + (args[0]));
		}
		
		else {
			float suma = 0;
			for (int i = 0; i < liczbaDanych; i++) {
				float num = Float.parseFloat(args[i]);
				suma += num;
		        System.out.printf("%.3f%n", num);
			}
			
			System.out.println("-----------------------");
			System.out.format("%.3f%n", suma);
			
			float Mean = suma / liczbaDanych;
			
			System.out.printf("Średnia arytmetyczna: %.4f%n", Mean);			
		}
	}

}
