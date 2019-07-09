package com.hongjiaoliu.learning.leetcode.p27;

/**
 * LeetCode 27. 删除元素（Remove Element）
 *
 * 问题描述：
 *
 * 给定一个数组nums和一个数值val，直接删除nums中所有值等于val的元素，然后返回nums新的长度。要求，不额外分配空间，空间复杂度要满足O(1)。对元素的顺序没有要求，顺序可以更改。不关心超过nums新长度以外的内容。
 *
 * @author liuhongjao
 * @date 2019/7/9 16:23
 */

public class RemoveElement {

	public static int operate(int[] nums,int val){
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if(nums[j] != val){
				nums[i++] = nums[j];
			}
		}
		return i;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3,2,2,3};
		int operate = RemoveElement.operate(arr, 3);
		System.out.println(operate);
	}
}

