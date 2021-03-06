package org.ligson.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.ligson.classloader.MyClassLoader;

public class Main {
	public static int[] array = new int[] { 12, 33, 434, 45, 56, 67, 8, 76, 45, 45, 45, 58, 85, 4, 5, 6, 5, 4, 56, 54,
			655, 46, 58, 22, 44, 9552, 4149, 54 };
	public static int[] dest = new int[array.length];

	public static void reset() {
		System.arraycopy(array, 0, dest, 0, array.length);
	}

	public static void println(Object object) {
		if (object.getClass().isArray()) {
			// println(object.getClass().getComponentType().isPrimitive());
			int len = Array.getLength(object);
			StringBuilder builder = new StringBuilder("[");
			for (int i = 0; i < len; i++) {
				if (i != len - 1) {
					builder.append(Array.get(object, i)).append(",");
				} else {
					builder.append(Array.get(object, i));
				}
			}
			builder.append("]");
			println(builder);
		} else {
			System.out.println(object);
		}
	}

	public static void main(String[] args) {
		reset();
		ISort iSort = new MaoPao();
		iSort.sort(dest);
		println(dest);

		reset();
		iSort = new Quick();
		iSort.sort(dest);
		println(dest);

		reset();
		iSort = new InsertSort();
		iSort.sort(dest);
		println(dest);

		reset();
		iSort = new ShellInsertSort();
		iSort.sort(dest);
		println(dest);

		println(Object.class.getClasses());
	
	}
}
