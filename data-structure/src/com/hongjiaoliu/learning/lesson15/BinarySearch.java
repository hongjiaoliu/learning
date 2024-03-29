package com.hongjiaoliu.learning.lesson15;

/**
 * 二分查找
 *
 * @author liuhongjao
 * @date 2019/2/28 13:36
 */

public class BinarySearch {

	/**
	 * 用循环实现的二分查找
	 *
	 * @param a 数组
	 * @param n 数组长度
	 * @param v 待查找元素
	 * @return: 查找元素在数组中的下标
	 * @author:liuhongjiao
	 * @date: 2019/2/28 13:38
	 */
	public static int bSearchByCirculation(int[] a, int n, int v) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] == v) {
				return mid;
			}
			if (a[mid] > v) {
				high = mid - 1;
			} else if (a[mid] < v) {
				low = mid + 1;
			}
		}
		return -1;
	}
}
