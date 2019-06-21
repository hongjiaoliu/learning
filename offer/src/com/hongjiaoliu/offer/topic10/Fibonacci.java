package com.hongjiaoliu.offer.topic10;

/**
 * Created by liuhj on 2018/1/10.
 * Description :  剑指Offer面试题10：斐波那契数列
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class Fibonacci {
    /**
     * 题目一：求斐波那契数列的第n项
     * 写一个函数，输入n，求斐波那契数列的第n项。
     */

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
//        long l = new Fibonacci().fibonacci1(50);
//        System.out.println(l);
//        System.out.println(System.currentTimeMillis()-time1);
//        time1 = System.currentTimeMillis();
        long l2 = new Fibonacci().fibonacci2(10);
        System.out.println(l2);
        System.out.println(System.currentTimeMillis() - time1);
    }

    /**
     * 效率低下的递归写法
     *
     * @param n
     * @return
     */
    public long fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * 效率高的算法，去掉了重复的计算
     *
     * @param n
     * @return
     */
    public long fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        long fibonacciOne = 0;
        long fibonacciTwo = 1;
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = fibonacciOne + fibonacciTwo;
            fibonacciOne = fibonacciTwo;
            fibonacciTwo = result;
        }
        return result;
    }


    /**
     * 题目二：青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶总共有多少种跳法。
     * 分析：跳上一级台阶，只有一种跳法；跳上二级台阶，有两种跳法；跳上2级以上台阶，有f(n-1)+f(n-2)种跳法
     */

    public int fibonacci3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result1 = 1;
        int result2 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = result1 + result2;
            result1 = result2;
            result2 = result;
        }
        return result;
    }

}
