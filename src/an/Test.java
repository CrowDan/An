package an;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

	public static void main(String args[]) {

		DecimalFormat df1 = new DecimalFormat("#.0");
		System.out.println(df1.format(3.15+0.4));
		System.out.println(df1.format(3.45));
		
		df1.setRoundingMode(RoundingMode.HALF_UP);
		System.out.println(df1.format(3.555));
		System.out.println(df1.format(3.45));
		df1.setRoundingMode(RoundingMode.HALF_DOWN);
		System.out.println(df1.format(3.55));
		System.out.println(df1.format(3.45));
		df1.setRoundingMode(RoundingMode.HALF_EVEN);
		System.out.println(df1.format(3.55));
		System.out.println(df1.format(3.45));
		

	 }
}
