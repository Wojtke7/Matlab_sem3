package lab6;

public class AM {

	public static void main(String[] args) {
		int sum = Integer.parseInt(args[0]);
		String wynik = "Średnia arytmetyczna liczb: "+sum;
		for (int i = 1; i<args.length; i++) {
			wynik += ","+args[i];
			sum += Integer.parseInt(args[i]);
		}
		System.out.println(wynik+ " wynosi "
			+sum/args.length+(sum%args.length==0 ? "" : ",reszta:"
			+sum%args.length));
	}

}
