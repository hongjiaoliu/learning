package com.hongjiaoliu.learning.lesson11;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author liuhongjao
 * @date 2019/2/21 15:04
 */

public class BubbleSort {

	public void bubbleSort(int[] a, int length) {
		if (length <= 1) {
			return;
		}
		for (int i = 0; i < length; ++i) {
			boolean flag = false;
			int jTop = length - i - 1;
			// 为什么要这么写，有啥好处？
			// 因为冒泡一次，靠近顶部的元素就已经就位了，就没有必要再次遍历到，这个边界也需要减1，既减少了循环次数，也体现了冒泡排序的精髓
			for (int j = 0; j < jTop; ++j) {
				int m = a[j];
				int n = a[j + 1];
				if (m > n) { //交换
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;//表示有数据交换
				}
			}
			//没有数据交换，提前退出
			if (!flag) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{4, 5, 6, 3, 2, 1};
		new BubbleSort().bubbleSort(array, 6);
	}
}
