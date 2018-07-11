package advancedLevel;

import java.util.Scanner;

public class _1005 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		String str = sn.next();
		sn.close();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Integer.parseInt(str.substring(i, i + 1));
		}
		String[] result = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
				"nine" };
		String res = String.valueOf(sum);
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<res.length();i++) {
			sb.append(result[Integer.parseInt(res.substring(i, i+1))]+" ");
		}
		System.out.println(sb.toString().trim());
	}

}
