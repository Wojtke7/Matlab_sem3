package lab4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class WordCounter {
	
	public static int[] fileCounter(String file) throws IOException {
		
		int counter = 0;
		int characters = 0;
		String line;
		int words = 0;
		int ArrayOfValues[];
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while ((line = reader.readLine()) != null ) {
				characters += line.trim().length();
				
				if (line.split("\\s").length == 1 && line.split("\\s")[0].isBlank() == true) {
					
				}
				else {
					words += line.split("\\s").length;
				}
				counter ++;	
			}
			reader.close();
			return 
		}
		catch (FileNotFoundException e) {
			System.out.println("Nie odnaleziono pliku!");
			return null;
		}
				
	}
	
	public static void main(String[] args) throws IOException {
			
		int counter = 0;
		int characters = 0;
		String line;
		int words = 0;
			
			if (args.length == 0) {
				System.out.println("Brak argumentów programu");
			}
			else if((Arrays.stream(args).anyMatch("-l"::equals) && Arrays.stream(args).anyMatch("-c"::equals)) || Arrays.stream(args).anyMatch("-lc"::equals)) {
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					if (args[i].equals("-l") || args[i].equals("-c") || args[i].equals("-lc") ) {
						continue;
					}
					else {
						file_name = args[i];
						break;
					}
				}
				
				if (file_name.equals("default")) {
					System.out.println("Nie podano pliku docelowego!");
				}
				else {
					try {	
					BufferedReader reader = new BufferedReader(new FileReader(file_name));
					
					while ((line = reader.readLine()) != null ) {
						characters += line.trim().length();
						counter ++;	
					}
					
					System.out.println("Wierszy: " + counter);
					System.out.println("Znaków: " + characters);
					reader.close();
					
					}
					catch (FileNotFoundException e) {
						System.out.println("Nie odnaleziono pliku!");
					}
					
				}
			}

			else if((Arrays.stream(args).anyMatch("-l"::equals) && Arrays.stream(args).anyMatch("-w"::equals)) || Arrays.stream(args).anyMatch("-lw"::equals)) {
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					if (args[i].equals("-l") || args[i].equals("-w") || args[i].equals("-lw") ) {
						continue;
					}
					else {
						file_name = args[i];
						break;
					}
				}
				
				if (file_name.equals("default")) {
					System.out.println("Nie podano pliku docelowego!");
				}
				else {
					try {
						BufferedReader reader = new BufferedReader(new FileReader(args[0]));
						
						while ((line = reader.readLine()) != null ) {
							
							if (line.split("\\s").length == 1 && line.split("\\s")[0].isBlank() == true) {
								
							}
							else {
								words += line.split("\\s").length;
							}
							counter ++;	
						}
						
						System.out.println("Wierszy: " + counter);
						System.out.println("Słów:  " + words);
						reader.close();
					}
					catch (FileNotFoundException e) {
						System.out.println("Nie odnaleziono pliku!");
					}
				}
			}

			else  {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(args[0]));
					
					while ((line = reader.readLine()) != null ) {
						characters += line.trim().length();
						
						if (line.split("\\s").length == 1 && line.split("\\s")[0].isBlank() == true) {
							
						}
						else {
							words += line.split("\\s").length;
						}
						counter ++;	
					}
					
					System.out.println("Wierszy: " + counter);
					System.out.println("Znaków: " + characters);
					System.out.println("Słów:  " + words);
					reader.close();
				}
				catch (FileNotFoundException e) {
					System.out.println("Nie odnaleziono pliku!");
				}
			}
		} 
		
		
	}

