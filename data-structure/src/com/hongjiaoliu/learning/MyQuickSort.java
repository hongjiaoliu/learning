package com.hongjiaoliu.learning;


import java.util.Arrays;

/**
 * @author liuhongjao
 * @date 2019/6/20 15:59
 */

public class MyQuickSort {

	public static void quickSortInternally(int[] a, int p, int r) {
		if (p >= r) {
			return;
		}

		int partition = partition(a, p, r);
		quickSortInternally(a, p, partition - 1);
		quickSortInternally(a, partition + 1, r);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * 获取分区点
	 *
	 * @param a
	 * @return
	 */
	private static int partition(int[] a, int p, int r) {
		int i = p;
		int privot = a[r];
		for (int j = p; j < r; j++) {
			if (a[j] < privot) {
				if (i == j) {
					++i;
				} else {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
				}
			}
		}

		// 最后交换 a[i] 与 a[r]
		int temp = a[i];
		a[i] = a[r];
		a[r] = temp;
		return i;
	}

	public static void main(String[] args) {
		int[] array = new int[]{9, 1, 5, 2, 3, 4, 6};
		MyQuickSort.quickSortInternally(array, 0, array.length - 1);
	}
}
