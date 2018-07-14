package advancedLevel;

import java.util.Scanner;

public class _1008 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int total = sn.nextInt();
		int[] arr = new int[total];
		for(int i = 0;i<total;i++) {
			arr[i] = sn.nextInt();
		}
		sn.close();
		int sum = 0;
		int curr = 0;
		for(int i = 0;i<total;i++) {
			if(arr[i]>curr)
				sum += (arr[i]-curr)*6+5;
			else
				sum += (curr-arr[i])*4+5;
			curr = arr[i];
		}
		System.out.println(sum);
	}

}
