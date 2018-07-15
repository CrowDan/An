package advancedLevel;

import java.math.BigInteger;
import java.util.Scanner;

public class _1010 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		String first = sn.next();
		String second = sn.next();
		int tag = sn.nextInt();
		int radix = sn.nextInt();
		
		sn.close();
		BigInteger value = BigInteger.ZERO;
		boolean flag = false;
		if (tag == 1) {
			value = new BigInteger(first,radix);
			//According to my experience,the radix may over 36.
			for (int i = 2; i <= 36; i++) {
				try {
					BigInteger other = new BigInteger(second,i);
					if (value.equals(other)) {
						flag = true;
						System.out.println(i);
						break;
					}
				} catch (Exception e) {
					continue;

				}
			}
		} else {
			value = new BigInteger(second,radix);
			for (int i = 2; i <= 36; i++) {
				try {
					BigInteger other = new BigInteger(first,i);
					if (value.equals(other)) {
						flag = true;
						System.out.println(i);
						break;
					}
				} catch (Exception e) {
					continue;

				}
			}
		}
		if (!flag)
			System.out.println("Impossible");
	}

}
