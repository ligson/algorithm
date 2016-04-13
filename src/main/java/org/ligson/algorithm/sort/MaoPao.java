package org.ligson.algorithm.sort;

/***
 * 冒泡排序,时间复杂度O(n^2)
 * 
 * @author ligson
 *
 */
public class MaoPao implements ISort {

	@Override
	public int[] sort(int[] src) {
		int[] dest = new int[src.length];
		System.arraycopy(src, 0, dest, 0, dest.length);
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest.length - 1; j++) {
				if (dest[j] > dest[i]) {
					int tmp = dest[j];
					dest[j] = dest[i];
					dest[i] = tmp;
				}
			}
		}
		return dest;
	}

}
