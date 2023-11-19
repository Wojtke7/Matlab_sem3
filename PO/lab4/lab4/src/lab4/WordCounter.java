package lab4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class WordCounter {
	
	public static String[] LC = {"-lc", "-cl"};
	public static String[] LW = {"-lw", "-wl"};
	public static String[] CW = {"-cw", "-wc"};
	public static String[] LCW = {"-lcw", "-lwc", "-wcl", "-wlc", "-cwl", "-clw"};
			
			
			
	public static boolean containsAny(String[] arrays, String[] possibleStrings) {
        for (String element : arrays) {
            for (String possibleString : possibleStrings) {
                if (element.equals(possibleString)) {
                    return true;
                }
            }
        }
        return false;
    }
	
	public static int[] fileCounter(String file) throws IOException {
		
		int counter = 0;
		int characters = 0;
		String line;
		int words = 0;
		int[] ArrayOfValues = new int[3];
		
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
			
			ArrayOfValues[0] = counter;
			ArrayOfValues[1] = characters;
			ArrayOfValues[2] = words;
			
			return ArrayOfValues;
		}
		catch (FileNotFoundException e) {
			System.out.println("Nie odnaleziono pliku!");
			return null;
		}
				
	}
	
	public static void main(String[] args) throws IOException {
			
			if (args.length == 0) {
				System.out.println("Brak argumentów programu");
			}
			
			else if((Arrays.stream(args).anyMatch("-l"::equals) && Arrays.stream(args).anyMatch("-c"::equals)) || containsAny(args, LC)) {
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					if (args[i].equals("-l") || args[i].equals("-c") || args[i].equals("-lc") || args[i].equals("-cl") ) {
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
				else if (fileCounter(file_name) != null) {
					System.out.println("Wierszy: " + fileCounter(file_name)[0]);
					System.out.println("Znaków: " + fileCounter(file_name)[1]);
				}
			}
			
			else if((Arrays.stream(args).anyMatch("-l"::equals) && Arrays.stream(args).anyMatch("-w"::equals)) || containsAny(args, LW)) {
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					
					if (args[i].equals("-l") || args[i].equals("-w") || args[i].equals("-lw") || args[i].equals("-wl") ) {
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
				else if (fileCounter(file_name) != null) {
					System.out.println("Wierszy: " + fileCounter(file_name)[0]);
					System.out.println("Słów: " + fileCounter(file_name)[2]);
				}
				
			}
			
			else if ((Arrays.stream(args).anyMatch("-c"::equals) && Arrays.stream(args).anyMatch("-w"::equals)) || containsAny(args, CW))  {
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					
					if (args[i].equals("-c") || args[i].equals("-w") || args[i].equals("-cw") || args[i].equals("-wc") ) {
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
				else if (fileCounter(file_name) != null) {
					System.out.println("Znaków: " + fileCounter(file_name)[1]);
					System.out.println("Słów: " + fileCounter(file_name)[2]);
				}
			} 
			else if((Arrays.stream(args).anyMatch("-c"::equals) && Arrays.stream(args).anyMatch("-w"::equals) && Arrays.stream(args).anyMatch("-l"::equals)) || containsAny(args, LCW)) {
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					
					if (args[i].equals("-l") || args[i].equals("-w") || args[i].equals("-c") || args[i].equals("-wc") || args[i].equals("-cw") || args[i].equals("-lc") || args[i].equals("-cl") || args[i].equals("-wl") || args[i].equals("-lw") || args[i].equals("-wc") || args[i].equals("-clw") || args[i].equals("-lcw") || args[i].equals("-lwc") || args[i].equals("-wcl") || args[i].equals("-wlc") || args[i].equals("-cwl") ) {
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
				else if (fileCounter(file_name) != null) {
					System.out.println("Wierszy: " + fileCounter(file_name)[0]);
					System.out.println("Znaków: " + fileCounter(file_name)[1]);
					System.out.println("Słów: " + fileCounter(file_name)[2]);
				}
			}
			else if(Arrays.stream(args).anyMatch("-c"::equals)){
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					
					if (args[i].equals("-c")) {
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
				else if (fileCounter(file_name) != null) {
					System.out.println("Znaków: " + fileCounter(file_name)[1]);
				}
			}
			
			else if(Arrays.stream(args).anyMatch("-l"::equals)){
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					
					if (args[i].equals("-c")) {
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
				else if (fileCounter(file_name) != null) {
					System.out.println("Wierszy: " + fileCounter(file_name)[0]);
				}
			}
			
			else if(Arrays.stream(args).anyMatch("-w"::equals)){
				String file_name = "default";
				
				for (int i = 0; i < args.length; i++) {
					
					if (args[i].equals("-c")) {
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
				else if (fileCounter(file_name) != null) {
					System.out.println("Słów: " + fileCounter(file_name)[2]);
				}
			}
			else {
				if (fileCounter(args[0]) != null){
					System.out.println("Wierszy: " + fileCounter(args[0])[0]);
					System.out.println("Znaków: " + fileCounter(args[0])[1]);
					System.out.println("Słów: " + fileCounter(args[0])[2]);
				}
			}
	}
}
