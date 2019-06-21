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

	/**
	 * 用递归实现的二分查找
	 *
	 * @param a 数组
	 * @param n 数组长度
	 * @param v 待查找元素
	 * @return: 查找元素在数组中的下标
	 * @author:liuhongjiao
	 * @date: 2019/2/28 14:56
	 */
	public static int bSearchByRecursion(int[] a, int n, int v) {

		return -1;
	}

	/**
	 * 递归内部逻辑
	 *
	 * @param a    数组
	 * @param low  低位
	 * @param high 高位
	 * @param v    查找的元素
	 * @return:
	 * @author:liuhongjiao
	 * @date: 2019/2/28 14:59
	 */
	private static int recursionInternally(int[] a, int low, int high, int v) {
		if (low > high) {
			return -1;//递归终止条件
		}
		int mid = low + ((high - low) >> 1);
		if (a[mid] == v) {
			return mid;
		}
		if (a[mid] < v) {
			low = mid + 1;
		} else if (a[mid] > v) {
			high = mid - 1;
		}
		return recursionInternally(a, low, high, v);
	}
}
