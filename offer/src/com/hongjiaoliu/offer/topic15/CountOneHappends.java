package com.hongjiaoliu.offer.topic15;

/**
 * 剑指Offer面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如，把9表示成二进制数是1001，有两位是1，
 * 因此如果输入9，则输出会是2.
 *
 * @author : liuhj
 * @date : 2018/3/22
 * @email : liuohongjiao@weimingedu.com
 */
public class CountOneHappends {
    public static void main(String[] args) {
        System.out.println(numOf1(9));
    }

    public static int numOf1(int n) {
        int count = 0;
        while (n > 0) {
            System.out.println("n:"+n);
            count++;
            System.out.println("n: " + Integer.toBinaryString(n));
            System.out.println("n-1: " + Integer.toBinaryString(n-1));
            n = (n - 1) & n;
            System.out.println("(n-1)&n: " + Integer.toBinaryString(n));
        }
        return count;
    }
}
