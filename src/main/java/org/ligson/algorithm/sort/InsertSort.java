package org.ligson.algorithm.sort;

/***
 * 插入排序—直接插入排序(Straight Insertion Sort)
 * 
 * @author ligson
 *
 */
public class InsertSort implements ISort {

	@Override
	public void sort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					// TODO:
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					// 接下来是无用功
					break;
				}
			}
		}

	}

	@Override
	public String getName() {
		return "直接插入排序";
	}

}
