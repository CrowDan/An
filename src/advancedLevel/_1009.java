package advancedLevel;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class _1009 {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		int first = sn.nextInt();
		Map<Integer, Double> m1 = new TreeMap<>();
		for (int i = 0; i < first; i++) {
			m1.put(sn.nextInt(), sn.nextDouble());
		}
		int second = sn.nextInt();
		Map<Integer, Double> m2 = new TreeMap<>();
		for (int i = 0; i < second; i++) {
			m2.put(sn.nextInt(), sn.nextDouble());
		}
		sn.close();
		Map<Integer, Double> out = new TreeMap<>(Comparator.reverseOrder());
		for (Integer i : m1.keySet()) {
			Double v1 = m1.get(i);
			for (Integer j : m2.keySet()) {
				Double v2 = m2.get(j);
				Double o2 = v1 * v2;
				int sum = i + j;
				if (out.containsKey(sum))
					out.put(sum, out.get(sum) + o2);
				else
					out.put(sum, o2);
			}
		}
		String str = "";
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.HALF_UP); 
		Set<Integer> set = out.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int i = it.next();
			if ("0.0".equals(df.format(out.get(i)))||"-0.0".equals(df.format(out.get(i)))) {
				out.remove(i);
				continue;
			}
			str += " " + i + " " + df.format(out.get(i));
		}
		System.out.println(out.size() + str);

	}

}
