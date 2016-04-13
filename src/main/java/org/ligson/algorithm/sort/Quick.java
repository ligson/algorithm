package org.ligson.algorithm.sort;

/***
 * 交换排序>-快速排序
 * 
 * @author ligson
 *
 */
public class Quick implements ISort {

	@Override
	public void sort(int[] src) {
		sort(src, 0, src.length - 1);
	}

	public void sort(int arr[], int low, int high) {
		int l = low;
		int h = high;
		int povit = arr[low];

		while (l < h) {
			while (l < h && arr[h] >= povit)
				h--;
			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}
			while (l < h && arr[l] <= povit)
				l++;

			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
		}
		if (l > low)
			sort(arr, low, l - 1);
		if (h < high)
			sort(arr, l + 1, high);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "快速排序";
	}

}
