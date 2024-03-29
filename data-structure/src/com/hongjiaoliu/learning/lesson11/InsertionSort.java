package com.hongjiaoliu.learning.lesson11;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author liuhongjao
 * @date 2019/2/21 17:17
 */

public class InsertionSort {
	public void sort(int[] a, int n) {
		if (n <= 1) {
			return;
		}
		for (int i = 1; i < n; ++i) {
			int value = a[i];
			int j = i - 1;
			System.out.println("****************** Begin , i = " + i + "，value = " + value + "，j = " + j);
			//查找插入的位置
			for (; j >= 0; --j) {
				if (a[j] > value) {
					a[j + 1] = a[j];//数据往后移动一位
					System.out.println(a[j + 1] + " - 往后移动一位 , array = " + Arrays.toString(a));
				} else {
					break;
				}
			}
			a[j + 1] = value;//插入数据
			System.out.println("插入数据 （" + value + "）到位置" + (j + 1) + "后，array = " + Arrays.toString(a));
		}
		System.out.println("sorted array = " + Arrays.toString(a));
	}

	public static void main(String[] args) {
		int[] array = new int[]{4, 5, 6, 3, 2, 1};
		new InsertionSort().sort(array, 6);
	}
}
