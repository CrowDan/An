package advancedLevel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class _1011 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		BigDecimal result = BigDecimal.ONE;
		String str = new String();
		for (int i = 0; i < 3; i++) {
			BigDecimal a = sn.nextBigDecimal();
			BigDecimal b = sn.nextBigDecimal();
			BigDecimal c = sn.nextBigDecimal();
			BigDecimal max = max(a, b, c);
			if (a == max)
				str += "W ";
			else if (b == max)
				str += "T ";
			else
				str += "L ";
			result = result.multiply(max(a, b, c));
		}
		sn.close();
		System.out.println(
				str + (result.multiply(new BigDecimal(0.65)).subtract(BigDecimal.ONE).multiply(BigDecimal.valueOf(2))).setScale(2,RoundingMode.HALF_UP));
	}

	private static BigDecimal max(BigDecimal a, BigDecimal b, BigDecimal c) {
		a = a.compareTo(b) > 0 ? a : b;
		return a.compareTo(c) > 0 ? a : c;
	}
}
