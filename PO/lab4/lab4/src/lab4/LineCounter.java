package lab4;
import java.io.*;

public class LineCounter {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader(args[0]);
		int i;
		while ( (i=reader.read())!= -1 )
			System.out.print((char) i );
		reader.close();
		}
}
