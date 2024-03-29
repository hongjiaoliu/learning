package com.hongjiaoliu.learning.lesson12;

import java.util.Arrays;

/**
 * 归并排序
 * 分治是一个编程思想，递归是编程方法
 *
 * @author liuhongjao
 * @date 2019/2/22 14:11
 */

public class MergeSort {

	public void sort(int[] a, int n) {
		mergeSub(a, 0, n - 1);
	}

	public void mergeSub(int[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {//终止条件
			System.out.println("stop...........");
			return;
		}
		//取到p和r的中间位置q   !!!!!!!!!!!!!!! 这里错了
//		int minddleIndex = (startIndex + endIndex) / 2;
		// 取到中间位置 !!!!!!!!!!!!!!!!!!!,避免startIndex + endIndex 超出整数最大值
		int middleIndex = startIndex + (endIndex - startIndex) / 2;
		// 分治递归
		mergeSub(array, startIndex, middleIndex);
		mergeSub(array, middleIndex + 1, endIndex);
		//将array[startIndex....middleIndex] 和 array[middleIndex+1....endIndex]合并成一个数组
		merge(array, startIndex, middleIndex, endIndex);
	}

	private void merge(int[] array, int startIndex, int middleIndex, int endIndex) {
		int tempLeftIndex = startIndex;
		int tempRightIndex = middleIndex + 1;
		int tempIndex = 0;
		//申请一个大小跟array[startIndex....endIndex]一致的临时数组
		int[] temp = new int[endIndex - startIndex + 1];
		while (tempLeftIndex <= tempRightIndex && tempRightIndex <= endIndex) {
			if (array[tempLeftIndex] < array[tempRightIndex]) {
				temp[tempIndex++] = array[tempLeftIndex++];
			} else {
				temp[tempIndex++] = array[tempRightIndex++];
			}
		}
		// 看下哪部分的数组没有遍历完
		int start = tempLeftIndex;
		int end = middleIndex;
		if (tempRightIndex < endIndex) {
			start = tempRightIndex;
			end = endIndex;
		}
		//将剩余部分未搬移的数组进行拷贝
		while (start<=end){
			temp[tempIndex++] = array[start++];
		}

		// 将tmp中的数组拷贝回a[p...r]
		for (int i = 0; i <= endIndex-startIndex; ++i) {
			array[startIndex+i] = temp[i];
		}
	}


	public static void main(String[] args) {
		int[] array = new int[]{1, 6, 5, 2, 3, 4};
		int[] array2 = new int[]{4, 3, 2, 6, 5, 1};
		new MergeSort().sort(array, 6);
		System.out.println("arrays = " + Arrays.toString(array));
	}


}
