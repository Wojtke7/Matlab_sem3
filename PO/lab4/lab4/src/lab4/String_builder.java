package lab4;

public class String_builder {
	
	public static void test(String args[]) {
		StringBuilder sb = new StringBuilder();
		sb.append("aaa").insert(1, "bb").insert(4,"ccc");
		System.out.println(sb);
	}
}
