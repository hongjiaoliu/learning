package com.hongjiaoliu.learning.lesson11;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author liuhongjao
 * @date 2019/2/21 18:06
 */

public class SelectionSort {

	public void sort2(int[] a, int n) {
		if (n <= 1) {
			return;
		}
		for (int i = 0; i < n; i++) { //  i < n 和 i < n-1 有啥区别？
			int min = a[i];
			int j = i + 1;
			System.out.println("**************** i = " + i + ", j = " + j + ", 当前值 = " + a[i]);
			int minIdex = j;
			for (; j < n; j++) {
				if (a[j] < min) {
					min = a[j];
					minIdex = j;
				}
			}
			System.out.println("*** 交换前 array: " + Arrays.toString(a));
			System.out.println("min = " + min + ",minIdex = " + minIdex + ",a[i] = " + a[i]);
			if (min == a[i]) {
				System.out.println("如果最小值已经是当前值，证明已经有序，直接跳出！");
				continue;
			}
			//j为子数组中最小元素的index
			int temp = a[i];
			a[i] = min;
			a[minIdex] = temp;
			System.out.println("交换位置[" + i + "]和最小值位置[" + minIdex + "]，交换后 array: " + Arrays.toString(a));
		}
	}


	public static void main(String[] args) {
		int[] array = new int[]{4, 5, 6, 3, 2, 1, 5, 6, 3};
		new SelectionSort().sort2(array, 9);
	}
}
