package advancedLevel;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _1004 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int totalLeveas = sn.nextInt();
		int nonLeaves = sn.nextInt();
		int[] levelNode = new int[totalLeveas];
		int[] haveNode = new int[totalLeveas];
		int[] level = new int[totalLeveas];
		level[0] = 0;
		if (totalLeveas == 0) {
			sn.close();
			return;
		}
		@SuppressWarnings("unchecked")//It may be strange to define a array of collection.
		Set<Integer>[] outSet = new HashSet[totalLeveas];
		levelNode[0] = 1;
		for (int i = 0; i < nonLeaves; i++) {
			int curr = sn.nextInt() - 1;
			HashSet<Integer> set = new HashSet<>();
			int k = sn.nextInt();
			for(int j = 0;j<k;j++) {
				set.add(sn.nextInt()-1);
			}
			outSet[curr] = set;
			
		}
		sn.close();
		for(int i = 0;i<outSet.length;i++) {
			if(outSet[i]==null)
				continue;
			Set<Integer> set = outSet[i];
			for(Integer j:set) {
				level[j] = level[i] + 1;
			}
			levelNode[level[i] + 1] += set.size();
			haveNode[level[i]]++;
		}
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < totalLeveas && levelNode[i] != 0) {
			sb.append(levelNode[i] - haveNode[i] + " ");
			i++;
		}
		System.out.println(sb.toString().trim());
	}
}
