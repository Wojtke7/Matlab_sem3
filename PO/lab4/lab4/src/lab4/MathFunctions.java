package lab4;

public class MathFunctions {
	
	public static void main(String[] args) {
		boolean kontynuuj = true;
		int licznik = 0;
		int x = 3;
		
		while(licznik++ < 3) {
			int y = (1 + 2 * licznik) % 3;
			switch(y) {
			default:
			case 0: x -= 1; break;
			case 1: x += 5;
			}
		}
		System.out.println(x);
	}

}
