package lab4;

public class Equals {
	public static void main(String args[]) {
		String s = "Hello";
		String t = new String(s);
		if ("Hello".equals(s)) {
			System.out.print("One");
			System.out.print(t);
		if (t==s) {
			System.out.print("2");
		}
		if (t.equals(s)) {
			System.out.print("3");
		}
		if("Hello" == s) {
			System.out.print("4");
		}
		if("Hello" == t) {
			System.out.print("5");
		}
		}
	}
}	
