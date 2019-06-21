package com.hongjiaoliu.learning.lesson12;

import java.util.Arrays;

/**
 * 快速排序
 * 和归并排序一样，使用的也是分治思想，但是思路又是完全不一样的
 * 归并排序的处理过程是由下到上的，先处理子问题，然后再合并。
 * 而快排正好相反，它的处理过程是由上到下的，先分区，然后再处理子问题。
 * 归并排序虽然是稳定的、时间复杂度为 O(nlogn) 的排序算法，但是它是非原地排序算法。
 * 我们前面讲过，归并之所以是非原地排序算法，主要原因是合并函数无法在原地执行。
 * 快速排序通过设计巧妙的原地分区函数，可以实现原地排序，解决了归并排序占用太多内存的问题。
 *
 * @author liuhongjao
 * @date 2019/2/25 13:23
 */

public class QuickSort {

	/**
	 * 快速排序
	 *
	 * @param a : 数组
	 * @param n : 数组大小
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/2/25 14:02
	 */
	public static void quickSort(int[] a, int n) {
		quickSortInternally(a, 0, n - 1);
	}

	/**
	 * 快速排序递归函数
	 *
	 * @param a : 数组
	 * @param p : 数组起始下标
	 * @param r : 数组终止下标
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/2/25 14:03
	 */
	public static void quickSortInternally(int[] a, int p, int r) {
		if (p >= r) {
			return;
		}
		int q = partition(a, p, r);//获取分区点
		System.out.println("左区间：start : " + p + ",end : " + (q - 1));
		System.out.println("右区间：start : " + (q + 1) + ",end : " + r);
		quickSortInternally(a, p, q - 1);
		quickSortInternally(a, q + 1, r);
	}

	/**
	 * 分区函数
	 *
	 * @param a : 数组
	 * @param p : 数组起始下标
	 * @param r : 数组终止下标
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/2/25 14:04
	 */
	public static int partition(int[] a, int p, int r) {
		int pivot = a[r];//默认分区点的值为数组最后一个元素
		int i = p;
		for (int j = p; j < r; ++j) { //从左到右遍历数组
			System.out.println("-- loop i = " + i + ",j = " + j + ",p = " + p + " ,a[j] = " + a[j] + ",pivot = " + pivot);
			if (a[j] < pivot) { //如果当前元素 小于 分区点的值
				if (i == j) { //如果已经是最左侧位置p,向右顺移一位，这里不触发swap交换
					++i;
				} else {//进行交换操作，a[i] 与 a[j]
					int temp = a[i];
					a[i++] = a[j];
					a[j] = temp;
					System.out.println("< ----- > swap ：" + Arrays.toString(a));
				}
			}
		}

		int tmp = a[i];
		System.out.println("《======》一次分区结束，交换a[i] = " + tmp + ",a[r] = " + a[r]);
		a[i] = a[r];
		a[r] = tmp;
		System.out.println("下一次分区点的下标为：" + i + ",分区array : " + Arrays.toString(a));
		return i;
	}

	public static void main(String[] args) {
		int[] array = new int[]{9, 1, 5, 2, 3, 4, 6};
		System.out.println("array : " + Arrays.toString(array));
		QuickSort.quickSort(array, 6);
	}
}
