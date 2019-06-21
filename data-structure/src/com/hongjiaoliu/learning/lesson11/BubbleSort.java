package com.hongjiaoliu.learning.lesson11;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author liuhongjao
 * @date 2019/2/21 15:04
 */

public class BubbleSort {

	/**
	 * 递归的写法
	 *
	 * @param array：数组
	 * @param length   :数组长度
	 * @author:liuhongjiao
	 * @date: 2019/2/21 15:30
	 */
	public int[] sort(int[] array, int length) {
		if (length <= 1) {
			return array;
		}
		boolean flag = false;
		for (int i = 0; i < array.length - 1; i++) {
			int m = array[i];
			int n = array[i + 1];
			if (n < m) {
				int temp = n;
				array[i + 1] = m;
				array[i] = temp;
				flag = true;
			}
		}
		if (flag) {
			sort(array, 6);
		}
		return array;
	}


	public void bubbleSort(int[] a, int length) {
		if (length <= 1) {
			return;
		}
		for (int i = 0; i < length; ++i) {
			System.out.println("****************************begin; i = " + i);
			boolean flag = false;
			int jTop = length - i - 1;
			// 为什么要这么写，有啥好处？
			// 因为冒泡一次，靠近顶部的元素就已经就位了，就没有必要再次遍历到，这个边界也需要减1，既减少了循环次数，也体现了冒泡排序的精髓
			for (int j = 0; j < jTop; ++j) {
				System.out.println("j:" + j + " jTop:" + jTop);
				int m = a[j];
				int n = a[j + 1];
				System.out.println("a[j] = " + m + " a[j + 1] = " + n);
				if (m > n) { //交换
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true;//表示有数据交换
					System.out.println("[交换一次] - array = " + Arrays.toString(a));
				}
			}
			//没有数据交换，提前退出
			if (!flag) {
				System.out.println("****************************end 已经有序 ; i = " + i + " sortArray = " + Arrays.toString(a));
				break;
			}
			System.out.println("****************************end ; i = " + i + " sortArray = " + Arrays.toString(a));
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{4, 5, 6, 3, 2, 1};
		System.out.println("array:" + Arrays.toString(array));
		Long time1 = System.currentTimeMillis();

		//递归的写法
		/*int[] sortArray = new BubbleSort().sort(array, 6);
		Long time2 = System.currentTimeMillis();
		System.out.println("sortArray:" + Arrays.toString(sortArray) + " --- time costed(ms) : " + (time2-time1));*/

		//非递归的写法
		new BubbleSort().bubbleSort(array, 6);

		//比较
		//递归的写法简单粗暴，循环次数比非递归的多。

	}
}
