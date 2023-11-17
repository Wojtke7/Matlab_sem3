package lab4;
import java.io.*;
import javax.swing.JOptionPane;

public class LineCounterPane {

	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Bieżący katalog roboczy: " + System.getProperty("user.dir"));
			String file_name = JOptionPane.showInputDialog("Please provide a file name");
			BufferedReader reader = new BufferedReader(new FileReader(file_name));
			
			int counter = 0;
			while (reader.readLine()!= null ) {
				counter ++;
			}
			System.out.println("Liczba wierszy w pliku " + file_name + " wynosi: " + counter);
			reader.close();
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku");
		}
	}
}
