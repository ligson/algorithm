package org.ligson.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 全排列:例如数组[1,2,3]输出 123 132 213 231 312 321
 * 
 * @author ligson
 *
 */
public class FullArray {
	public  int[] array = { 1, 3, 5, 4 };
	public List list = new ArrayList<>();

	private  void swap(int[] arr, int i1, int i2) {
		int temp = arr[i2];
		arr[i2] = arr[i1];
		arr[i1] = temp;
	}

	/***
	 * 递归算法,算法思路: (1)n个元素的全排列=（n-1个元素的全排列）+（另一个元素作为前缀）；
	 * (2)出口：如果只有一个元素的全排列，则说明已经排完，则输出数组；
	 * (3)不断将每个元素放作第一个元素，然后将这个元素作为前缀，并将其余元素继续全排列，等到出口，出口出去后还需要还原数组；
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 */
	public  void recursion(int arr[], int begin, int end) {
		if (end == begin) { // 一到递归的出口就输出数组，此数组为全排列
			System.out.println(Arrays.toString(arr));
			list.add(arr);
		} else {
			for (int j = begin; j <= end; j++) {
				swap(arr, begin, j); // for循环将begin~end中的每个数放到begin位置中去
				recursion(arr, begin + 1, end); // 假设begin位置确定，那么对begin+1~end中的数继续递归
				swap(arr, begin, j); // 换过去后再还原
			}
		}
	}

	public static void main(String[] args) {
		// recursion(array, 0);
		//recursion(array, 0, array.length - 1);
	}
}
