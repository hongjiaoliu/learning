package com.hongjiaoliu.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhj on 2017/12/4.
 * Description : 数组中的重复数字
 * 在一个长度为n的数组里的所有数字都在0至n-1的范围内，数组中某
 * 些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次
 * 请找出数组中任意一个重复的数字，例如如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应输出的是重复的数字2或者3
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class Q3A {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 0, 0, 2, 5, 3};
//        new Q3A().a1(array);
//        new Q3A().a2(array);
        new Q3A().a3(array);
    }

    /**
     * 基于排序算法
     *
     * @param array
     */
    public void a1(int[] array) {
        //先排序数组
        Arrays.sort(array);
        System.out.println("sort number array:" + Arrays.toString(array));
        //循环数组
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                System.out.println("find repetition number:" + array[i]);
            }
        }
    }

    /**
     * 基于Hash表
     *
     * @param array
     */
    public void a2(int[] array) {
        Map map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];

            if (map.containsKey(i1)) {
                int count = (int) map.get(i1);
                map.put(i1, count + 1);
                System.out.println("find repetition number:" + i1 + "-- counts:" + count);
            } else {
                map.put(i1, 1);
            }
        }
    }

    /**
     * 查找空间复杂度为O(1)的算法
     */

    public void a3(int[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int m = array[i];
            System.out.println("loop : " + m);
            if (m == i) {
                System.out.println("continue.");
                continue;
            }
            if (m == array[m]) {
                System.out.println("find a repetition number:" + m);
                continue;
            } else {
                array[i] = array[m];//位置互换
                array[m] = m;//送它去它该在的位置
                i--;//互换之后，注意下标归位
                System.out.println(Arrays.toString(array));
            }
        }
    }


}
