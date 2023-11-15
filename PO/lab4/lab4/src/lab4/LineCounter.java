package lab4;
import java.io.*;

public class LineCounter {

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			int counter = 0;
			while (reader.readLine()!= null ) {
				counter ++;
			}
			System.out.println("Liczba wierszy w pliku " + args[0] + " wynosi: " + counter);
			reader.close();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Brak argumentów programu");
		}
	}
}
