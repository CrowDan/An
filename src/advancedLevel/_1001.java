package advancedLevel;

import java.util.Scanner;

public class _1001 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int x = sn.nextInt();
		int y = sn.nextInt();
		sn.close();
		String low2Zero = x + y < 0 ? "-" : "";
		String str = String.valueOf(Math.abs(x+y));
		String out = "";
		for (; str.length() > 3; str = str.substring(0, str.length() - 3)) {
			out = ","+str.substring(str.length()-3,str.length())+out;
		}
		out = str + out;
		System.out.println(low2Zero+out);
	}
}