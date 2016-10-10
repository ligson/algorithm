package org.ligson.algorithm;

import java.util.Arrays;

/***
 * 找到1-5000中所有加起来等于5000的组合
 * 
 * @author ligson
 *
 */
public class FindNum {
	public static void main(String[] args) {
		int[] nums = new int[5000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		System.out.println(Arrays.toString(nums));
		find2(new int[0]);
	}

	static int num = 2;
	public static void find2(int[] current){
		for(int i = 1;i<=5000;i++){
			int sum = 0;
			for(int j = 0;j<current.length;j++){
				sum+=current[j];
			}
			if(i+sum==5000){
				for(int j = 0;j<current.length;j++){
					System.out.print(current[j]+" + ");
				}
				System.out.println(i+" = 5000");
			}
			int[] currents = new int[current.length+1];
			for(int j=0;j<current.length;j++){
				currents[j] = current[j];
			}
			currents[current.length]=i;
			find2(currents);
		}
	}
	public static void find() {
		int count = 0;
		// while (true) {
		for (int i = 1; i <= 5000; i++) {
			for (int j = 1; j <= 5000; j++) {
				if (i + j == 5000) {
					System.out.println(i + "+" + j + "=5000");
					count++;
				}
			}
		}
		count = 0;
		for (int i = 1; i <= 5000; i++) {
			for (int j = 1; j <= 5000; j++) {
				for (int k = 1; k <= 5000; k++) {
					if ((i + j + k) == 5000) {
						System.out.println(i + "+" + j + "+" + k + "=5000");
						count++;
					}
				}

			}
		}

		if (count == 0) {
			// break;
		}
		// }
	}
}
