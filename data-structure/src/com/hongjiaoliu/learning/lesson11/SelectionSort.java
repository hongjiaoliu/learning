package com.hongjiaoliu.learning.lesson11;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author liuhongjao
 * @date 2019/2/21 18:06
 */

public class SelectionSort {

	//弊端：交换的次数太多，只要比对比的数据小，就交换一次，可以改进成，先遍历余下子数组获得最小的元素，然后再交换
	public void sort1(int[] a, int n) {
		if (n <= 1) {
			return;
		}
		for (int i = 0; i < n; ++i) {
			System.out.println("******************* i = " + i + ",array = " + Arrays.toString(a));
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[i]) {
					System.out.println("将值" + a[j] + "赋值到位置(" + i + ")上,old array = " + Arrays.toString(a));
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					System.out.println("new array = " + Arrays.toString(a));
				}
			}
		}
		System.out.println("排序完的array : " + Arrays.toString(a));
	}

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
//		new SelectionSort().sort1(array, 6);
		new SelectionSort().sort2(array, 9);
	}
}
