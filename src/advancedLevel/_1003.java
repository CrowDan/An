package advancedLevel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _1003 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int countryCnt = sn.nextInt();
		int routeCnt = sn.nextInt();
		int begin = sn.nextInt();
		int end = sn.nextInt();
		int[] saverCnt = new int[countryCnt];
		for (int i = 0; i < countryCnt; i++) {
			saverCnt[i] = sn.nextInt();
		}
		int[][] route = new int[countryCnt][countryCnt];
		for (int i = 0; i < countryCnt; i++) {
			for (int j = 0; j < countryCnt; j++) {
				route[i][j] = Integer.MAX_VALUE / 2;
			}
			route[i][i] = 0;
		}
		for (int i = 0; i < routeCnt; i++) {
			int x = sn.nextInt();
			int y = sn.nextInt();
			int z = sn.nextInt();
			route[x][y] = z;
			route[y][x] = z;

		}
		sn.close();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < countryCnt; i++) {
			set.add(i);
		}
		set.remove(begin);

		int[] minRoute = new int[countryCnt];
		int[] maxSaver = new int[countryCnt];
		for (int i = 0; i < countryCnt; i++) {
			minRoute[i] = Integer.MAX_VALUE/3;
			maxSaver[i] = saverCnt[begin];
		}
		minRoute[begin] = 0;
		int minP = begin;

		while (true) {
			
			//int minPr = Integer.MAX_VALUE;
			if (set.size() != 0) {
				for (Integer i : set) {
					if (minRoute[minP] + route[minP][i] < minRoute[i]) {
						minRoute[i] = minRoute[minP] + route[minP][i];
						maxSaver[i] = saverCnt[i] + maxSaver[minP];
					}else if (minRoute[minP] + route[minP][i] == minRoute[i]) {
						maxSaver[i] = saverCnt[i] + maxSaver[minP] > maxSaver[i]?
								saverCnt[i] + maxSaver[minP] : maxSaver[i];
					}
				}
				int minR = Integer.MAX_VALUE;//the minimum route;
				for (Integer i : set) {
					if(minRoute[i]<minR) {
						minR = minRoute[i];
						minP = i;
					}
				}
				set.remove(minP);
			}else {
				break;
			}
			System.out.println(Arrays.toString(minRoute));
			System.out.println(Arrays.toString(maxSaver));
			System.out.println(minP);
		}

		System.out.print(minRoute[end] + " " + maxSaver[end]);

	}
}
/*4 4 0 3
1 0 1 1
0 1 1
0 2 2
2 3 3
1 3 4*/
