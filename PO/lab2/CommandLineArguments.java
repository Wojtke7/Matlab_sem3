package lab2;

public class CommandLineArguments {

	public static void main(String[] args) {
		int liczbaArgumentow = args.length;
        System.out.println("Liczba argumentów: " + liczbaArgumentow);
       
        int i = 1;
        for (String argument : args) {
            System.out.println(i + "." + argument);
            i ++;
        }
	}

}
