package advancedLevel;

import java.sql.Time;
import java.util.Scanner;

public class _1006 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int total = sn.nextInt();
		String[] snid = new String[total];
		String[] in = new String[total];
		String[] out = new String[total];
		for (int i = 0; i < total; i++) {
			snid[i] = sn.next();
			in[i] = sn.next();
			out[i] = sn.next();
		}
		sn.close();
		int first = 0;
		int last = 0;
		for (int i = 0; i < total; i++) {
			if (Time.valueOf(in[first]).after(Time.valueOf(in[i])))
				first = i;
			if (Time.valueOf(out[last]).before(Time.valueOf(out[i])))
				last = i;
		}
		System.out.print(snid[first] + " " + snid[last]);
	}
}
