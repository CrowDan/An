package advancedLevel;

import java.util.Scanner;

public class _1002 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		float[] arr1 = new float[1001];
		float[] arr2 = new float[1001];
		int quanlity1 = sn.nextInt();
		for (int i = 0; i < quanlity1; i++) {
			arr1[sn.nextInt()] = sn.nextFloat();
		}
		int quanlity2 = sn.nextInt();
		for (int i = 0; i < quanlity2; i++) {
			arr2[sn.nextInt()] = sn.nextFloat();
		}
		sn.close();
		float[] arr3 = new float[1001];
		for (int i = 0; i < 1001; i++) {
			arr3[i] = arr1[i] + arr2[i];
		}
		int quantity3 = 0;
		for (int i = 0; i < 1001; i++) {
			if (arr3[i] != 0f) {
				arr3[i] = Math.round(arr3[i]*10)/10f;
				quantity3++;
			}
				
		}
		System.out.print(quantity3);
		for (int i = 10; i >= 0; i--) {
			if (arr3[i] != 0f) {
				System.out.print(" " + i + " " + arr3[i]);
			}
		}
	}
}
