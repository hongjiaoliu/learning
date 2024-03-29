package com.hongjiaoliu.learning;

/**
 * 字符串转数字
 *
 * @author liuhongjao
 * @date 2019/6/21 13:21
 */

public class MyStringToNum {
	public static int operate(String str){
		int result = 0;
		if(str == null || str.equals("")){
			throw new NumberFormatException("null");
		}
		int len = str.length();
		char c1 = str.charAt(0);
		boolean isNegative = (c1 == '-');
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if(c >= '0' && c <= '9' ){
				result = result * 10 + (int)(c - '0');
			}else if(c != '-'){
				throw new IllegalArgumentException("s中只能包含数字");
			}
			if(i == len -1 ){
				result = isNegative ? result * (-1) : result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(MyStringToNum.operate("-123458"));
	}
}
