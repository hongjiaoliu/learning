package com.hongjiaoliu.offer.topic11;

/**
 * Created by liuhj on 2018/1/11.
 * Description :  剑指Offer面试题11：旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组{3,4,5,1,2}是数组{1,2,3,4,5}的一个旋转，该数组的最小值为1
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class RotateArray {
    /**
     * 查找有序数组中的最小数字
     * 例如：  3   4   5   1   2
     * |       |        |
     * P1     P0        P2
     * P0所指的5大于P1所指的3，则P1指向5
     * 3   4   5   1    2
     * |   |    |
     * P1  P0   P2
     * P0所指的1小于P2所指的2，则P2指向1
     * 3   4    5    1    2
     * |    |
     * P1   P2
     * P1和P2所在下标相差为1，即P2所指的1为查找结果，为最小值
     *
     * @param array
     * @return
     */
    private Integer find(int[] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int minIndex = 0;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                minIndex = index2;
                break;
            }
            minIndex = (index1 + index2) / 2;
            //如果三个下标所指的值均相等，只能采取顺序查找了
            if (array[index1] == array[index2] && array[index1] == array[minIndex]) {
                int inOrder = findInOrder(array);
                return inOrder;
            }
            if (array[minIndex] >= array[index1]) {
                index1 = minIndex;
            } else if (array[minIndex] <= array[index2]) {
                index2 = minIndex;
            }
        }
        return array[minIndex];
    }

    /**
     * 顺序查找最小值
     *
     * @param array
     * @return
     */
    private int findInOrder(int[] array) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= result) {
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        int[] array2 = {1, 0, 1, 1, 1};
        int[] array3 = {1, 1, 1, 0, 1};
        /**
         *    1    0   1    1   1
         *    P1      P0        P2
         *    P0所指的1 等于P1和P2所指的值,只能用顺序查找
         *
         */
        Integer result = new RotateArray().find(array3);
        System.out.println(result);
    }
}
