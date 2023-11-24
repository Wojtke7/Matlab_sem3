package lab5;

import java.util.InputMismatchException;
import java.util.Scanner;
public class DrawSquare {

    private static void draw_square(int side){
        for(int i=0; i<side; i++){
            if(i==0 || i == side - 1){
                for(int j=0; j<side; j++){
                    System.out.print("X");
                }
                System.out.print('\n');
            }
            else {
                System.out.print("X");
                for(int j=1; j<side-1; j++){
                    System.out.print(" ");
                }
                System.out.print("X\n");
            }
        }
    }
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Dla boku o długości: ");
        
        try {
            int square_side = scanner.nextInt();
            draw_square(square_side);
        }
        catch (InputMismatchException err){
             System.out.println("Zła wartość!");
             main(args);
        }
    scanner.close();
    }
}