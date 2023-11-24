package lab5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DrawTriangle {

	    private static void draw_triangle(int height){
	        int spaces= height-1;
	        int stars = 1;
	        
	        for (int i=0; i< height; i++){
	            for(int j=0; j<spaces; j++){
	                System.out.print(" ");
	            }
	        
	            for(int j=0; j<stars; j++){
	                System.out.print("X");
	            }
	            System.out.print("\n");
	            stars+=2;
	            spaces--;
	        }
	    }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Dla wysoości trójkąta wynoszącej: ");
		try {
			int triangle_height = scan.nextInt();
			if (triangle_height < 2) {
				System.out.println("Podana wysokość jest za mała! Nie można utowrzyć trójkąta.");
				return;
			}
			draw_triangle(triangle_height);
		}
		catch(InputMismatchException e) {
			System.out.println("Podana wartość jest nieprawidłowa!");
		}
		
	}

}
