package advancedLevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _1012 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int studentQuantity = sn.nextInt();
		int requestQuantity = sn.nextInt();
		Integer[] Carr = new Integer[studentQuantity];
		Integer[] Marr = new Integer[studentQuantity];
		Integer[] Earr = new Integer[studentQuantity];
		Integer[] Aarr = new Integer[studentQuantity];
		Map<Integer, Student> studentMap = new TreeMap<>();
		for (int i = 0; i < studentQuantity; i++) {
			int key = sn.nextInt();
			Student s = new Student();
			s.C = sn.nextInt();
			s.M = sn.nextInt();
			s.E = sn.nextInt();
			s.A = (int) Math.round((s.C + s.M + s.E) / 3.0);
			Carr[i] = s.C;
			Marr[i] = s.M;
			Earr[i] = s.E;
			Aarr[i] = s.A;
			studentMap.put(key, s);
		}
		Arrays.sort(Carr,Comparator.reverseOrder());
		Arrays.sort(Marr,Comparator.reverseOrder());
		Arrays.sort(Earr,Comparator.reverseOrder());
		Arrays.sort(Aarr,Comparator.reverseOrder());
		int[] cSort = new int[101];
		int[] mSort = new int[101];
		int[] eSort = new int[101];
		int[] aSort = new int[101];
		for(int i = 0;i<studentQuantity;i++) {
			if(cSort[Carr[i]]==0)
				cSort[Carr[i]] = i;
			if(mSort[Marr[i]]==0)
				mSort[Marr[i]] = i;
			if(eSort[Earr[i]]==0)
				eSort[Earr[i]] = i;
			if(aSort[Aarr[i]]==0)
				aSort[Aarr[i]] = i;
		}
		String str = new String();
		for (int i = 0; i < requestQuantity; i++) {
			Student s = studentMap.get(sn.nextInt());
			if(s==null) {
				str += "N/A\n";
				continue;
			}
			Character[] out = new Character[studentQuantity];
			out[aSort[s.A]] = 'A';
			if(out[cSort[s.C]] == null)
				out[cSort[s.C]] = 'C';
			if(out[mSort[s.M]] == null)
				out[mSort[s.M]] = 'M';
			if(out[eSort[s.E]] == null)
				out[eSort[s.E]] = 'E';
			for(int j = 0;j<studentQuantity;j++) {
				if(out[j]!=null) {
					str += (1+j)+" "+out[j]+"\n";
					break;
				}
			}
		}
		sn.close();
		System.out.println(str);
	}
//A > C > M > E.
}

class Student {
	int C;
	int M;
	int E;
	int A;
}