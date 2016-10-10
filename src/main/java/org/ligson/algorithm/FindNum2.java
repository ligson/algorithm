package org.ligson.algorithm;

public class FindNum2 {
	public static void main(String[] args) {
		int[] nums = new int[5];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		FullArray fullArray = new FullArray();
		fullArray.array = nums;
		fullArray.recursion(fullArray.array, 0, fullArray.array.length-1);
	}
}
