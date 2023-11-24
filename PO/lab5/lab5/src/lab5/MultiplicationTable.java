package lab5;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.io.File;
import java.util.Random;

public class MultiplicationTable {

	public static void main(String[] args) throws IOException {
		
		Properties defaultProps = new Properties();
		
		try {
			FileInputStream in = new FileInputStream("settings.properties");
		}
		catch (IOException e) {
			File myObj = new File("settings.properties");
			myObj.createNewFile();
		}
		
		FileInputStream in = new FileInputStream("settings.properties");
		defaultProps.load(in);
		
		defaultProps.setProperty("wartość_minimum", "1");
		defaultProps.setProperty("wartość_maximum", "10");
		defaultProps.setProperty("procent", "70");
		defaultProps.setProperty("powtórzeń_minimum", "10");
		defaultProps.setProperty("powtórzeń_maximum", "25");
		
		FileOutputStream out = new FileOutputStream("settings.properties");
		defaultProps.store(out, "Default properties set");
		out.close();
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int max_val = Integer.valueOf(defaultProps.getProperty("wartość_maximum"));
		float question_counter = 0;
		int max_questions = Integer.valueOf(defaultProps.getProperty("powtórzeń_maximum"));
		int user_reply;
		
		float right_answers = 0;
		
		while (question_counter < max_questions ) {
			
			 if (((right_answers / question_counter) * 100) > 70 && question_counter > 9) {
					break;
				}
			
			int l1 = random.nextInt(max_val) + 1;
			int l2 = random.nextInt(max_val) + 1;
			
			
			System.out.print(l1 + " * " + l2 + " = ");
		    
			try {
		    	user_reply = scanner.nextInt();
		    }
		    catch (InputMismatchException err) {
		    	System.out.println("Odpowiedz to na pewno liczba całkowita! Błąd");
		    	question_counter ++;
		    	scanner.nextLine();
		    	continue;
		    }
		    
		    if (user_reply == l1 * l2) {
		    	right_answers ++;
		    	System.out.println("Poprawna odpowiedz!");
		    }
		    else {
		    	System.out.println("Błędna odpowiedz");
		    }
		    
		    question_counter ++;
		    
		}
		
		float final_percent = (right_answers/question_counter) * 100;
		System.out.println("Twój wynik wyniósł: " + final_percent + "%");
		System.out.println("Odpowiedziałeś poprawnie na: " + right_answers + " z " + question_counter + " pytań.");	
		
		
		in.close();
	}

}
