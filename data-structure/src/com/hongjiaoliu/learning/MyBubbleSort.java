package com.hongjiaoliu.learning;

/**
 * @author liuhongjao
 * @date 2019/7/9 15:33
 */

public class MyBubbleSort {

	public static void sort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			int jTop = arr.length - i -1;
			boolean hasChange = false;
			for (int j = 0; j < jTop; j++) {
				int left = arr[j];
				int rigth = arr[j+1];
				if(left > rigth){
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					hasChange = true;
				}
			}
			if(!hasChange){
				break;
			}
		}
	}
}
