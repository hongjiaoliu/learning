package com.hongjiaoliu.learning.leetcode.p70;

/**
 * LeetCode 70 爬楼梯问题
 *
 * @author liuhongjao
 * @date 2019/7/5 16:34
 */

public class ClimbingStairs {

	public static int solutionWithArray(int n){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		int[] result= new int[n];
		result[0] = 1;
		result[1] = 2;
		for (int i = 2; i < n; i++) {
			result[i] = result[i-1] + result[i-2];
		}
		return result[n-1];
	}

	public static void main(String[] args) {
		System.out.println(ClimbingStairs.solutionWithArray(6));
	}
}
