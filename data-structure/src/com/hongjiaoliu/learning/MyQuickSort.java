package com.hongjiaoliu.learning;


import java.util.Arrays;

/**
 * @author liuhongjao
 * @date 2019/6/20 15:59
 */

public class MyQuickSort {

	public static void quickSortRecursion(int[] a, int p, int q) {
		if (p >= q) {
			return;
		}
		int r = getDilivedPoint(a, p, q);
		quickSortRecursion(a, p, r - 1);
		quickSortRecursion(a, r + 1, q);
	}

	private static int getDilivedPoint(int[] a, int p, int q) {
		int value = a[q];
		int i = p;
		for (int j = 0; j < q; j++) {
			if (a[j] < value) {
				if (i == j) {
					i++;
				} else {
					int temp = a[i];
					a[i++] = a[j];
					a[j] = temp;
				}
			}
		}

		int temp = a[q];
		a[q] = a[i];
		a[i] = temp;
		return i;
	}


	public static void main(String[] args) {
		int[] array = new int[]{9, 1, 5, 2, 3, 4, 6};
		MyQuickSort.quickSortRecursion(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
}
