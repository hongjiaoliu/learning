package com.hongjiaoliu.learning;

import java.util.Arrays;

/**
 * 反转数组
 *
 * @author liuhongjao
 * @date 2019/6/20 15:14
 */

public class ArrayReversal {

	public static void reversal(int[] array){
		int length = array.length;

		System.out.println(Arrays.toString(array));
		for (int i = 0; i < length/2; i++) {
			int temp = array[i];
			array[i] = array[length-1-i];
			array[length-1-i] = temp;
		}
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5};
		ArrayReversal.reversal(array);
	}
}
