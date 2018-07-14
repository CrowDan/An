package advancedLevel;

import java.util.Scanner;

public class _1007 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int total = sn.nextInt();
		int[] arr = new int[total];
		for (int i = 0; i < total; i++) {
			arr[i] = sn.nextInt();
		}
		sn.close();
		int max = arr[0];
		int begin = 0;
		int end = total-1;
		for (int i = 0; i < total; i++) {
			int sum = 0;
			for (int j = i; j < total; j++) {
				sum += arr[j];
				if (sum > max) {
					max = sum;
					begin = i;
					end = j;
				}
			}
		}
		if (max < 0)
			max = 0;
		System.out.print(max + " " + arr[begin] + " " + arr[end]);
	}

}
