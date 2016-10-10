package org.ligson.algorithm.sort;

/***
 * 先取一个小于n的整数dt作为第一个增量，把文件的全部记录分成d1个组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，
 * 取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
 * 
 * 所以希尔插入排序和直接插入排序的区别就是增量的区别。
 * 
 * @author ligson
 *
 */
public class ShellInsertSort implements ISort {

	@Override
	public void sort(int[] a) {

		double d1 = a.length;

		int temp = 0;

		while (true) {

			d1 = Math.ceil(d1 / 2);

			int d = (int) d1;

			for (int x = 0; x < d; x++) {

				for (int i = x + d; i < a.length; i += d) {

					int j = i - d;

					temp = a[i];

					for (; j >= 0 && temp < a[j]; j -= d) {

						a[j + d] = a[j];

					}

					a[j + d] = temp;

				}

			}

			if (d == 1)

				break;

		}

	}

	@Override
	public String getName() {
		return "希尔排序";
	}

}
