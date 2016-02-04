package org.ligson.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyPaiLie {
	public static void println(int[] objects) {
		System.out.println(Arrays.toString(objects));
	}

	public static List<Integer[]> pailie3(Integer[] arr, int startIdx) {
		List<Integer[]> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			Integer[] arr2 = new Integer[arr.length - 1];
			int idx = 0;
			for (int j = 0; j < arr.length; j++) {
				if (j != i) {
					arr2[idx++] = arr[j];
				}
			}
			List<Integer[]> tmp = new ArrayList<>();
			tmp.add(arr2);
			if (arr2.length > 1) {
				List<Integer[]> list2 = pailie3(arr2, startIdx);
				tmp.addAll(list2);
			}
			list.addAll(tmp);
		}
		return list;
	}

	public static void pailie2(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int obj = arr[i];
			int[] arr2 = new int[arr.length];
			arr2[0] = obj;
			int idx = 1;
			for (int j = 0; j < arr.length; j++) {
				if (j != i) {
					arr2[idx++] = arr[j];
				}
			}
			println(arr2);
		}
	}

	public static int[] pailie(int[] arr, int idx) {
		int arr2[] = new int[arr.length - 1];
		int idx2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != idx) {
				arr2[idx2++] = arr[i];
			}
		}
		int arr3[] = new int[arr.length];
		arr3[0] = arr[idx];
		System.arraycopy(arr2, 0, arr3, 1, arr2.length);

		println(arr3);
		idx = idx + 1;
		if (idx < arr.length) {
			pailie(arr, idx);
		}

		return null;
	}

	public static void main(String args[]) {
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// pailie(arr, 0);
		List<Integer[]> list = pailie3(arr, 0);
		for (Integer[] integers : list) {
			System.out.println(Arrays.toString(integers));
		}
	}
}
