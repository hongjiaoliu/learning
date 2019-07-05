package com.hongjiaoliu.learning;

/**
 * 二分查找练习
 *
 * @author liuhongjao
 * @date 2019/7/3 9:00
 */

public class MyBinarySearch {

	public static int search(int[] array, int val) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (array[middle] == val) {
				return middle;
			}
			if (array[middle] > val) {
				high = middle - 1;
			}
			if (array[middle] < val) {
				low = middle + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,4,7,9,10,11};
		int search = MyBinarySearch.search(arr, 11);
		System.out.println(search);
	}
}
