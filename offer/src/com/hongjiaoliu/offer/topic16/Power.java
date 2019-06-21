package com.hongjiaoliu.offer.topic16;

/**
 * 剑指Offer（第二版）面试题16：数值的整数次方
 * 题目：请事先一个函数，功能类似与Math.power(double base, int exponent)，
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题
 * @author : liuhj
 * @date : 2018/3/23
 * @email : liuohongjiao@weimingedu.com
 */
public class Power {
    public static void main(String[] args) {
        double v = operate1(0, -1);
        System.out.println(v);
    }

    /**
     * 常规解法：时间复杂度为O(n)
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double operate1(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        boolean isNegative = exponent < 0;
        exponent = isNegative ? -exponent : exponent;
        double result = 1d;
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        return isNegative ? 1 / result : result;
    }

    public static double operate2(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        int n = exponent < 0 ? -exponent : exponent;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        double result = operate2(base, n >> 1);//使用了右移运算符代替了除以2，效率高
        result *= result;
        if ((n & 1) == 1) { //用位与运算代替了求余运算符（%）来判断一个数是奇数还是偶数
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

}
